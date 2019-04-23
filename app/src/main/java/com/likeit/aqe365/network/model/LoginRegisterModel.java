package com.likeit.aqe365.network.model;

public class LoginRegisterModel {


    /**
     * openid : a4f8410db28786e0b068b1c3ff98e5cb12cae64d9b26f5a1
     * expire : 0
     * token : MjI4Zm9QdkhVYWtGclA1OEp5aTh4ZUxEV0lVempkY2dwL3pKaG12a2RnTXVLQnBnTnhEWWVZNnE2MXhzMkcwQWNheHJDenNjaXJsLw==
     */

    private String openid;
    private int expire;
    private String token;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
