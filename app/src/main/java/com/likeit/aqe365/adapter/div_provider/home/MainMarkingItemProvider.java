package com.likeit.aqe365.adapter.div_provider.home;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeMarkingModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.view.RatioImageView;

import cn.iwgang.countdownview.CountdownView;
import cn.iwgang.countdownview.DynamicConfig;

public class MainMarkingItemProvider extends BaseItemProvider<MainHomeMarkingModel, BaseViewHolder> {
    private ImageLoaderUtils mImageLoader;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_MARKING;
    }

    @Override
    public int layout() {
        return R.layout.mian_home_marking_item;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeMarkingModel data, int position) {
        mImageLoader = ImageLoaderUtils.getInstance(mContext);
//        int ScreenWidth = ScreenUtil.getScreenWidth();
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((RatioImageView) helper.getView(R.id.iv_01)).getLayoutParams();
//        layoutParams.width = (ScreenWidth - 30) / 4;
//        layoutParams.height = (ScreenWidth - 30) / 4;
//        ((RatioImageView) helper.getView(R.id.iv_01)).setLayoutParams(layoutParams);
        MainHomeMarkingModel.StyleBean styleBean = data.getStyle();
        LinearLayout ll_marking_bg = helper.getView(R.id.ll_marking_bg);
        LinearLayout ll_06 = helper.getView(R.id.ll_06);
        ll_marking_bg.setBackgroundColor(Color.parseColor(styleBean.getBackground()));
        ll_06.setBackgroundColor(Color.parseColor(styleBean.getBackground()));
        //限时抢购
        LinearLayout ll01 = helper.getView(R.id.ll_01);
        ll01.setBackgroundColor(Color.parseColor(styleBean.getBg()));
        final MainHomeMarkingModel.DataBeanXXXXX.SeckillBean seckillBean = data.getData().getSeckill();
        TextView tv_title01 = helper.getView(R.id.tv_title01);
        tv_title01.setTextColor(Color.parseColor(styleBean.getColor()));
        tv_title01.setText(seckillBean.getTitle());
        long time;
        CountdownView mCountdownView = helper.getView(R.id.cv_countdownView);
        DynamicConfig dynamicConfig = new DynamicConfig.Builder().setBackgroundInfo(new DynamicConfig.BackgroundInfo().setColor(Color.parseColor(styleBean.getTimerbg()))).build();
        mCountdownView.dynamicShow(dynamicConfig);
        long nowtime = seckillBean.getNowtime();
        long starttime = seckillBean.getStarttime();
        long endtime = seckillBean.getEndtime();
        if (endtime - nowtime > 0) {
            time = (endtime - nowtime) * 1000;
            mCountdownView.start(time);
        } else {
            mCountdownView.setVisibility(View.GONE);
        }
        mCountdownView.setOnCountdownIntervalListener(120000, new CountdownView.OnCountdownIntervalListener() {
            @Override
            public void onInterval(CountdownView cv, long remainTime) {

            }
        });
        if (seckillBean.getData() == null) {
            return;
        } else if (seckillBean.getData().size() == 2) {
//            Glide.with(mContext).load(seckillBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4)
//                    .crossFade().into((RatioImageView) helper.getView(R.id.iv_01));
//            Glide.with(mContext).load(seckillBean.getData().get(1).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4)
//                    .crossFade().into((RatioImageView) helper.getView(R.id.iv_02));
            mImageLoader.displayImage(seckillBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_01));
            mImageLoader.displayImage(seckillBean.getData().get(1).getThumb(), (RatioImageView) helper.getView(R.id.iv_02));
            helper.setOnClickListener(R.id.iv_01, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = seckillBean.getData().get(0).getParams().getId();
                    String linkUrl = seckillBean.getData().get(0).getLinkurl();
                    String weburl = seckillBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
            helper.setOnClickListener(R.id.iv_02, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = seckillBean.getData().get(1).getParams().getId();
                    String linkUrl = seckillBean.getData().get(1).getLinkurl();
                    String weburl = seckillBean.getData().get(1).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else if (seckillBean.getData().size() == 1) {
//            Glide.with(mContext).load(seckillBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_01));
            mImageLoader.displayImage(seckillBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_01));
            helper.setOnClickListener(R.id.iv_01, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = seckillBean.getData().get(0).getParams().getId();
                    String linkUrl = seckillBean.getData().get(0).getLinkurl();
                    String weburl = seckillBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else {
            helper.getView(R.id.iv_01).setVisibility(View.GONE);
            helper.getView(R.id.iv_02).setVisibility(View.GONE);
        }

        //本月人气榜单
        LinearLayout ll02 = helper.getView(R.id.ll_02);
        ll02.setBackgroundColor(Color.parseColor(styleBean.getBg()));
        final MainHomeMarkingModel.DataBeanXXXXX.RenqibangBean renqibangBean = data.getData().getRenqibang();
        TextView tv_title02 = helper.getView(R.id.tv_title02);
        tv_title02.setTextColor(Color.parseColor(styleBean.getColor()));
        tv_title02.setText(renqibangBean.getTitle());
        if (renqibangBean.getData().size() == 2) {
//            Glide.with(mContext).load(renqibangBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_03));
//            Glide.with(mContext).load(renqibangBean.getData().get(1).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_04));
            mImageLoader.displayImage(renqibangBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_03));
            mImageLoader.displayImage(renqibangBean.getData().get(1).getThumb(), (RatioImageView) helper.getView(R.id.iv_04));
            helper.setOnClickListener(R.id.iv_03, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = renqibangBean.getData().get(0).getParams().getId();
                    String linkUrl = renqibangBean.getData().get(0).getLinkurl();
                    String weburl = renqibangBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
            helper.setOnClickListener(R.id.iv_04, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = renqibangBean.getData().get(1).getParams().getId();
                    String linkUrl = renqibangBean.getData().get(1).getLinkurl();
                    String weburl = renqibangBean.getData().get(1).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else if (renqibangBean.getData().size() == 1) {
//            Glide.with(mContext).load(renqibangBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_03));
            mImageLoader.displayImage(renqibangBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_03));
            helper.setOnClickListener(R.id.iv_03, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = renqibangBean.getData().get(0).getParams().getId();
                    String linkUrl = renqibangBean.getData().get(0).getLinkurl();
                    String weburl = renqibangBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else {
            helper.getView(R.id.iv_03).setVisibility(View.GONE);
            helper.getView(R.id.iv_04).setVisibility(View.GONE);
        }

//        LinearLayout.LayoutParams layoutParams05 = (LinearLayout.LayoutParams) ((ImageView) helper.getView(R.id.iv_05)).getLayoutParams();
//        layoutParams05.width = (ScreenWidth/2 - 30) / 2;
//        layoutParams05.height =(ScreenWidth/2 - 30) / 2;
//        ((ImageView) helper.getView(R.id.iv_05)).setLayoutParams(layoutParams05);

        //每日必拼
        LinearLayout ll03 = helper.getView(R.id.ll_03);
        ll03.setBackgroundColor(Color.parseColor(styleBean.getBg()));
        final MainHomeMarkingModel.DataBeanXXXXX.GroupbuyBean groupbuyBean = data.getData().getGroupbuy();
        TextView tv_title03 = helper.getView(R.id.tv_title03);
        tv_title03.setTextColor(Color.parseColor(styleBean.getColor()));
        tv_title03.setText(groupbuyBean.getTitle());
        if (groupbuyBean.getData().size() == 2) {
            //   ((RatioImageView01) helper.getView(R.id.iv_05)).setOriginalSize(50,50);
//            Glide.with(mContext).load(groupbuyBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((ImageView) helper.getView(R.id.iv_05));
            // ((RatioImageView01) helper.getView(R.id.iv_06)).setOriginalSize(50,50);

//            Glide.with(mContext).load(groupbuyBean.getData().get(1).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_06));
            mImageLoader.displayImage(groupbuyBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_05));
            mImageLoader.displayImage(groupbuyBean.getData().get(1).getThumb(), (RatioImageView) helper.getView(R.id.iv_06));
            helper.setOnClickListener(R.id.iv_05, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = groupbuyBean.getData().get(0).getParams().getId();
                    String linkUrl = groupbuyBean.getData().get(0).getLinkurl();
                    String weburl = groupbuyBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
            helper.setOnClickListener(R.id.iv_06, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = groupbuyBean.getData().get(0).getParams().getId();
                    String linkUrl = groupbuyBean.getData().get(0).getLinkurl();
                    String weburl = groupbuyBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else if (groupbuyBean.getData().size() == 1) {
//            Glide.with(mContext).load(groupbuyBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_05));
            mImageLoader.displayImage(groupbuyBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_05));
            helper.setOnClickListener(R.id.iv_05, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = groupbuyBean.getData().get(0).getParams().getId();
                    String linkUrl = groupbuyBean.getData().get(0).getLinkurl();
                    String weburl = groupbuyBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else {
            helper.getView(R.id.iv_05).setVisibility(View.GONE);
            helper.getView(R.id.iv_06).setVisibility(View.GONE);
        }
        //发现好货
        LinearLayout ll04 = helper.getView(R.id.ll_04);
        ll04.setBackgroundColor(Color.parseColor(styleBean.getBg()));
        final MainHomeMarkingModel.DataBeanXXXXX.HaohuoBean haohuoBean = data.getData().getHaohuo();
        TextView tv_title04 = helper.getView(R.id.tv_title04);
        tv_title04.setTextColor(Color.parseColor(styleBean.getColor()));
        tv_title04.setText(haohuoBean.getTitle());
        if (haohuoBean.getData().size() == 1) {
//            Glide.with(mContext).load(haohuoBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_07));
            mImageLoader.displayImage(haohuoBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_07));
            helper.setOnClickListener(R.id.iv_07, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = haohuoBean.getData().get(0).getParams().getId();
                    String linkUrl = haohuoBean.getData().get(0).getLinkurl();
                    String weburl = haohuoBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else {
            helper.getView(R.id.iv_07).setVisibility(View.GONE);
        }
        //新品首发
        LinearLayout ll05 = helper.getView(R.id.ll_05);
        ll05.setBackgroundColor(Color.parseColor(styleBean.getBg()));
        final MainHomeMarkingModel.DataBeanXXXXX.XinpinBean xinpinBean = data.getData().getXinpin();
        TextView tv_title05 = helper.getView(R.id.tv_title05);
        tv_title05.setTextColor(Color.parseColor(styleBean.getColor()));
        tv_title05.setText(xinpinBean.getTitle());
        if (xinpinBean.getData().size() == 1) {
//            Glide.with(mContext).load(xinpinBean.getData().get(0).getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090 * 3 / 4).crossFade().into((RatioImageView) helper.getView(R.id.iv_08));
            mImageLoader.displayImage(xinpinBean.getData().get(0).getThumb(), (RatioImageView) helper.getView(R.id.iv_08));
            helper.setOnClickListener(R.id.iv_08, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = xinpinBean.getData().get(0).getParams().getId();
                    String linkUrl = xinpinBean.getData().get(0).getLinkurl();
                    String weburl = xinpinBean.getData().get(0).getWeburl();
                    IntentUtils.intentTo(mContext, linkUrl, id, weburl);
                }
            });
        } else {
            helper.getView(R.id.iv_08).setVisibility(View.GONE);
        }

    }
}
