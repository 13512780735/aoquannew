package com.likeits.simple.adapter.div_provider.member;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.activity.login_register.LoginActivity;
import com.likeits.simple.network.model.member.MemberLogoutItemModel;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.BorderTextView;

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
    public void convert(BaseViewHolder helper, MemberLogoutItemModel data, int position) {
        BorderTextView tvChangePwd = helper.getView(R.id.tv_change_pwd);
        BorderTextView tvLogout = helper.getView(R.id.tv_logout);
        tvChangePwd.setContentColorResource01(Color.parseColor(data.getStyle().getPwdbgcolor()));
        tvChangePwd.setStrokeColor01(Color.parseColor(data.getStyle().getPwdbordercolor()));
        tvChangePwd.setTextColor(Color.parseColor(data.getStyle().getPwdtextcolor()));

        tvLogout.setTextColor(Color.parseColor(data.getStyle().getLogouttextcolor()));
        tvLogout.setStrokeColor01(Color.parseColor(data.getStyle().getLogoutbordercolor()));
        tvLogout.setContentColorResource01(Color.parseColor(data.getStyle().getLogoutbgcolor()));
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtils.put(mContext,"openid","");
                Intent intent=new Intent(mContext, LoginActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("linkurl","");
                intent.putExtras(bundle);
                mContext.startActivity(intent);
                AppManager.getAppManager().finishActivity();
            }
        });
    }
}
