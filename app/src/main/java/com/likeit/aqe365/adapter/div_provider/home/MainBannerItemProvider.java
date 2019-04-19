package com.likeit.aqe365.adapter.div_provider.home;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeBannerModel;
import com.likeit.aqe365.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;


public class MainBannerItemProvider extends BaseItemProvider<MainHomeBannerModel, BaseViewHolder> implements OnItemClickListener {
    private ConvenientBanner mBanner;
    List<MainHomeBannerModel.DataBean> adList;
    private List<MainHomeBannerModel.DataBean> networkImage = new ArrayList<>();

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_BANNER;
    }

    @Override
    public int layout() {
        return R.layout.main_home_banner;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeBannerModel data, int position) {

        //处理相关业务逻辑
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int h_screen = dm.heightPixels;

        mBanner = helper.getView(R.id.banner);
        mBanner.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, h_screen / 6*2));
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
        }, adList).setPageIndicator(new int[]{R.drawable.indicator_gray, R.drawable.indicator_red}).setOnItemClickListener(this).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).setScrollDuration(1500);
    }

    @Override
    public void onItemClick(int position) {
        String id = adList.get(position).getParams().getId();
        String linkUrl = adList.get(position).getLinkurl();
        String webUrl = adList.get(position).getWeburl();
//        Intent intent = new Intent(mContext, CustomActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("id", id);
//        intent.putExtras(bundle);
//        mContext.startActivity(intent);
        IntentUtils.intentTo(mContext, linkUrl, id, webUrl);


    }

    public class NetworkImageHolderView implements Holder<MainHomeBannerModel.DataBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, MainHomeBannerModel.DataBean data) {
            Glide.with(mContext).load(data.getImgurl()).into(imageView);
        }
    }

}
