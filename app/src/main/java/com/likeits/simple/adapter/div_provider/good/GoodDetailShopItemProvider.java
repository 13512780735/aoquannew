package com.likeits.simple.adapter.div_provider.good;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.gooddetails.GoodDetailShopItemModel;
import com.likeits.simple.view.BorderTextView;
import com.likeits.simple.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

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
        RatioImageView ivLogo = helper.getView(R.id.iv_logo);
        LinearLayout ll_good_details_shop = helper.getView(R.id.ll_good_details_shop);
        TextView tv_shopname = helper.getView(R.id.tv_shopname);
        TextView tv_shopdesc = helper.getView(R.id.tv_shopdesc);
        BorderTextView rightnavtext = helper.getView(R.id.rightnavtext);
        ImageLoader.getInstance().displayImage(data.getData().getMerch().getLogo(), ivLogo);
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
