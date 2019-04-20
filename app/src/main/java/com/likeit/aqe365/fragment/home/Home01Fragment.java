package com.likeit.aqe365.fragment.home;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.SearchLayoutActivity;
import com.likeit.aqe365.adapter.div_provider.home.MainHomeAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.ApiService;
import com.likeit.aqe365.network.model.home.HomeMessage;
import com.likeit.aqe365.network.model.home.MainHomeBannerModel;
import com.likeit.aqe365.network.model.home.MainHomeBlankModel;
import com.likeit.aqe365.network.model.home.MainHomeCategroupsModel;
import com.likeit.aqe365.network.model.home.MainHomeCouponModel;
import com.likeit.aqe365.network.model.home.MainHomeGoodModel;
import com.likeit.aqe365.network.model.home.MainHomeListmenuModel;
import com.likeit.aqe365.network.model.home.MainHomeMarkingModel;
import com.likeit.aqe365.network.model.home.MainHomeMenuModel;
import com.likeit.aqe365.network.model.home.MainHomeMerchgroupsModel;
import com.likeit.aqe365.network.model.home.MainHomeNoticeModel;
import com.likeit.aqe365.network.model.home.MainHomePagerModel;
import com.likeit.aqe365.network.model.home.MainHomePictureModel;
import com.likeit.aqe365.network.model.home.MainHomePicturewModel;
import com.likeit.aqe365.network.model.home.MainHomeSearch01Model;
import com.likeit.aqe365.network.model.home.MainHomeSearchModel;
import com.likeit.aqe365.network.model.home.MainHomeSeckillgroupModel;
import com.likeit.aqe365.network.model.home.MainHomeTitleModel;
import com.likeit.aqe365.network.model.home.MainHomeVideoModel;
import com.likeit.aqe365.network.model.home.MainHomekitchenwindowModel;
import com.likeit.aqe365.utils.HttpUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.city.CityPickerActivity;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home01Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int REQUEST_CODE_PICK_CITY = 233;

    @BindView(R.id.ll_search)
    RelativeLayout mLLSearch;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    /**
     * 搜索框
     */
    @BindView(R.id.ll_search_bg)
    LinearLayout llSearchbg;//背景
    @BindView(R.id.search_layout)
    LinearLayout llSearch;//搜索框
    @BindView(R.id.search_content_et)
    TextView tvContent;//搜索框内容
    @BindView(R.id.tv_left)
    TextView tvLeft;//左按钮
    @BindView(R.id.tv_right)
    TextView tvRight;//右按钮
    @BindView(R.id.search_address)
    TextView search_address;//定位
    private String city;
    private JSONArray items;
    private List<HomeMessage> mMessages;
    private MainHomeAdapter adapter;
    @Override
    protected int setContentView() {
        return R.layout.fragment_home01;
    }

    @Override
    protected void lazyLoad() {
        city = SharedPreferencesUtils.getString(getContext(), "city");
        initData();
    }
    private void initData() {

        loaddingDialog.show();
        String url = ApiService.Main_Home;
        RequestParams params = new RequestParams();
        params.put("openid", "");
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {
                //XLog.json(response);
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    String msg = object.optString("msg");
                    if (code == 200) {
                        JSONObject object1 = object.optJSONObject("data");
                        JSONObject object2 = object1.optJSONObject("page");//page数据
                        items = object1.optJSONArray("items"); //items数据
                        MainHomePagerModel pagerModel = JSON.parseObject(object2.toString(), MainHomePagerModel.class);
                      //  XLog.e(pagerModel);
                        //XLog.e(items);
                        initUI();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable e) {
                loaddingDialog.dismiss();
                XLog.e(e);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                loaddingDialog.dismiss();
            }
        });
    }

    MainHomeSearchModel mainHomeSearchModel;

    private void initUI() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessages = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String id = items.optJSONObject(i).optString("id");
            if ("fixedsearch".equals(id)) {//搜索
                mainHomeSearchModel = JSON.parseObject(items.optString(i), MainHomeSearchModel.class);
                initSearch();
                // mMessages.add(mainHomeSearchModel);
            } else if ("banner".equals(id)) {//轮播
                MainHomeBannerModel mainHomeBannerModel = JSON.parseObject(items.optString(i), MainHomeBannerModel.class);
                mMessages.add(mainHomeBannerModel);
            } else if ("title".equals(id)) {//标题
                MainHomeTitleModel mainHomeTitleModel = JSON.parseObject(items.optString(i), MainHomeTitleModel.class);
                mMessages.add(mainHomeTitleModel);
            } else if ("goods".equals(id)) {//商品
                MainHomeGoodModel mainHomeGoodModel = JSON.parseObject(items.optString(i), MainHomeGoodModel.class);
                mMessages.add(mainHomeGoodModel);
            } else if ("kitchenwindow".equals(id)) {//橱窗
                MainHomekitchenwindowModel mainHomekitchenwindowModel = JSON.parseObject(items.optString(i), MainHomekitchenwindowModel.class);
                mMessages.add(mainHomekitchenwindowModel);
            } else if ("picturew".equals(id)) {//图片组
                MainHomePicturewModel mainHomePicturewModel = JSON.parseObject(items.optString(i).toString(), MainHomePicturewModel.class);
                mMessages.add(mainHomePicturewModel);
            } else if ("listmenu".equals(id)) {//列表菜单
                MainHomeListmenuModel mainHomeListmenuModel = JSON.parseObject(items.optString(i).toString(), MainHomeListmenuModel.class);
                mMessages.add(mainHomeListmenuModel);
            } else if ("menu".equals(id)) {//菜单
                MainHomeMenuModel mainHomeMenuModel = JSON.parseObject(items.optString(i).toString(), MainHomeMenuModel.class);
                mMessages.add(mainHomeMenuModel);
            } else if ("notice".equals(id)) {//公告
                MainHomeNoticeModel mainHomeNoticeModel = JSON.parseObject(items.optString(i).toString(), MainHomeNoticeModel.class);
                mMessages.add(mainHomeNoticeModel);
            } else if ("search".equals(id)) {//搜索
                MainHomeSearch01Model mainHomeSearch01Model = JSON.parseObject(items.optString(i).toString(), MainHomeSearch01Model.class);
                mMessages.add(mainHomeSearch01Model);
            } else if ("coupon".equals(id)) {//优惠卷
                MainHomeCouponModel mainHomeCouponModel = JSON.parseObject(items.optString(i).toString(), MainHomeCouponModel.class);
                mMessages.add(mainHomeCouponModel);
            } else if ("video".equals(id)) {//视频
                MainHomeVideoModel mainHomeVideoModel = JSON.parseObject(items.optString(i).toString(), MainHomeVideoModel.class);
                mMessages.add(mainHomeVideoModel);
            } else if ("blank".equals(id)) {//空白区域
                MainHomeBlankModel mainHomeBlankModel = JSON.parseObject(items.optString(i).toString(), MainHomeBlankModel.class);
                mMessages.add(mainHomeBlankModel);
            } else if ("picture".equals(id)) {//图片
                MainHomePictureModel mainHomePictureModel = JSON.parseObject(items.optString(i).toString(), MainHomePictureModel.class);
                mMessages.add(mainHomePictureModel);
            } else if ("seckillgroup".equals(id)) {//类别组
                MainHomeSeckillgroupModel mainHomeSeckillgroupModel = JSON.parseObject(items.optString(i).toString(), MainHomeSeckillgroupModel.class);
                mMessages.add(mainHomeSeckillgroupModel);
            } else if ("merchgroups".equals(id)) {//店铺组
                MainHomeMerchgroupsModel mainHomeMerchgroupsModel = JSON.parseObject(items.optString(i).toString(), MainHomeMerchgroupsModel.class);
                mMessages.add(mainHomeMerchgroupsModel);
            }else if ("categroups".equals(id)) {//类别组
                MainHomeCategroupsModel mainHomeCategroupsModel = JSON.parseObject(items.optString(i).toString(), MainHomeCategroupsModel.class);
                mMessages.add(mainHomeCategroupsModel);
            }else if ("marketing".equals(id)) {//类别组
                MainHomeMarkingModel mainHomeMarkingModel = JSON.parseObject(items.optString(i).toString(), MainHomeMarkingModel.class);
                mMessages.add(mainHomeMarkingModel);
            }
        }

        //XLog.e("TAG888" + mMessages);
        mSwipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                //    mCurrentCounter = PAGE_SIZE;
                // pageNum = 1;//页数置为1 才能继续重新加载
                mSwipeRefreshLayout.setRefreshing(false);
                adapter = new MainHomeAdapter(mMessages);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                adapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }


    private void initSearch() {
        mLLSearch.setVisibility(View.VISIBLE);

        Typeface iconTypeface = Typeface.createFromAsset(getActivity().getAssets(), "iconfont.ttf");

        llSearchbg.setBackgroundColor(Color.parseColor(mainHomeSearchModel.getStyle().getBackground()));
        String opacity = mainHomeSearchModel.getStyle().getOpacity();
        int color = (int) Math.ceil(Double.valueOf(opacity) * 255);
        XLog.e("color-->" + color);
        llSearchbg.getBackground().mutate().setAlpha(color);
        if ("".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(getActivity().getResources().getDrawable(R.drawable.shape_search_round_0));
        } else if ("round".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(getActivity().getResources().getDrawable(R.drawable.shape_search_round_20));
        } else if ("circle".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(getActivity().getResources().getDrawable(R.drawable.shape_search_round_10));
        }
        if("1".equals(mainHomeSearchModel.getParams().getIslocation())){
            search_address.setVisibility(View.VISIBLE);
            search_address.setText("中山");
        }else{
            search_address.setVisibility(View.GONE);
        }
        llSearch.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(mainHomeSearchModel.getStyle().getSearchbackground())));
        tvContent.setHintTextColor(Color.parseColor(mainHomeSearchModel.getStyle().getSearchtextcolor()));
        tvContent.setText(mainHomeSearchModel.getParams().getPlaceholder());
        tvLeft.setTypeface(iconTypeface);
        tvRight.setTypeface(iconTypeface);
        if ("0".equals(mainHomeSearchModel.getParams().getLeftnav())) {
            tvLeft.setVisibility(View.GONE);
        } else {
            tvLeft.setVisibility(View.VISIBLE);
        }
        if ("0".equals(mainHomeSearchModel.getParams().getRightnav())) {
            tvRight.setVisibility(View.GONE);
        } else {
            tvRight.setVisibility(View.VISIBLE);
        }

        tvLeft.setTextColor(Color.parseColor(mainHomeSearchModel.getStyle().getLeftnavcolor()));
        tvRight.setTextColor(Color.parseColor(mainHomeSearchModel.getStyle().getRightnavcolor()));
        tvLeft.setText(StringUtil.decode("\\u" + mainHomeSearchModel.getParams().getLeftnaviconcode()));
        tvRight.setText(StringUtil.decode("\\u" + mainHomeSearchModel.getParams().getRightnaviconcode()));
        llSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchLayoutActivity.class);
                startActivity(intent);
            }
        });
        search_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CityPickerActivity.class);
                intent.putExtra("city", city);
                startActivityForResult(intent, REQUEST_CODE_PICK_CITY);
            }
        });
    }

    private boolean isErr;

    @Override
    public void onRefresh() {
        initData();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY) {
            if (data != null) {
                city = data.getStringExtra("date");
                search_address.setText(city);
                //initData(1, false);
            }
        }
    }
}
