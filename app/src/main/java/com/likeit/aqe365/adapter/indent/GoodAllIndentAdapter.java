package com.likeit.aqe365.adapter.indent;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.Indent.IndentListModel;

import java.util.List;

/**
 * Created by admin on 2018/5/11.
 */

public class GoodAllIndentAdapter extends BaseQuickAdapter<IndentListModel.ListBean, BaseViewHolder> {
    private List<IndentListModel.ListBean.GoodsBean> datas;
    private IndentShopListAdapter mAdapter;

    public GoodAllIndentAdapter(int layoutResId, List<IndentListModel.ListBean> data) {
        super(R.layout.goods_indent_items, data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, IndentListModel.ListBean item) {
        datas = item.getGoods();
        mAdapter = new IndentShopListAdapter(R.layout.layout_indent_shop_listitems, datas);
        baseViewHolder.setText(R.id.tv_indent_number, "订单号：" + item.getOrdersn());
        baseViewHolder.setText(R.id.tv_indent_name, item.getMerchname());

        baseViewHolder.setText(R.id.tv_total_number, "共 " + item.getSum() + " 个商品,合计");
        baseViewHolder.setText(R.id.tv_total_price, "¥ " + item.getPrice());
        int status = item.getStatus();
        if (status == 0) {
            baseViewHolder.setText(R.id.tv_indent_status, "待付款");
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_cancel_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_pay).setVisibility(View.VISIBLE);
            baseViewHolder.setText(R.id.tv_cancel_indent, "取消订单");
            baseViewHolder.setText(R.id.tv_pay, "支付订单");
        } else if (status == 1) {
            baseViewHolder.setText(R.id.tv_indent_status, "待发货");
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.view).setVisibility(View.GONE);

        } else if (status == 2) {
            baseViewHolder.setText(R.id.tv_indent_status, "待收货");
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_check_wuLiu).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_confirm_goods).setVisibility(View.VISIBLE);
            baseViewHolder.setText(R.id.tv_check_wuLiu, "查看物流");
            baseViewHolder.setText(R.id.tv_confirm_goods, "确认收货");

        } else if (status == 3) {
            baseViewHolder.setText(R.id.tv_indent_status, "等待评价");
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_del_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_appraise_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_check_wuLiu).setVisibility(View.VISIBLE);
            baseViewHolder.setText(R.id.tv_del_indent, "删除订单");
            baseViewHolder.setText(R.id.tv_appraise_indent, "评价");
            baseViewHolder.setText(R.id.tv_check_wuLiu, "查看物流");

        } else if (status == 4) {
            baseViewHolder.setText(R.id.tv_indent_status, item.getStatusstr());
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.view).setVisibility(View.GONE);
        } else if (status == 5) {
            baseViewHolder.setText(R.id.tv_indent_status, "已取消");
            ((TextView) (baseViewHolder.getView(R.id.tv_indent_status))).setTextColor(Color.parseColor("#999999"));
            baseViewHolder.getView(R.id.ll_indent_button).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_recover_goods).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.tv_cancel_indent).setVisibility(View.GONE);
            baseViewHolder.getView(R.id.tv_del_indent).setVisibility(View.VISIBLE);
            baseViewHolder.getView(R.id.tv_pay).setVisibility(View.GONE);
            baseViewHolder.setText(R.id.tv_del_indent, "删除订单");
        }


        baseViewHolder.addOnClickListener(R.id.rl_indent_details);

        baseViewHolder.addOnClickListener(R.id.tv_pay);
        baseViewHolder.addOnClickListener(R.id.tv_cancel_indent);
        baseViewHolder.addOnClickListener(R.id.tv_confirm_goods);
        baseViewHolder.addOnClickListener(R.id.tv_check_wuLiu);
        baseViewHolder.addOnClickListener(R.id.tv_del_indent);
        RecyclerView mRecyclerView = baseViewHolder.getView(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        baseViewHolder.getView(R.id.rl_indent_details).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //模拟父控件的点击
                    baseViewHolder.getConvertView().performClick();
                }
                return false;
            }
        });
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    //模拟父控件的点击
                    baseViewHolder.getConvertView().performClick();
                }
                return false;
            }
        });

    }

}
