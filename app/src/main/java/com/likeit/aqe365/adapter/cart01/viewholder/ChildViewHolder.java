package com.likeit.aqe365.adapter.cart01.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.cart01.bean.GoodsBean;
import com.likeit.aqe365.network.model.cart01.CartListModel;
import com.ocnyang.cartlayout.viewholder.CartViewHolder;

public abstract class ChildViewHolder extends CartViewHolder implements View.OnClickListener {
    public TextView textViewReduce;
    public TextView tv_type_size;
    public TextView tv_intro;
    public TextView textViewPrice;
    public TextView textViewNum;
    public TextView textViewAdd;
    public ImageView ivAvatar;

    public ChildViewHolder(View itemView, int chekbox_id) {
        super(itemView, chekbox_id);

        tv_intro = itemView.findViewById(R.id.tv_intro);//名称
        ivAvatar = itemView.findViewById(R.id.iv_adapter_list_pic);//图片
        textViewPrice = itemView.findViewById(R.id.tv_price);//价格
        tv_type_size = itemView.findViewById(R.id.tv_type_size);//规格
        textViewReduce = ((TextView) itemView.findViewById(R.id.tv_reduce));//减
        textViewNum = itemView.findViewById(R.id.tv_num);//数量
        textViewAdd = itemView.findViewById(R.id.tv_add);//加

        itemView.setOnClickListener(this);
        textViewReduce.setOnClickListener(this);
        textViewAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item:
                Toast.makeText(v.getContext(), ((GoodsBean) mICartItem).getGoods_name(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_reduce:
                int intValue = Integer.valueOf(textViewNum.getText().toString()).intValue();
                if (intValue > 1) {
                    intValue--;
                    textViewNum.setText(String.valueOf(intValue));
                    ((CartListModel.ListBeanXX.ListBeanX) mICartItem).setTotal(String.valueOf(intValue));
                    onNeedCalculate();
                }
                break;
            case R.id.tv_add:
                int intValue2 = Integer.valueOf(textViewNum.getText().toString()).intValue();
                intValue2++;
                textViewNum.setText(String.valueOf(intValue2));
                ((CartListModel.ListBeanXX.ListBeanX) mICartItem).setTotal(String.valueOf(intValue2));
                onNeedCalculate();
                break;
            default:
                break;
        }
    }

    /**
     * 这里因为把 ViewHolder 没有写到 adapter 中作为内部类，所以对事件写了一个回调的抽象方法。
     * 如果不想这样写，你可以在以下方式中选其一：
     * 1. 将 ViewHolder 写到 Adapter 中作为内部类，这样你就可以访问 Adapter 中的一些方法属性了；
     * 2. 或者，你把 ItemView & ItemChildView 的事件放到 Adapter 中的 onBindViewHolder() 方法中设置。
     */
    public abstract void onNeedCalculate();
}
