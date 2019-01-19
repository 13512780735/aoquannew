package com.likeits.simple.adapter.indent;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.Indent.IndentListModel;

import java.util.List;

public class IndentReturnsAdapter extends BaseQuickAdapter<IndentListModel.ListBean, BaseViewHolder>{
    private List<IndentListModel.ListBean.GoodsBean> datas;
    private IndentShopListAdapter mAdapter;
    public IndentReturnsAdapter(int layoutResId, List<IndentListModel.ListBean> data) {
        super(R.layout.goods_indent_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, IndentListModel.ListBean item) {
        datas = item.getGoods();
        mAdapter = new IndentShopListAdapter(R.layout.layout_indent_shop_listitems, datas);
        baseViewHolder.setText(R.id.tv_indent_number, "订单号：" + item.getOrdersn());
        baseViewHolder.setText(R.id.tv_indent_name, item.getMerchname());

        baseViewHolder.setText(R.id.tv_total_number, "共 " + item.getSum() + " 个商品,合计");
        baseViewHolder.setText(R.id.tv_total_price, "¥ " + item.getPrice());
        int status = item.getStatus();
        if (status == 4) {
            baseViewHolder.setText(R.id.tv_indent_status, item.getStatusstr());
            ((TextView) (baseViewHolder.getView(R.id.tv_indent_status))).setTextColor(Color.parseColor("#999999"));
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.view).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.tv_recover_goods).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_del_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_pay).setVisibility(View.VISIBLE);
            baseViewHolder.setText(R.id.tv_recover_goods, "恢复订单");
            baseViewHolder.setText(R.id.tv_del_indent, "彻底删除订单");
        }
//        else{
//            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.GONE);
//        }

        baseViewHolder.addOnClickListener(R.id.tv_recover_goods);
        baseViewHolder.addOnClickListener(R.id.tv_del_indent);
        baseViewHolder.addOnClickListener(R.id.rl_indent_details);
        RecyclerView mRecyclerView = baseViewHolder.getView(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }
}
