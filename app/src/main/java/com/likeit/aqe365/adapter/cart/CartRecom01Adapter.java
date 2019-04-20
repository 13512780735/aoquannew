package com.likeit.aqe365.adapter.cart;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.cart.CartListModel01;
import com.likeit.aqe365.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class CartRecom01Adapter extends BaseQuickAdapter<CartListModel01.RecomsBean.ListBean, BaseViewHolder> {
    public CartRecom01Adapter(int layoutResId, List<CartListModel01.RecomsBean.ListBean> data) {
        super(R.layout.cart_recom_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CartListModel01.RecomsBean.ListBean item) {
//        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
//        int w_screen = dm.widthPixels;
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) baseViewHolder.getView(R.id.goods_url).getLayoutParams();
//        params.width = w_screen / 3 - 30;
//        params.height = w_screen / 3 - 30;
  //      baseViewHolder.getView(R.id.goods_url).setLayoutParams(params);
        ImageLoader.getInstance().displayImage(item.getThumb(), (RatioImageView) baseViewHolder.getView(R.id.goods_url));
        baseViewHolder.setText(R.id.tv_titles, item.getTitle());
        baseViewHolder.setText(R.id.goods_price, "¥ " + item.getMarketprice());
        baseViewHolder.getView(R.id.tv_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
