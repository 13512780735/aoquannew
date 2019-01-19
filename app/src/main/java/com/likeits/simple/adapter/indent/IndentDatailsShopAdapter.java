package com.likeits.simple.adapter.indent;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.CaseEntity;
import com.likeits.simple.network.model.Indent.IndentDetailModel;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.view.BorderTextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by admin on 2018/5/14.
 */

public class IndentDatailsShopAdapter extends BaseQuickAdapter<IndentDetailModel.ShopBean.GoodsBean, BaseViewHolder> {
    public IndentDatailsShopAdapter(int layoutResId, List<IndentDetailModel.ShopBean.GoodsBean> data) {
        super(R.layout.layout_indent_details_listview_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, IndentDetailModel.ShopBean.GoodsBean item) {
       // ImageLoader.getInstance().displayImage(item.getUrl(), (ImageView) baseViewHolder.getView(R.id.iv_shop_avatar));
        BorderTextView tv01=baseViewHolder.getView(R.id.tv_01);//查看售后申请进度
        BorderTextView tv02=baseViewHolder.getView(R.id.tv_02);//申请售后
        BorderTextView tv03=baseViewHolder.getView(R.id.tv_03);//评价
        BorderTextView tv04=baseViewHolder.getView(R.id.tv_04);//追加评价
        ImageLoader.getInstance().displayImage(item.getThumb(), (ImageView) baseViewHolder.getView(R.id.iv_shop_avatar));
        baseViewHolder.setText(R.id.tv_shop_name, item.getTitle());
        baseViewHolder.setText(R.id.tv_shop_price, "¥ "+item.getPrice());

        if(StringUtil.isBlank(item.getOptionname())){
            baseViewHolder.getView(R.id.tv_shop_size).setVisibility(View.GONE);
        }else{
            baseViewHolder.setText(R.id.tv_shop_size, "规格：" + item.getOptionname());
        }
        baseViewHolder.setText(R.id.tv_shop_number, "X" + item.getTotal());
    }
}
