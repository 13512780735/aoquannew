package com.likeit.aqe365.adapter.div_provider.home;

import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomekitchenwindowModel;
import com.likeit.aqe365.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainkitchenwindowItemProvider extends BaseItemProvider<MainHomekitchenwindowModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_KITCHENWINDOW;
    }

    @Override
    public int layout() {
        return R.layout.main_home_kitchenwindow;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomekitchenwindowModel data, int position) {
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        SimpleDraweeView ivLeft = helper.getView(R.id.iv_left);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) ivLeft.getLayoutParams();
        linearParams.height = w_screen / 2;
        ivLeft.setLayoutParams(linearParams);
//        Glide.with(mContext).load(data.getData().get(0).getImgurl())
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.mipmap.default_pic)
//                .error(R.mipmap.default_pic)
//                .centerCrop().override(1090, 1090*3/4)
//                .crossFade().into((SimpleDraweeView) helper.getView(R.id.iv_left));
//        Glide.with(mContext).load(data.getData().get(1).getImgurl())
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.mipmap.default_pic)
//                .error(R.mipmap.default_pic)
//                .centerCrop().override(1090, 1090*3/4)
//                .crossFade().into((SimpleDraweeView) helper.getView(R.id.iv_right_top));
//        Glide.with(mContext).load(data.getData().get(2).getImgurl())
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.mipmap.default_pic)
//                .error(R.mipmap.default_pic)
//                .centerCrop().override(1090, 1090*3/4)
//                .crossFade().into((SimpleDraweeView) helper.getView(R.id.iv_right_bottom_left));
//        Glide.with(mContext).load(data.getData().get(3).getImgurl())
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .placeholder(R.mipmap.default_pic)
//                .error(R.mipmap.default_pic)
//                .centerCrop().override(1090, 1090*3/4)
//                .crossFade().into((SimpleDraweeView) helper.getView(R.id.iv_right_bottom_right));
        ImageLoader.getInstance().displayImage(data.getData().get(0).getImgurl(),(SimpleDraweeView) helper.getView(R.id.iv_left));
        ImageLoader.getInstance().displayImage(data.getData().get(1).getImgurl(),(SimpleDraweeView) helper.getView(R.id.iv_right_top));
        ImageLoader.getInstance().displayImage(data.getData().get(2).getImgurl(),(SimpleDraweeView) helper.getView(R.id.iv_right_bottom_left));
        ImageLoader.getInstance().displayImage(data.getData().get(3).getImgurl(),(SimpleDraweeView) helper.getView(R.id.iv_right_bottom_right));

    }
}
