package com.likeits.simple.adapter.div_provider.Custom;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.adapter.div_provider.home.MainHomeAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.CustomPageTitleModel;
import com.likeits.simple.network.model.home.HomeMessage;
import com.likeits.simple.network.model.home.MainHomeBannerModel;
import com.likeits.simple.network.model.home.MainHomeBlankModel;
import com.likeits.simple.network.model.home.MainHomeCouponModel;
import com.likeits.simple.network.model.home.MainHomeGoodModel;
import com.likeits.simple.network.model.home.MainHomeListmenuModel;
import com.likeits.simple.network.model.home.MainHomeMenuModel;
import com.likeits.simple.network.model.home.MainHomeNoticeModel;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.network.model.home.MainHomePictureModel;
import com.likeits.simple.network.model.home.MainHomePicturewModel;
import com.likeits.simple.network.model.home.MainHomeSearch01Model;
import com.likeits.simple.network.model.home.MainHomeSearchModel;
import com.likeits.simple.network.model.home.MainHomeSeckillgroupModel;
import com.likeits.simple.network.model.home.MainHomeTitleModel;
import com.likeits.simple.network.model.home.MainHomeVideoModel;
import com.likeits.simple.network.model.home.MainHomekitchenwindowModel;
import com.likeits.simple.utils.HttpUtil;
import com.likeits.simple.utils.StringUtil;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CustomActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.ll_title)
    LinearLayout ll_title;
    @BindView(R.id.ll_search)
    LinearLayout mLLSearch;
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


    private String id;
    private JSONArray items;
    private List<HomeMessage> mMessages;
    private MainHomeAdapter adapter;
    private CustomPageTitleModel pagerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        id = getIntent().getExtras().getString("id");
        initData();
    }

    private void initData() {
        loaddingDialog.show();
        String url = ApiService.Custom_diyPage;
        RequestParams params = new RequestParams();
        params.put("id", id);
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {
                XLog.json(response);
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    String msg = object.optString("msg");
                    if (code == 200) {
                        JSONObject object1 = object.optJSONObject("data");
                        JSONObject object2 = object1.optJSONObject("page");//page数据
                        items = object1.optJSONArray("items"); //items数据
                        pagerModel = JSON.parseObject(object2.toString(), CustomPageTitleModel.class);
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
        if ("1".equals(pagerModel.getShowtitlebar())) {
            ll_title.setVisibility(View.VISIBLE);
            RelativeLayout titleBar = findView(R.id.titleBar);
            TextView tvTitle = findView(R.id.title);
            ImageView toolbar_left_iv = findView(R.id.toolbar_left_iv);
            TextView toolbar_righ_tv01 = findView(R.id.toolbar_righ_tv01);
            setBackView();
            tvTitle.setVisibility(View.VISIBLE);
            toolbar_left_iv.setVisibility(View.VISIBLE);
            if("1".equals(pagerModel.getPage_right())){
                toolbar_righ_tv01.setVisibility(View.VISIBLE);
            }else{
                toolbar_righ_tv01.setVisibility(View.GONE);
            }

            tvTitle.setText(pagerModel.getTitle());
            titleBar.setBackgroundColor(Color.parseColor("#FFFFFF"));
            tvTitle.setTextColor(Color.parseColor("#000000"));
            Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");

            toolbar_righ_tv01.setTypeface(iconTypeface);
            toolbar_righ_tv01.setTextColor(Color.parseColor(pagerModel.getPage_rightcolor()));
            toolbar_righ_tv01.setText(StringUtil.decode("\\u" + pagerModel.getPage_righticoncode()));
        } else {
            ll_title.setVisibility(View.GONE);
        }
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMessages = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String id = items.optJSONObject(i).optString("id");
            if ("fixedsearch".equals(id)) {//搜索
                mainHomeSearchModel = JSON.parseObject(items.optString(i), MainHomeSearchModel.class);
                initSearch();
                //  mMessages.add(mainHomeSearchModel);
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
            } else if ("seckillgroup".equals(id)) {//秒杀
                MainHomeSeckillgroupModel mainHomeSeckillgroupModel = JSON.parseObject(items.optString(i).toString(), MainHomeSeckillgroupModel.class);
                mMessages.add(mainHomeSeckillgroupModel);
            }
        }

        XLog.e("TAG888" + mMessages);
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

        Typeface iconTypeface = Typeface.createFromAsset(this.getAssets(), "iconfont.ttf");

        llSearchbg.setBackgroundColor(Color.parseColor(mainHomeSearchModel.getStyle().getBackground()));
        if ("".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(this.getResources().getDrawable(R.drawable.shape_search_round_0));
        } else if ("round".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(this.getResources().getDrawable(R.drawable.shape_search_round_20));
        } else if ("circle".equals(mainHomeSearchModel.getParams().getSearchstyle())) {
            llSearch.setBackground(this.getResources().getDrawable(R.drawable.shape_search_round_10));
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
    }

    private boolean isErr;

    @Override
    public void onRefresh() {
        initData();
    }
}
