package com.likeit.aqe365.activity.web.model;

import android.webkit.JavascriptInterface;

import com.likeit.aqe365.activity.web.base.BaseFragment;

import org.json.JSONObject;

import java.util.HashMap;

public class JsInterfaceLogic {
    private BaseFragment mFragment;
    private String type;
    private String code;

    public JsInterfaceLogic(BaseFragment mFragment) {
        this.mFragment = mFragment;
    }

    @JavascriptInterface
    public void login(String account, String password) {
        mFragment.showNativeMessage(String.format("执行登录操作，账号为：%s，密码为：%s", account, password));
    }

    @JavascriptInterface
    public void logout() {

        mFragment.showNativeMessage("");
    }

    @JavascriptInterface
    public void weixinPay(String str) {
        mFragment.showWeChatPay(str);
    }

    @JavascriptInterface
    public void alipayPay(String str) {
        mFragment.showAlipayPay(str);
    }

    @JavascriptInterface
    public void showShare(String str) {
        mFragment.appShare(str);
    }

    @JavascriptInterface
    public void app_linkurl(String str) {
        mFragment.app_linkurl(str);
    }
    @JavascriptInterface
    public void tologin() {
        mFragment.tologin();
    }

    @JavascriptInterface
    public void app_back() {
        mFragment.app_back();
    }

    @JavascriptInterface
    public String is_app() {
       return "Android";
    }

    @JavascriptInterface
    public String getLoginUser() {
        return new JSONObject(new HashMap(4) {{
            put("user_id", 666);
            put("username", "你就说6不6");
            put("sex", "未知");
            put("isStudent", false);
        }}).toString();
    }


    @JavascriptInterface
    public String isShowPay() {
        return new JSONObject(new HashMap(4) {{
            put("boolean", true);
        }}).toString();
    }
}
