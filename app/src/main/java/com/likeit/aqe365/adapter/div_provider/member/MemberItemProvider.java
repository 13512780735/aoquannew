package com.likeit.aqe365.adapter.div_provider.member;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.user.UserInfoActivity;
import com.likeit.aqe365.network.model.member.MemberItemModel;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MemberItemProvider extends BaseItemProvider<MemberItemModel, BaseViewHolder> {
    private TextView tvMessage, tvSet, tv_balance01, tv_balance, tv_integral01, tv_integral, tv_name, tv_vip;
    private BorderTextView tv_recharge, tv_exchange;
    private CircleImageView ivAvatar;

    @Override
    public int viewType() {
        return MemberAdapter.TYPE_MEMBER;
    }

    @Override
    public int layout() {
        return R.layout.member_information_item;
    }

    @Override
    public void convert(BaseViewHolder helper, MemberItemModel data, int position) {

        LinearLayout ll_header01 = helper.getView(R.id.ll_header01);
        LinearLayout ll_header02 = helper.getView(R.id.ll_header02);
        ll_header02.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        ll_header01.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        tvMessage = helper.getView(R.id.tv_message);
        tvSet = helper.getView(R.id.tv_set);
        ivAvatar = helper.getView(R.id.iv_avatar);
        tv_balance01 = helper.getView(R.id.tv_balance01);
        tv_balance = helper.getView(R.id.tv_balance);
        tv_integral01 = helper.getView(R.id.tv_integral01);
        tv_integral = helper.getView(R.id.tv_integral);
        tv_name = helper.getView(R.id.tv_name);
        tv_vip = helper.getView(R.id.tv_vip);
        tv_recharge = helper.getView(R.id.tv_recharge);
        tv_exchange = helper.getView(R.id.tv_exchange);
        tv_recharge.setVisibility(View.GONE);
        tv_exchange.setVisibility(View.GONE);
        initUI(data);
        if ("default2".equals(data.getParams().getStyle())) {
            ll_header02.setVisibility(View.VISIBLE);
            ll_header01.setVisibility(View.GONE);

            tvMessage = helper.getView(R.id.tv_message1);
            tvSet = helper.getView(R.id.tv_set1);
            ivAvatar = helper.getView(R.id.iv_avatar1);
            tv_balance01 = helper.getView(R.id.tv_balance011);
            tv_balance = helper.getView(R.id.tv_balance1);
            tv_integral01 = helper.getView(R.id.tv_integral011);
            tv_integral = helper.getView(R.id.tv_integral1);
            tv_name = helper.getView(R.id.tv_name1);
            tv_vip = helper.getView(R.id.tv_vip1);
            tv_recharge = helper.getView(R.id.tv_recharge1);
            tv_exchange = helper.getView(R.id.tv_exchange1);
            tv_recharge.setVisibility(View.GONE);
            tv_exchange.setVisibility(View.GONE);
            initUI(data);
        } else if ("default1".equals(data.getParams().getStyle())) {
            ll_header01.setVisibility(View.VISIBLE);
            ll_header02.setVisibility(View.GONE);
            tvMessage = helper.getView(R.id.tv_message);
            tvSet = helper.getView(R.id.tv_set);
            ivAvatar = helper.getView(R.id.iv_avatar);
            tv_balance01 = helper.getView(R.id.tv_balance01);
            tv_balance = helper.getView(R.id.tv_balance);
            tv_integral01 = helper.getView(R.id.tv_integral01);
            tv_integral = helper.getView(R.id.tv_integral);
            tv_name = helper.getView(R.id.tv_name);
            tv_vip = helper.getView(R.id.tv_vip);
            tv_recharge = helper.getView(R.id.tv_recharge);
            tv_exchange = helper.getView(R.id.tv_exchange);
            tv_recharge.setVisibility(View.GONE);
            tv_exchange.setVisibility(View.GONE);
            initUI(data);
        }

    }

    private void initUI(MemberItemModel data) {
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        tvMessage.setTypeface(iconTypeface);
        tvSet.setTypeface(iconTypeface);
        tvSet.setTextSize(16);
        tvMessage.setTextSize(16);
        tvMessage.setText(StringUtil.decode("\\u" + "e6df"));
        tvSet.setText(StringUtil.decode("\\u" + "e68a"));
        tvSet.setTextColor(Color.parseColor("#FFFFFF"));
        tvSet.setTextSize(24);
        tv_recharge.setStrokeColor01(Color.parseColor(data.getStyle().getTextcolor()));
        tv_exchange.setStrokeColor01(Color.parseColor(data.getStyle().getTextcolor()));
        ImageLoader.getInstance().displayImage(data.getData().getAvatar(), ivAvatar);
        tv_recharge.setText(data.getParams().getLeftnav());
        tv_exchange.setText(data.getParams().getRightnav());
        tv_name.setText(data.getData().getNickname());
        tv_vip.setText(data.getData().getLevelname());
        tv_balance01.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_balance01.setText(data.getParams().getCredit2_text());
        tv_balance.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_balance.setText(data.getData().getBalance());
        tv_integral01.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_integral01.setText(data.getParams().getCredit1_text());
        tv_integral.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_integral.setText(data.getData().getIntegral());
        tv_name.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_vip.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_recharge.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        tv_exchange.setTextColor(Color.parseColor(data.getStyle().getTextcolor()));
        if ("1".equals(data.getParams().getHidebalancebtn())) {
            tv_integral01.setVisibility(View.INVISIBLE);
            tv_integral.setVisibility(View.INVISIBLE);
            tv_balance.setVisibility(View.INVISIBLE);
            tv_balance01.setVisibility(View.INVISIBLE);
//            tv_recharge.setVisibility(View.INVISIBLE);
//            tv_exchange.setVisibility(View.INVISIBLE);
        }
        if ("1".equals(data.getParams().getHideintegralbtn())) {
            tv_integral01.setVisibility(View.INVISIBLE);
            tv_integral.setVisibility(View.INVISIBLE);
        }
        if ("1".equals(data.getParams().getHidemessagebtn())) {
            tvMessage.setVisibility(View.GONE);
        }
        if ("1".equals(data.getParams().getHidesetbtn())) {
            tvSet.setVisibility(View.GONE);
        }
        tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(mContext, UserInfoActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);


            }
        });
    }
}