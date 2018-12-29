package com.likeits.simple.adapter.div_provider.good;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.gooddetails.GoodDetailSeckillItemModel;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.CustomHorizontalProgresNoNum;

import cn.iwgang.countdownview.CountdownView;
import cn.iwgang.countdownview.DynamicConfig;

public class GoodSeckillItemProvider extends BaseItemProvider<GoodDetailSeckillItemModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_SECHILL;
    }

    @Override
    public int layout() {
        return R.layout.good_detail_seckill_item;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailSeckillItemModel data, int position) {
        LinearLayout llbg01 = helper.getView(R.id.ll_bg01);
        LinearLayout llbg02 = helper.getView(R.id.ll_bg02);
        String productprice = SharedPreferencesUtils.getString(mContext, "productprice");
        long nowtime = SharedPreferencesUtils.getLong(mContext, "nowtime");
        long starttime = data.getData().getStarttime();
        long endtime = data.getData().getEndtime();
        String color1 = data.getStyle().getTheme();
        //   String color = color1.replace("#", "");
        //String color = "0000ff";
        String color = color1.substring(1, color1.length());
        TextView tv_productprice = helper.getView(R.id.tv_productprice);
        TextView tv_price = helper.getView(R.id.tv_price);
        TextView tv_sales = helper.getView(R.id.tv_sales);
        TextView tv_time = helper.getView(R.id.tv_time);
        llbg01.setBackgroundColor(Color.parseColor(color1));
        llbg02.setBackgroundColor(Color.parseColor("#" + "33" + color));
        CountdownView mCountdownView = helper.getView(R.id.cv_countdownView);
        CustomHorizontalProgresNoNum customProgressBar = helper.getView(R.id.CustomProgressBar);
      //  mCountdownView.setDrawingCacheBackgroundColor(Color.parseColor("#FF0000"));

        customProgressBar.setProgressBgColor(Color.parseColor("#FFFFFF"));
        customProgressBar.setProgressColor(Color.parseColor("#" + "1A" + color));

        String content = "¥" + productprice;
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(content);
        AbsoluteSizeSpan ab = new AbsoluteSizeSpan(12, true);
        //文本字体绝对的大小
        stringBuilder.setSpan(ab, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_productprice.setText(stringBuilder);

        tv_price.setText(data.getData().getOptions().get(0).getPrice());
        tv_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        DynamicConfig dynamicConfig = new DynamicConfig.Builder().setBackgroundInfo(new DynamicConfig.BackgroundInfo().setColor(Color.parseColor(color1))).build();
        mCountdownView.dynamicShow(dynamicConfig);
        int percent = data.getData().getPercent();
        int total = Integer.valueOf(data.getData().getTotal());
        if (data.getData().getPercent() == 0) {
            tv_sales.setText("已出售" + "0%");

        } else {
            tv_sales.setText("已出售" + percent / total + "%");
        }
        customProgressBar.setProgress(percent);
        customProgressBar.setMax(total);
        long time ;

        if (starttime - nowtime > 0) {
            time = (starttime - nowtime) * 1000;
            mCountdownView.start(time);
            tv_time.setText(" 距开始 ");
        } else if (starttime - nowtime < 0 && endtime - nowtime > 0) {
            time = (endtime - nowtime) * 1000;
            mCountdownView.start(time);
            tv_time.setText(" 距结束 ");
        } else {
            tv_time.setText(" 已结束 ");
            mCountdownView.setVisibility(View.GONE);
        }
        mCountdownView.setOnCountdownIntervalListener(120000, new CountdownView.OnCountdownIntervalListener() {
            @Override
            public void onInterval(CountdownView cv, long remainTime) {

            }
        });
        tv_time.setTextColor(Color.parseColor(color1));

    }
}
