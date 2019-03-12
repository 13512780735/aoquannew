package com.likeit.aqe365.adapter.indent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.indent.AfterSaleTypeActivity;
import com.likeit.aqe365.activity.indent.IndentAppraiseActivity;
import com.likeit.aqe365.activity.indent.Refund01Activity;
import com.likeit.aqe365.activity.indent.Refund02Activity;
import com.likeit.aqe365.network.model.Indent.IndentDetailModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by admin on 2018/5/14.
 */

public class IndentDatailsShopAdapter extends BaseQuickAdapter<IndentDetailModel.ShopBean.GoodsBean, BaseViewHolder> {
    private String ordId;

    public IndentDatailsShopAdapter(int layoutResId, List<IndentDetailModel.ShopBean.GoodsBean> data) {
        super(R.layout.layout_indent_details_listview_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final IndentDetailModel.ShopBean.GoodsBean item) {
        ordId = SharedPreferencesUtils.getString(mContext, "ordId");
        // ImageLoader.getInstance().displayImage(item.getUrl(), (ImageView) baseViewHolder.getView(R.id.iv_shop_avatar));
        BorderTextView tv01 = baseViewHolder.getView(R.id.tv_01);//查看售后申请进度
        //      BorderTextView tv02=baseViewHolder.getView(R.id.tv_02);//申请售后
        BorderTextView tv03 = baseViewHolder.getView(R.id.tv_03);//评价
        BorderTextView tv04 = baseViewHolder.getView(R.id.tv_04);//追加评价
        ImageLoader.getInstance().displayImage(item.getThumb(), (ImageView) baseViewHolder.getView(R.id.iv_shop_avatar));
        baseViewHolder.setText(R.id.tv_shop_name, item.getTitle());
        baseViewHolder.setText(R.id.tv_shop_price, "¥ " + item.getPrice());

        /**
         * 售后按钮
         */
        if (item.isIsshowbtn()) {
            tv01.setVisibility(View.VISIBLE);
            tv01.setText(item.getRefundstatustext());
        } else {
            tv01.setVisibility(View.GONE);
        }
        /**
         * 评价按钮
         */
        if ("0".equals(item.getClosecomment())) {
            if ("2".equals(item.getComment_btn())) {
                tv03.setVisibility(View.GONE);
                tv04.setVisibility(View.GONE);
            } else if ("0".equals(item.getComment_btn())) {
                tv03.setVisibility(View.VISIBLE);
                tv04.setVisibility(View.GONE);
            } else if ("1".equals(item.getComment_btn())) {
                tv03.setVisibility(View.GONE);
                tv04.setVisibility(View.VISIBLE);
            }
        } else {
            tv03.setVisibility(View.GONE);
            tv04.setVisibility(View.GONE);
        }


        if (StringUtil.isBlank(item.getOptionname())) {
            baseViewHolder.getView(R.id.tv_shop_size).setVisibility(View.INVISIBLE);
        } else {
            baseViewHolder.setText(R.id.tv_shop_size, "规格：" + item.getOptionname());
        }
        baseViewHolder.setText(R.id.tv_shop_number, "X" + item.getTotal());
        tv01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goods_refundid = item.getGoods_refundid();
                if ("0".equals(goods_refundid)) {
                    //为0时申請售後
                    //大于0时是查看进度
                    boolean afterrefund = item.isAfterrefund();
                    boolean payrefund = item.isPayrefund();
                    String payrefundtext = item.getPayrefundtext();
                    String afterrefundtext = item.getAfterrefundtext();
                    String goodsid = item.getId();
                    String optionid = item.getOptionid();
                    String grefundid = item.getGoods_refundid();
                    Intent intent = new Intent(mContext, AfterSaleTypeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("payrefundtext", payrefundtext);
                    bundle.putString("afterrefundtext", afterrefundtext);
                    bundle.putBoolean("afterrefund", afterrefund);
                    bundle.putBoolean("payrefund", payrefund);
                    bundle.putString("goodsid", goodsid);
                    bundle.putString("optionid", optionid);
                    bundle.putString("grefundid", grefundid);
                    bundle.putString("orderid", ordId);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                } else {
                    String rtype = item.getRtype();
                    boolean afterrefund = item.isAfterrefund();
                    boolean payrefund = item.isPayrefund();
                    String payrefundtext = item.getPayrefundtext();
                    String afterrefundtext = item.getAfterrefundtext();
                    String goodsid = item.getId();
                    String optionid = item.getOptionid();
                    String grefundid = item.getGoods_refundid();

                    Bundle bundle = new Bundle();
                    bundle.putString("type", rtype);
                    bundle.putString("goodsid", goodsid);
                    bundle.putString("optionid", optionid);
                    bundle.putString("grefundid", grefundid);
                    bundle.putString("orderid", ordId);
                    bundle.putString("payrefundtext", payrefundtext);
                    bundle.putString("afterrefundtext", afterrefundtext);
                    bundle.putBoolean("afterrefund", afterrefund);
                    bundle.putBoolean("payrefund", payrefund);

                    if ("1".equals(rtype)) {
                        Intent intent = new Intent(mContext, Refund01Activity.class);
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);
                    }else if("2".equals(rtype)){
                        Intent intent = new Intent(mContext, Refund02Activity.class);
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);
                    }
                }
            }
        });
        /**
         * 评价
         */
        tv03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goodsId = item.getId();
                Intent intent = new Intent(mContext, IndentAppraiseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("goodsId", goodsId);
                bundle.putString("ordId", ordId);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        /**
         * 追加
         */
        tv04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String goodsId = item.getId();
                Intent intent = new Intent(mContext, IndentAppraiseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("goodsId", goodsId);
                bundle.putString("ordId", ordId);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }
}
