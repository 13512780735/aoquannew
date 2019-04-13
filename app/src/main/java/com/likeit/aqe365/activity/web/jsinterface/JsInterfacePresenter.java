package com.likeit.aqe365.activity.web.jsinterface;


import android.app.Fragment;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.activity.web.base.BasePresenter;
import com.likeit.aqe365.utils.SharedPreferencesUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;

public class JsInterfacePresenter extends BasePresenter implements JsInterfaceContract.Presenter {
    private final JsInterfaceContract.View mView;

    JsInterfacePresenter(JsInterfaceContract.View mView) {
        this.mView = mView;
    }

    @Override
    protected void start(boolean isFirstStart) {

        if (isFirstStart) {
            String Login = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "login");
            String mobile = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "phone");
            String pwd = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "pwd");
            String token = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "token");
            String openid = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "openid");
            String webUrl = SharedPreferencesUtils.getString(((Fragment) mView).getActivity(), "webUrl");
            mView.renderUrl(webUrl + "&openid=" + openid);
            XLog.e("url" + webUrl + "&openid=" + openid);
        }

    }

    @Override
    public void clickBtn1() {
        mView.execJavaScript("complete()");
    }

    @Override
    public void clickBtn2() {
        mView.execJavaScript("faild()");
    }

}
