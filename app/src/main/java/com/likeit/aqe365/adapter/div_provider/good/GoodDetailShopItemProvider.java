package com.likeit.aqe365.adapter.div_provider.good;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.gooddetails.GoodDetailShopItemModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.RatioImageView;

public class GoodDetailShopItemProvider extends BaseItemProvider<GoodDetailShopItemModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_DETAILS_SHOP;
    }

    @Override
    public int layout() {
        return R.layout.good_details_shop_items;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailShopItemModel data, int position) {
        ImageLoaderUtils mImageLoader = ImageLoaderUtils.getInstance(mContext);
        RatioImageView ivLogo = helper.getView(R.id.iv_logo);
        LinearLayout ll_good_details_shop = helper.getView(R.id.ll_good_details_shop);
        TextView tv_shopname = helper.getView(R.id.tv_shopname);
        TextView tv_shopdesc = helper.getView(R.id.tv_shopdesc);
        BorderTextView rightnavtext = helper.getView(R.id.rightnavtext);
        mImageLoader.displayImage(data.getData().getMerch().getLogo(), ivLogo);
        tv_shopname.setText(data.getData().getMerch().getShopname());
        tv_shopdesc.setText(data.getData().getMerch().getDescription());
        rightnavtext.setText(data.getParams().getRightnavtext());
        ll_good_details_shop.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        tv_shopname.setTextColor(Color.parseColor(data.getStyle().getShopnamecolor()));
        tv_shopdesc.setTextColor(Color.parseColor(data.getStyle().getShopdesccolor()));
        rightnavtext.setTextColor(Color.parseColor(data.getStyle().getRightnavcolor()));
        rightnavtext.setStrokeColor01(Color.parseColor(data.getStyle().getRightnavcolor()));
    }
}
