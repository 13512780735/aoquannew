package com.likeit.aqe365.adapter.cart01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.cart01.bean.NormalBean;
import com.likeit.aqe365.adapter.cart01.viewholder.ChildViewHolder;
import com.likeit.aqe365.adapter.cart01.viewholder.GroupViewHolder;
import com.likeit.aqe365.network.model.cart01.CartListModel;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.ocnyang.cartlayout.CartAdapter;
import com.ocnyang.cartlayout.viewholder.CartViewHolder;

import java.util.List;

public class CartShopAdapter extends CartAdapter<CartViewHolder> {

    public CartShopAdapter(Context context, List datas) {
        super(context, datas);
    }

//    @Override
//    protected CartViewHolder getNormalViewHolder(View itemView) {
//        return new NormalViewHolder(itemView, -1);
//    }

    @Override
    protected CartViewHolder getGroupViewHolder(View itemView) {
        return (CartViewHolder) new GroupViewHolder(itemView, R.id.determine_chekbox);
    }

    @Override
    protected CartViewHolder getChildViewHolder(View itemView) {
        return (CartViewHolder) (new ChildViewHolder(itemView, R.id.check_box) {
            @Override
            public void onNeedCalculate() {
                if (onCheckChangeListener != null) {
                    onCheckChangeListener.onCalculateChanged(null);
                }
            }
        });
    }

    @Override
    protected int getChildItemLayout() {
        return R.layout.item_shopcart_product;
    }

    @Override
    protected int getGroupItemLayout() {
        return R.layout.item_shopcart_group;
    }

//    @Override
//    protected int getNormalItemLayout() {
//        return R.layout.activity_main_item_normal;
//    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof ChildViewHolder) {
            ChildViewHolder childViewHolder = (ChildViewHolder) holder;
            childViewHolder.tv_intro.setText(((CartListModel.ListBeanXX.ListBeanX) mDatas.get(position)).getTitle());
            childViewHolder.tv_type_size.setText(((CartListModel.ListBeanXX.ListBeanX) mDatas.get(position)).getOptiontitle());
            childViewHolder.textViewPrice.setText("￥"+((CartListModel.ListBeanXX.ListBeanX) mDatas.get(position)).getMarketprice());
            childViewHolder.textViewNum.setText(String.valueOf(((CartListModel.ListBeanXX.ListBeanX) mDatas.get(position)).getTotal()));
            ImageLoader.getInstance().displayImage(((CartListModel.ListBeanXX.ListBeanX) mDatas.get(position)).getThumb(),childViewHolder.ivAvatar);
        } else if (holder instanceof GroupViewHolder) {
            GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
            groupViewHolder.textView.setText(((CartListModel.ListBeanXX) mDatas.get(position)).getMerchname());
        }
//        else if (holder instanceof NormalViewHolder) {
//            NormalViewHolder normalViewHolder = (NormalViewHolder) holder;
//            normalViewHolder.imgViewClose.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mDatas.remove(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position, mDatas.size());
//                }
//            });
//            normalViewHolder.textView.setText(mContext.getString(R.string.normal_tip_X,
//                    ((NormalBean) mDatas.get(position)).getMarkdownNumber()));
//        }
    }
}
