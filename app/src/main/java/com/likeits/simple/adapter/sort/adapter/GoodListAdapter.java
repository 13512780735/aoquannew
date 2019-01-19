package com.likeits.simple.adapter.sort.adapter;

import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.GoodCategory.CategoryListItemsModel;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by admin on 2018/5/21.
 */

public class GoodListAdapter extends BaseQuickAdapter<CategoryListItemsModel.ListBean, BaseViewHolder> {
    public GoodListAdapter(int layoutResId, List<CategoryListItemsModel.ListBean> data) {
        super(R.layout.good_listview_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CategoryListItemsModel.ListBean item) {
        int flag01 = SharedPreferencesUtils.getInt(mContext, "flag01");
        LinearLayout list01=baseViewHolder.getView(R.id.ll_list01);
        LinearLayout list02=baseViewHolder.getView(R.id.ll_list02);
        if (flag01 == 0) {

            list01.setVisibility(View.VISIBLE);
            list02.setVisibility(View.GONE);
//            DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
//            int w_screen = dm.widthPixels;
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) baseViewHolder.getView(R.id.goods_listview_avatar).getLayoutParams();
//            params.width = w_screen / 2 - 10;
//            params.height = w_screen / 2 - 10;
        //    baseViewHolder.getView(R.id.goods_listview_avatar).setLayoutParams(params);
            ImageLoader.getInstance().displayImage(item.getThumb(), (RatioImageView) baseViewHolder.getView(R.id.goods_listview_avatar));
            baseViewHolder.setText(R.id.tv_name, item.getTitle());
            //  baseViewHolder.setText(R.id.tv_size, "500ml/瓶");
            baseViewHolder.setText(R.id.tv_price, "¥ " + item.getMarketprice());
            baseViewHolder.setText(R.id.tv_old_price, "¥ " + item.getProductprice());
            ((TextView) baseViewHolder.getView(R.id.tv_old_price)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            baseViewHolder.setText(R.id.tv_sales, "销量：" + item.getShowsales());
        }else if(flag01 == 1){
            list01.setVisibility(View.GONE);
            list02.setVisibility(View.VISIBLE);
            ImageLoader.getInstance().displayImage(item.getThumb(), (RatioImageView) baseViewHolder.getView(R.id.goods_listview_avatar01));
            baseViewHolder.setText(R.id.tv_name01, item.getTitle());
            //  baseViewHolder.setText(R.id.tv_size, "500ml/瓶");
            baseViewHolder.setText(R.id.tv_price01, "¥ " + item.getMarketprice());
            baseViewHolder.setText(R.id.tv_old_price01, "¥ " + item.getProductprice());
            ((TextView) baseViewHolder.getView(R.id.tv_old_price01)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            baseViewHolder.setText(R.id.tv_sales01, "销量：" + item.getShowsales());
        }
    }
}
