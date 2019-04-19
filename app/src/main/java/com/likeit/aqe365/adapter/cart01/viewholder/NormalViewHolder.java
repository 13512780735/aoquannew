package com.likeit.aqe365.adapter.cart01.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.cart01.bean.GoodsBean;
import com.ocnyang.cartlayout.viewholder.CartViewHolder;

public class NormalViewHolder extends CartViewHolder  {

    public LinearLayout ll_empty;

    public NormalViewHolder(View itemView, int chekbox_id) {
        super(itemView, chekbox_id);
        ll_empty = itemView.findViewById(R.id.ll_empty);
    }

}
