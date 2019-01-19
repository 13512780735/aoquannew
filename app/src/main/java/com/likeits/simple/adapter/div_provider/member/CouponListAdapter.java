package com.likeits.simple.adapter.div_provider.member;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.CaseEntity;
import com.likeits.simple.network.model.member.CouponListModel;
import com.likeits.simple.view.BorderRelativeLayout;
import com.likeits.simple.view.BorderTextView;

import java.util.List;

/**
 * Created by admin on 2018/5/23.
 */

public class CouponListAdapter extends BaseQuickAdapter<CouponListModel.ListBean, BaseViewHolder> {
    public CouponListAdapter(int layoutResId, List<CouponListModel.ListBean> data) {
        super(R.layout.layout_coupon_listview_items, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CouponListModel.ListBean item) {
        BorderRelativeLayout rl_coupon_left=baseViewHolder.getView(R.id.rl_coupon_left);
        BorderTextView tv_use=baseViewHolder.getView(R.id.tv_use);
        TextView tv_price=baseViewHolder.getView(R.id.tv_price);
        TextView tv_content=baseViewHolder.getView(R.id.tv_content);
        TextView tv_price_size=baseViewHolder.getView(R.id.tv_price_size);
        TextView tv_name=baseViewHolder.getView(R.id.tv_name);
        TextView tv_title=baseViewHolder.getView(R.id.tv_title);
        TextView tv_time=baseViewHolder.getView(R.id.tv_time);
        TextView tv_coupon=baseViewHolder.getView(R.id.tv_coupon);

        String check=item.getCheck();
        if("0".equals(check)){
            tv_use.setContentColorResource01(Color.parseColor("#FF424D"));
            tv_use.setStrokeColor01(Color.parseColor("#FF424D"));
            tv_use.setText("去使用");
            tv_use.setTextColor(Color.parseColor("#FFFFFF"));
        }else if("1".equals(check)){
            tv_use.setContentColorResource01(Color.parseColor("#FFFFFF"));
            tv_use.setStrokeColor01(Color.parseColor("#FFFFFF"));
            tv_use.setText("已使用");
            tv_time.setVisibility(View.INVISIBLE);
            tv_use.setTextColor(Color.parseColor(item.getColor()));
        }else if("2".equals(check)){
            tv_use.setContentColorResource01(Color.parseColor("#FFFFFF"));
            tv_use.setStrokeColor01(Color.parseColor("#FFFFFF"));
            tv_use.setText("已过期");
            tv_time.setVisibility(View.INVISIBLE);
            tv_use.setTextColor(Color.parseColor("#999999"));
        }
        rl_coupon_left.setContentColorResource01(Color.parseColor(item.getColor()));
        rl_coupon_left.setStrokeColor01(Color.parseColor(item.getColor()));
        tv_price.setText(item.getTitle3());
        tv_content.setText(item.getTitle4());
        tv_price_size.setText(item.getCategory());
        tv_name.setText(item.getCouponname());
        tv_title.setText(item.getTitle2());
        tv_time.setText(item.getFinite_time());
        tv_coupon.setText(item.getTagtitle());

    }
}
