package com.likeit.aqe365.adapter.indent;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class RefundGoodAdapter01 extends BaseQuickAdapter<String, BaseViewHolder> {
    public RefundGoodAdapter01(int layoutResId, List<String> data) {
        super(R.layout.refund_good_view01, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageLoader.getInstance().displayImage(item, (ImageView) helper.getView(R.id.main_pic_iv));
       //TextView tv_shop_num=helper.getView(R.id.tv_shop_num);
      // tv_shop_num.setText("¥ " + item.getRealprice());
       // helper.setText(R.id.tv_shop_num, "¥ " + item.getRealprice());
    }
}
