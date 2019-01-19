package com.likeits.simple.fragment.goods;


import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.adapter.div_provider.good.GoodDetailAdapter;
import com.likeits.simple.adapter.div_provider.home.MainHomeAdapter;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.gooddetails.GoodDetailBannerItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailCommentItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailInfoItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSaleItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSeckillItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailShopItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSpecItemModel;
import com.likeits.simple.network.model.home.HomeMessage;
import com.likeits.simple.network.model.home.MainHomeBannerModel;
import com.likeits.simple.network.model.home.MainHomeBlankModel;
import com.likeits.simple.network.model.home.MainHomeGoodModel;
import com.likeits.simple.network.model.home.MainHomeListmenuModel;
import com.likeits.simple.network.model.home.MainHomeMenuModel;
import com.likeits.simple.network.model.home.MainHomeNoticeModel;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.network.model.home.MainHomePictureModel;
import com.likeits.simple.network.model.home.MainHomePicturewModel;
import com.likeits.simple.network.model.home.MainHomeTitleModel;
import com.likeits.simple.network.model.home.MainHomekitchenwindowModel;
import com.likeits.simple.network.model.member.MemberIconGroupItemModel;
import com.likeits.simple.utils.HttpUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
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
public class GoodDetail01Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String goodData;
    private JSONArray items;
    private JSONObject goods;
    private List<HomeMessage> mMessages;
    private GoodDetailAdapter adapter;
    private String id;

    @Override
    protected int setContentView() {
        return R.layout.fragment_good_detail01;
    }

    @Override
    protected void lazyLoad() {

       id = getArguments().getString("id");
        //  id="526";
        initData();
    }

    private void initData() {
        // LoaddingShow();
        String url = ApiService.Good_Detial;
        RequestParams params = new RequestParams();
        params.put("id", id);
        params.put("openid", openid);
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {
                // LoaddingDismiss();
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    String msg = object.optString("msg");
                    if (code == 200) {
                        //goodData = response;
                        JSONObject object1 = object.optJSONObject("data");
                        items = object1.optJSONArray("items"); //items数据
                        goods = object1.optJSONObject("goods");
                        String productprice = goods.optString("productprice");
                        SharedPreferencesUtils.put(getActivity(), "productprice", productprice);
                        SharedPreferencesUtils.put(getActivity(), "nowtime", goods.optLong("nowtime"));
                        SharedPreferencesUtils.put(getActivity(), "isseckill", goods.optBoolean("isseckill"));
                        initUI();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable e) {

            }

            @Override
            public void onFinish() {
                super.onFinish();
                //LoaddingDismiss();
            }
        });
    }

    private void initUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mMessages = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String id = items.optJSONObject(i).optString("id");
            if ("detail_swipe".equals(id)) {//
                GoodDetailBannerItemModel goodDetailBannerItemModel = JSON.parseObject(items.optString(i), GoodDetailBannerItemModel.class);
                mMessages.add(goodDetailBannerItemModel);
            } else if ("detail_seckill".equals(id)) {
                GoodDetailSeckillItemModel goodDetailSeckillItemModel = JSON.parseObject(items.optString(i), GoodDetailSeckillItemModel.class);
                mMessages.add(goodDetailSeckillItemModel);
            } else if ("detail_info".equals(id)) {
                GoodDetailInfoItemModel goodDetailInfoItemModel = JSON.parseObject(items.optString(i), GoodDetailInfoItemModel.class);
                mMessages.add(goodDetailInfoItemModel);
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
            } else if ("blank".equals(id)) {//空白区域
                MainHomeBlankModel mainHomeBlankModel = JSON.parseObject(items.optString(i).toString(), MainHomeBlankModel.class);
                mMessages.add(mainHomeBlankModel);
            } else if ("picture".equals(id)) {//图片
                MainHomePictureModel mainHomePictureModel = JSON.parseObject(items.optString(i).toString(), MainHomePictureModel.class);
                mMessages.add(mainHomePictureModel);
            } else if ("banner".equals(id)) {//轮播
                MainHomeBannerModel mainHomeBannerModel = JSON.parseObject(items.optString(i), MainHomeBannerModel.class);
                mMessages.add(mainHomeBannerModel);
            } else if ("title".equals(id)) {//标题
                MainHomeTitleModel mainHomeTitleModel = JSON.parseObject(items.optString(i), MainHomeTitleModel.class);
                mMessages.add(mainHomeTitleModel);
            } else if ("notice".equals(id)) {//公告
                MainHomeNoticeModel mainHomeNoticeModel = JSON.parseObject(items.optString(i).toString(), MainHomeNoticeModel.class);
                mMessages.add(mainHomeNoticeModel);
            } else if ("detail_shop".equals(id)) {
                GoodDetailShopItemModel goodDetailShopItemModel = JSON.parseObject(items.optString(i), GoodDetailShopItemModel.class);
                mMessages.add(goodDetailShopItemModel);
            } else if ("detail_comment".equals(id)) {
                GoodDetailCommentItemModel goodDetailCommentItemModel = JSON.parseObject(items.optString(i), GoodDetailCommentItemModel.class);
                mMessages.add(goodDetailCommentItemModel);
            } else if ("detail_spec".equals(id)) {
                GoodDetailSpecItemModel goodDetailSpecItemModel = JSON.parseObject(items.optString(i), GoodDetailSpecItemModel.class);
                mMessages.add(goodDetailSpecItemModel);
            } else if ("detail_sale".equals(id)) {
                GoodDetailSaleItemModel goodDetailSaleItemModel = JSON.parseObject(items.optString(i), GoodDetailSaleItemModel.class);
                mMessages.add(goodDetailSaleItemModel);
            }
            else if ("icongroup".equals(id)) {
                MemberIconGroupItemModel memberIconGroupItemModel = JSON.parseObject(items.optString(i), MemberIconGroupItemModel.class);
                mMessages.add(memberIconGroupItemModel);
            }
        }
        mSwipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                //    mCurrentCounter = PAGE_SIZE;
                // pageNum = 1;//页数置为1 才能继续重新加载
                mSwipeRefreshLayout.setRefreshing(false);
                adapter = new GoodDetailAdapter(mMessages);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                adapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        initData();
    }

}
