package com.likeits.simple.adapter.indent;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.Indent.GoodsRefundmodel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class RefundGoodAdapter extends BaseQuickAdapter<GoodsRefundmodel.GoodsBean, BaseViewHolder> {
    public RefundGoodAdapter(int layoutResId, List<GoodsRefundmodel.GoodsBean> data) {
        super(R.layout.refund_good_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsRefundmodel.GoodsBean item) {
        ImageLoader.getInstance().displayImage(item.getThumb(), (ImageView) helper.getView(R.id.main_pic_iv));
        helper.setText(R.id.tv_shop_num, "¥ " + item.getRealprice());
    }
}
