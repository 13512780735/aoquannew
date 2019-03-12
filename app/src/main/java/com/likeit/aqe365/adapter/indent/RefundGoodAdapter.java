package com.likeit.aqe365.adapter.indent;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class RefundGoodAdapter extends BaseQuickAdapter<GoodsRefundmodel.GoodsBean, BaseViewHolder> {
    public RefundGoodAdapter(int layoutResId, List<GoodsRefundmodel.GoodsBean> data) {
        super(R.layout.refund_good_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsRefundmodel.GoodsBean item) {
        ImageLoader.getInstance().displayImage(item.getThumb(), (ImageView) helper.getView(R.id.main_pic_iv));
       TextView tv_shop_num=helper.getView(R.id.tv_shop_num);
       tv_shop_num.setText("¥ " + item.getRealprice());
       // helper.setText(R.id.tv_shop_num, "¥ " + item.getRealprice());
    }
}
