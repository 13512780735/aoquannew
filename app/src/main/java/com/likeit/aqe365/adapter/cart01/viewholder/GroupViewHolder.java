package com.likeit.aqe365.adapter.cart01.viewholder;

import android.view.View;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.ocnyang.cartlayout.viewholder.CartViewHolder;

public class GroupViewHolder extends CartViewHolder {
    public TextView textView;

    public GroupViewHolder(View itemView, int chekbox_id) {
        super(itemView, chekbox_id);
        textView = itemView.findViewById(R.id.tv_source_name);
    }
}
