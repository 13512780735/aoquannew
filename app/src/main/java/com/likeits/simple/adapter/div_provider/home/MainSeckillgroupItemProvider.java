package com.likeits.simple.adapter.div_provider.home;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.home.MainHomeSeckillgroupModel;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.view.RatioImageView;
import com.likeits.simple.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;
import com.likeits.simple.view.custom_scrollview.PagingScrollHelper;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import cn.iwgang.countdownview.CountdownView;

public class MainSeckillgroupItemProvider extends BaseItemProvider<MainHomeSeckillgroupModel, BaseViewHolder> {
    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private SeckillgroupAdapter mAdapter;
    private List<MainHomeSeckillgroupModel.DataBean.GoodsBean> dataBean;
    MainHomeSeckillgroupModel.StyleBean styleBean;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_SECKILLGROUP;
    }

    @Override
    public int layout() {
        return R.layout.main_home_seckillgroup;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeSeckillgroupModel data, int position) {
        styleBean = data.getStyle();
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        CountdownView mCvCountdownViewTest1 = helper.getView(R.id.cv_countdownViewTest1);
        mCvCountdownViewTest1.setDrawingCacheBackgroundColor(Color.parseColor("#FF0000"));
        ImageView ivTitlePic = helper.getView(R.id.iv_title_pic);
        TextView tvTime = helper.getView(R.id.tv_time);
        TextView tv_time_title = helper.getView(R.id.tv_time_1);
        TextView tv_more = helper.getView(R.id.tv_more);
        TextView tv_more01 = helper.getView(R.id.tv_more01);
        MyRecyclerView mRecycleView = helper.getView(R.id.mRecyclerView);
        ImageLoader.getInstance().displayImage(data.getParams().getIconurl(), ivTitlePic);
        tvTime.setTextColor(Color.parseColor(data.getStyle().getTitlecolor()));
        tv_more.setTextColor(Color.parseColor(data.getStyle().getTitlecolor()));
        tv_time_title.setTextColor(Color.parseColor(data.getStyle().getTitlecolor()));
        tv_more01.setTypeface(iconTypeface);
        tv_more01.setText(StringUtil.decode("\\u" + "e6a7"));
        tv_more01.setTextColor(Color.parseColor(data.getStyle().getTitlecolor()));
        if (data.getData() != null) {
            dataBean = data.getData().getGoods();
            tvTime.setText(data.getData().getTime() + "点场");
            long nowtime = data.getData().getNowtime();
            long endtime = data.getData().getEndtime();
            long starttime = data.getData().getStarttime();
            long time = 0;
            if (starttime - nowtime > 0) {
                time = (starttime - nowtime) * 1000;
                mCvCountdownViewTest1.start(time);
                tv_time_title.setText(" 距开始 ");
            } else if (starttime - nowtime < 0 && endtime - nowtime > 0) {
                time = (endtime - nowtime) * 1000;
                mCvCountdownViewTest1.start(time);
                tv_time_title.setText(" 距结束 ");
            }else{
            tv_time_title.setText(" 已结束 ");
            mCvCountdownViewTest1.setVisibility(View.GONE);}
//            try {
//                Thread.sleep(1000);
//                mCvCountdownViewTest1.start(time );
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 3);
            mAdapter = new SeckillgroupAdapter(R.layout.main_home_seckillgroup_item, dataBean);
            //滚动adapter
            mRecycleView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            scrollHelper.setUpRecycleView(mRecycleView);
            RecyclerView.LayoutManager layoutManager = null;
            layoutManager = horizontalPageLayoutManager;
            if (layoutManager != null) {
                mRecycleView.setLayoutManager(layoutManager);
                scrollHelper.updateLayoutManger();
            }
        } else return;


    }

    public class SeckillgroupAdapter extends BaseQuickAdapter<MainHomeSeckillgroupModel.DataBean.GoodsBean, BaseViewHolder> {
        public SeckillgroupAdapter(int layoutResId, List<MainHomeSeckillgroupModel.DataBean.GoodsBean> data) {
            super(R.layout.main_home_seckillgroup_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomeSeckillgroupModel.DataBean.GoodsBean item) {
            TextView tvNewPrice = helper.getView(R.id.tv_new_price);
            TextView tvOrdPrice = helper.getView(R.id.tv_ord_price);
            RatioImageView ivPic = helper.getView(R.id.iv_pic);
            ImageLoader.getInstance().displayImage(item.getThumb(), ivPic);
            tvNewPrice.setText("¥" + item.getPrice());
            tvOrdPrice.setText("¥" + item.getMarketprice());
            tvOrdPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tvOrdPrice.setTextColor(Color.parseColor(styleBean.getProductpricecolor()));
            tvNewPrice.setTextColor(Color.parseColor(styleBean.getMarketpricecolor()));

        }
    }
}
