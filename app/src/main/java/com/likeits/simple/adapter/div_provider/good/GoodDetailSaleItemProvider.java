package com.likeits.simple.adapter.div_provider.good;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.gooddetails.GoodDetailSaleItemModel;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.TextViewBorder;
import com.likeits.simple.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;
import com.likeits.simple.view.custom_scrollview.PagingScrollHelper;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

public class GoodDetailSaleItemProvider extends BaseItemProvider<GoodDetailSaleItemModel, BaseViewHolder> {
    private GoodDetailSaleItemModel.StyleBean styleBean;
    private List<GoodDetailSaleItemModel.DataBeanX.ActivityBean> activity;
    private GoodDetailSaleItemModel.DataBeanX.GiftsBean gifts;
    private GoodDetailSaleItemModel.DataBeanX.ServiceBean service;
    private List<GoodDetailSaleItemModel.DataBeanX.CouponsBean> coupons;
    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private GoodCouponsAdapter mAdapter_Coupons;
    private GoodActivityAdapter mAdater_activity;
    private LinearLayout.LayoutParams linearParams;
    private int h_screen;

    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_SALES;
    }

    @Override
    public int layout() {
        return R.layout.good_detail_coupons_item;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailSaleItemModel data, int position) {
        boolean isseckill = SharedPreferencesUtils.getBoolean(mContext, "isseckill");
        styleBean = data.getStyle();
        activity = data.getData().getActivity();
        gifts = data.getData().getGifts();
        service = data.getData().getService();
        coupons = data.getData().getCoupons();
        LinearLayout ll_bg = helper.getView(R.id.ll_bg);
        ll_bg.setBackgroundColor(Color.parseColor(styleBean.getBackground()));
        LinearLayout ll_coupons = helper.getView(R.id.ll_coupon);
        LinearLayout ll_activity = helper.getView(R.id.ll_activity);
        LinearLayout ll_gifts = helper.getView(R.id.ll_gifts);
        LinearLayout ll_service = helper.getView(R.id.ll_service);
        if (isseckill) {
            ll_gifts.setVisibility(View.GONE);
            ll_activity.setVisibility(View.GONE);
        } else {
            ll_gifts.setVisibility(View.VISIBLE);
            ll_activity.setVisibility(View.VISIBLE);
        }
        //优惠卷
        if (coupons != null) {

            MyRecyclerView mCouponsRecyclerView = helper.getView(R.id.mRecyclerView_coupons);
            mCouponsRecyclerView.setHasFixedSize(true);
            TextView mTvCouponTitle = helper.getView(R.id.tv_coupon_title);
            mTvCouponTitle.setText("优惠卷");
            mTvCouponTitle.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            mAdapter_Coupons = new GoodCouponsAdapter(R.layout.goods_coupons_items, coupons);
            horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
            //滚动adapter
            mCouponsRecyclerView.setAdapter(mAdapter_Coupons);
            mAdapter_Coupons.notifyDataSetChanged();
            scrollHelper.setUpRecycleView(mCouponsRecyclerView);
            RecyclerView.LayoutManager layoutManager = null;
            layoutManager = horizontalPageLayoutManager;
            if (layoutManager != null) {
                mCouponsRecyclerView.setLayoutManager(layoutManager);
                scrollHelper.updateLayoutManger();
            }
        } else {
            ll_coupons.setVisibility(View.GONE);
        }
        if (activity != null) {
            //活动
            TextView tv_activity_title = helper.getView(R.id.tv_activity_title);
            RecyclerView mRecyclerView_activity = helper.getView(R.id.mRecyclerView);
            linearParams = (LinearLayout.LayoutParams) ll_activity.getLayoutParams();
            linearParams.height = (activity.size() * 60 * 2);
            ll_activity.setLayoutParams(linearParams);
            mRecyclerView_activity.setHasFixedSize(true);
            tv_activity_title.setText("活动");
            tv_activity_title.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            mAdater_activity = new GoodActivityAdapter(R.layout.good_activity_items, activity);
            mRecyclerView_activity.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerView_activity.setAdapter(mAdater_activity);
            mAdater_activity.notifyDataSetChanged();
        } else {
            ll_activity.setVisibility(View.GONE);
        }
        if (gifts != null) {
            TextView tv_gifts_title = helper.getView(R.id.tv_gifts_title);
            TextView tv_gifts_content = helper.getView(R.id.tv_gifts_content);
            tv_gifts_title.setText("赠品");
            tv_gifts_title.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            tv_gifts_content.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            tv_gifts_content.setText(gifts.getData().get(0).getTitle());

        } else {
            ll_gifts.setVisibility(View.GONE);
        }
        if (service != null) {
            final LayoutInflater mInflater = LayoutInflater.from(mContext);
            final TagFlowLayout mFlowLayout = helper.getView(R.id.id_flowlayout);
            mFlowLayout.setMaxSelectCount(0);
            mFlowLayout.setAdapter(new TagAdapter<String>(service.getLabellist()) {

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) mInflater.inflate(R.layout.good_service_items,
                            mFlowLayout, false);
                     tv.setText(s);
                    return tv;
                }
            });
        } else {
            ll_service.setVisibility(View.GONE);
        }
    }

    /**
     * 活动适配器
     */
    public class GoodActivityAdapter extends BaseQuickAdapter<GoodDetailSaleItemModel.DataBeanX.ActivityBean, BaseViewHolder> {
        public GoodActivityAdapter(int layoutResId, List<GoodDetailSaleItemModel.DataBeanX.ActivityBean> data) {
            super(R.layout.good_activity_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, GoodDetailSaleItemModel.DataBeanX.ActivityBean item) {
            TextViewBorder tvTitle = helper.getView(R.id.tv_title);
            TextView tvContent = helper.getView(R.id.tv_content);
            tvTitle.setBorderColor(Color.parseColor(styleBean.getTextcolor()));
            tvTitle.setBorderWidth(2);
            tvTitle.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            tvTitle.setText(item.getTitle());
            String content = String.format(item.getAndroid_content());
            tvContent.setText(Html.fromHtml(content));

        }
    }

    /**
     * 优惠卷适配器
     */
    public class GoodCouponsAdapter extends BaseQuickAdapter<GoodDetailSaleItemModel.DataBeanX.CouponsBean, BaseViewHolder> {
        public GoodCouponsAdapter(int layoutResId, List<GoodDetailSaleItemModel.DataBeanX.CouponsBean> data) {
            super(R.layout.goods_coupons_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, GoodDetailSaleItemModel.DataBeanX.CouponsBean item) {
            TextView tvPrice = helper.getView(R.id.tv_coupons_price);
            tvPrice.setBackgroundColor(Color.parseColor(styleBean.getTextcolorhigh()));
            boolean backpre = item.isBackpre();
            String backtype = item.getBacktype();
            if ("1".equals(backtype)) {
                java.text.DecimalFormat myformat = new java.text.DecimalFormat("0.0");
                tvPrice.setText(myformat.format(Double.valueOf(item.get_backmoney())) + "折");
            } else {
                java.text.DecimalFormat myformat = new java.text.DecimalFormat("0");
                if (backpre) {
                    tvPrice.setText("¥" + myformat.format(Double.valueOf(item.get_backmoney())));
                } else {
                    tvPrice.setText(myformat.format(Double.valueOf(item.get_backmoney())) + "");
                }


            }
        }
    }


}
