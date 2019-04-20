package com.likeit.aqe365.adapter.div_provider.good;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.gooddetails.GoodDetailInfoItemModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;

import cn.iwgang.countdownview.CountdownView;
import cn.iwgang.countdownview.DynamicConfig;
import onekeyshare.OnekeyShare;


public class GoodDetailInfoItemProvider extends BaseItemProvider<GoodDetailInfoItemModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_DETAILS_INFO;
    }

    @Override
    public int layout() {
        return R.layout.good_details_info_item;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailInfoItemModel data, int position) {
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        boolean isseckill = SharedPreferencesUtils.getBoolean(mContext, "isseckill");
        String productprice = SharedPreferencesUtils.getString(mContext, "productprice");
        long nowtime = SharedPreferencesUtils.getLong(mContext, "nowtime");
        TextView tv_goods_name = helper.getView(R.id.tv_goods_name);//标题
        LinearLayout ll_info = helper.getView(R.id.ll_info);//背景
        LinearLayout ll_presellsendtime = helper.getView(R.id.ll_presellsendtime);//背景
        LinearLayout ll_share = helper.getView(R.id.ll_share);
        TextView tv_share01 = helper.getView(R.id.tv_share01);//图片
        TextView tv_share = helper.getView(R.id.tv_share);
        TextView tv_title01 = helper.getView(R.id.tv_title01);//副标题
        LinearLayout ll_price = helper.getView(R.id.ll_price);//新价格
        TextView tv_new_price = helper.getView(R.id.tv_new_price);//新价格
        TextView tv_old_price = helper.getView(R.id.tv_old_price);//原价格
        LinearLayout ll_Seckill = helper.getView(R.id.ll_Seckill);//倒计时背景
        TextView tv_icon = helper.getView(R.id.tv_icon);//倒计时图片
        TextView tv_time_title = helper.getView(R.id.tv_time_title);//倒计时图片
        CountdownView mCountdownView = helper.getView(R.id.mCountdownView);//倒计时图片
        TextView tv_express = helper.getView(R.id.tv_express);//快递
        TextView tv_number = helper.getView(R.id.tv_number);//销售量
        TextView tv_address = helper.getView(R.id.tv_address);//地址
        LinearLayout ll_preselltime02 = helper.getView(R.id.ll_preselltime02);//预售时间1
        TextView tv_preselltime01 = helper.getView(R.id.tv_preselltime01);//预售时间1
        TextView tv_preselltime02 = helper.getView(R.id.tv_preselltime02);//预售时间2
        TextView tv_preselltime03 = helper.getView(R.id.tv_preselltime03);//预售时间2
        TextView tv_preselltime04 = helper.getView(R.id.tv_preselltime04);//预售时间2
        ll_info.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        ll_Seckill.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(data.getStyle().getTimecolor())));
        tv_icon.setTextColor(Color.parseColor(data.getStyle().getTimetextcolor()));
        tv_time_title.setTextColor(Color.parseColor(data.getStyle().getTimetextcolor()));
        // tv_time_title.setTextColor(Color.parseColor(data.getStyle().getTimetextcolor()));
        DynamicConfig.Builder dynamicConfigBuilder = new DynamicConfig.Builder();
        dynamicConfigBuilder.setTimeTextColor(Color.parseColor(data.getStyle().getTimetextcolor()));
        mCountdownView.dynamicShow(dynamicConfigBuilder.build());
        tv_goods_name.setTextColor(Color.parseColor(data.getStyle().getTitlecolor()));
        tv_title01.setTextColor(Color.parseColor(data.getStyle().getSubtitlecolor()));
        tv_share01.setTextColor(Color.parseColor(data.getStyle().getSubtitlecolor()));
        tv_share.setTextColor(Color.parseColor(data.getStyle().getSubtitlecolor()));
        tv_new_price.setTextColor(Color.parseColor(data.getStyle().getPricecolor()));
        tv_old_price.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_express.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_number.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_address.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_preselltime01.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_preselltime02.setTextColor(Color.parseColor(data.getStyle().getTimetextcolor()));
        tv_preselltime03.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_preselltime04.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_goods_name.setText(data.getData().getTitle());
        tv_share01.setTypeface(iconTypeface);
        tv_share01.setText(StringUtil.decode("\\u" + data.getParams().getShare_icon()));
        tv_share.setText(data.getParams().getShare());
        tv_new_price.setText("¥ " + data.getData().getMarketprice());
        tv_old_price.setText("¥ " + productprice);
        tv_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_icon.setTypeface(iconTypeface);
        tv_icon.setText(StringUtil.decode("\\u" + "e6bb"));


        tv_express.setText("快递： " + data.getData().getDispatchprice());
        tv_number.setText("销量：" + data.getData().getSales() + data.getData().getUnit());
        tv_address.setText(data.getData().getProvince() + data.getData().getCity());

        if ("0".equals(data.getData().getPresell().getIspresell())) {

            ll_presellsendtime.setVisibility(View.GONE);
            tv_time_title.setText(data.getData().getIsdiscount_title());
        } else {
            ll_presellsendtime.setVisibility(View.VISIBLE);
            long preselltimestart = Long.valueOf(data.getData().getPresell().getPreselltimestart());
            long preselltimeend = Long.valueOf(data.getData().getPresell().getPreselltimeend());
            if (preselltimestart - nowtime > 0) {
                tv_time_title.setText("距离预售开始");
                mCountdownView.start((preselltimestart - nowtime) * 1000);
            } else if (preselltimestart - nowtime < 0 && preselltimeend - nowtime > 0) {
                tv_time_title.setText("距离预售结束");
                mCountdownView.start((preselltimeend - nowtime) * 1000);
            }
            long presellsendstatrttime = Long.valueOf(data.getData().getPresell().getPresellsendstatrttime());

            String result = StringUtil.formatData("MM月dd日 HH:mm:ss", preselltimeend);
            tv_preselltime01.setText("结束时间：" + result);
            if ("0".equals(data.getData().getPresell().getPresellsendtype())) {
                tv_preselltime03.setText("预计发货时间：");
                tv_preselltime02.setVisibility(View.GONE);
                String result1 = StringUtil.formatData("MM月dd日 HH:mm:ss", presellsendstatrttime);
                tv_preselltime04.setText(result1);

            } else {
                tv_preselltime03.setText("预计发货时间：购买后");
                tv_preselltime02.setText(data.getData().getPresell().getPresellsendtime());
                tv_preselltime04.setText("天发货");
            }
        }
        if ("0".equals(data.getData().getIsdiscount())) {
            ll_Seckill.setVisibility(View.VISIBLE);
        } else if ("1".equals(data.getData().getIsdiscount())) {
            ll_Seckill.setVisibility(View.GONE);
        }
        if ("".equals(data.getData().getSubtitle())) {
            tv_title01.setVisibility(View.GONE);
        } else {
            tv_title01.setText(data.getData().getSubtitle());
        }
        if (isseckill) {
            ll_price.setVisibility(View.GONE);
        } else {
            ll_price.setVisibility(View.VISIBLE);
        }
        if ("0".equals(data.getParams().getHideshare())) {
            ll_share.setVisibility(View.VISIBLE);
        } else {
            ll_share.setVisibility(View.GONE);
        }
        if ("1".equals(data.getData().getShowsales())) {
            tv_number.setVisibility(View.VISIBLE);
        } else {
            tv_number.setVisibility(View.GONE);
        }
        tv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }

    private void showShare() {
        Resources res = mContext.getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle("测试分享");
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        // oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageData(bmp);
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(mContext);
    }

}
