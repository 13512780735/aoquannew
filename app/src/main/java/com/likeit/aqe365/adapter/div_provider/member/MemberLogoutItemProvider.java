package com.likeit.aqe365.adapter.div_provider.member;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.login_register.LoginActivity;
import com.likeit.aqe365.activity.user.ChangePwdActivity;
import com.likeit.aqe365.network.model.member.MemberLogoutItemModel;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.AppManager01;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.BorderTextView;

public class MemberLogoutItemProvider extends BaseItemProvider<MemberLogoutItemModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MemberAdapter.TYPE_LOGOUT;
    }

    @Override
    public int layout() {
        return R.layout.member_logout_item;
    }

    @Override
    public void convert(BaseViewHolder helper, final MemberLogoutItemModel data, int position) {
        BorderTextView tvChangePwd = helper.getView(R.id.tv_change_pwd);
        BorderTextView tvLogout = helper.getView(R.id.tv_logout);
        tvChangePwd.setContentColorResource01(Color.parseColor(data.getStyle().getPwdbgcolor()));
        tvChangePwd.setStrokeColor01(Color.parseColor(data.getStyle().getPwdbordercolor()));
        tvChangePwd.setTextColor(Color.parseColor(data.getStyle().getPwdtextcolor()));

        tvLogout.setTextColor(Color.parseColor(data.getStyle().getLogouttextcolor()));
        tvLogout.setStrokeColor01(Color.parseColor(data.getStyle().getLogoutbordercolor()));
        tvLogout.setContentColorResource01(Color.parseColor(data.getStyle().getLogoutbgcolor()));
        helper.addOnClickListener(R.id.tv_logout);
//        tvLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferencesUtils.put(mContext, "openid", "");
//                SharedPreferencesUtils.put(mContext,"pwd","");
//                Intent intent = new Intent(mContext, LoginActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("linkurl", "");
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);
//                AppManager.getAppManager().finishActivity();
//              //  AppManager01.getAppManager().finishAllActivity();
//            }
//        });
        tvChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, ChangePwdActivity.class));
            }
        });

    }
}
