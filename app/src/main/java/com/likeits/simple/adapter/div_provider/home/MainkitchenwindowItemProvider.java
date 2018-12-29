package com.likeits.simple.adapter.div_provider.home;

import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.likeits.simple.R;
import com.likeits.simple.network.model.home.MainHomekitchenwindowModel;
import com.likeits.simple.utils.image.GImageLoader;

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
        GImageLoader.displayUrl(mContext, (SimpleDraweeView) helper.getView(R.id.iv_left), data.getData().get(0).getImgurl());
        GImageLoader.displayUrl(mContext, (SimpleDraweeView) helper.getView(R.id.iv_right_top), data.getData().get(1).getImgurl());
        GImageLoader.displayUrl(mContext, (SimpleDraweeView) helper.getView(R.id.iv_right_bottom_left), data.getData().get(2).getImgurl());
        GImageLoader.displayUrl(mContext, (SimpleDraweeView) helper.getView(R.id.iv_right_bottom_right), data.getData().get(3).getImgurl());

    }
}
