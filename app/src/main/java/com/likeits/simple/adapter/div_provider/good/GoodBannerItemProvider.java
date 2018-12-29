package com.likeits.simple.adapter.div_provider.good;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.adapter.div_provider.home.MainHomeAdapter;
import com.likeits.simple.network.model.gooddetails.GoodDetailBannerItemModel;
import com.likeits.simple.network.model.home.MainHomeBannerModel;
import com.likeits.simple.view.RatioImageView;

import java.util.ArrayList;
import java.util.List;


public class GoodBannerItemProvider extends BaseItemProvider<GoodDetailBannerItemModel, BaseViewHolder> {
    private ConvenientBanner mBanner;
    List<GoodDetailBannerItemModel.DataBean> adList;
    private List<GoodDetailBannerItemModel.DataBean> networkImage = new ArrayList<>();

    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_BANNER01;
    }

    @Override
    public int layout() {
        return R.layout.main_home_banner;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailBannerItemModel data, int position) {

        //处理相关业务逻辑
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int h_screen = dm.heightPixels;
        int w_screen = dm.widthPixels;
        mBanner = helper.getView(R.id.banner);
        mBanner.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, w_screen));
        mBanner.startTurning(4000);
        adList = data.getData();
        if (adList != null && adList.size() > 0) {
            networkImage = adList;

        }
        initBanner();
    }


    private void initBanner() {
        mBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, adList).setPageIndicator(new int[]{R.drawable.indicator_gray, R.drawable.indicator_red}).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).setScrollDuration(1500);
    }

    public class NetworkImageHolderView implements Holder<GoodDetailBannerItemModel.DataBean> {
        private RatioImageView imageView;

        @Override
        public View createView(Context context) {

            //找到布局填充器
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //找到整个xml布局
            LinearLayout rl = (LinearLayout) inflater.inflate(R.layout.banner_item, null);
            //通过找到xml布局来找控件
            imageView = (RatioImageView) rl.findViewById(R.id.iv_banner);
            // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return rl;
        }

        @Override
        public void UpdateUI(Context context, int position, GoodDetailBannerItemModel.DataBean data) {
            Glide.with(mContext).load(data.getBig_img()).into(imageView);
        }
    }

    @Override
    public void onClick(BaseViewHolder helper, GoodDetailBannerItemModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, GoodDetailBannerItemModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }
}
