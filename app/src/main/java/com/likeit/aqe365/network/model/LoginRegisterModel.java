package com.likeit.aqe365.network.model;

public class LoginRegisterModel {

    /**
     * openid : wap_user_1_13600000000
     * mobile : 13600000000
     * nickname : 136xxxx0000
     * avatar : http://hidsy.maimaitoo.com/addons/ewei_shopv2/static/images/noface.png
     * expire : 0
     */

    private String openid;
    private String mobile;
    private String nickname;
    private String avatar;
    private int expire;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
