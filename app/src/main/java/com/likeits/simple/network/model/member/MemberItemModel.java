package com.likeits.simple.network.model.member;

import com.likeits.simple.network.model.home.HomeMessage;

public class MemberItemModel extends HomeMessage{

    /**
     * params : {"style":"default1","leftnav":"充值s","rightnav":"兑换","hidemessagebtn":"0","hidesetbtn":"0","hidebalancebtn":"0","hideintegralbtn":"0","credit1_text":"积分2","credit2_text":"余额2"}
     * style : {"background":"#fe5455","textcolor":"#90ffbf","textlight":"#fef31f","headstyle":"","bgimg":""}
     * id : member
     * data : {"mobile":"13600000001","integral":"0.00","balance":"8965.00","levelname":"普通会员","nickname":"136xxxx0001","avatar":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/static/images/noface.png"}
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private DataBean data;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * style : default1
         * leftnav : 充值s
         * rightnav : 兑换
         * hidemessagebtn : 0
         * hidesetbtn : 0
         * hidebalancebtn : 0
         * hideintegralbtn : 0
         * credit1_text : 积分2
         * credit2_text : 余额2
         */

        private String style;
        private String leftnav;
        private String rightnav;
        private String hidemessagebtn;
        private String hidesetbtn;
        private String hidebalancebtn;
        private String hideintegralbtn;
        private String credit1_text;
        private String credit2_text;

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getLeftnav() {
            return leftnav;
        }

        public void setLeftnav(String leftnav) {
            this.leftnav = leftnav;
        }

        public String getRightnav() {
            return rightnav;
        }

        public void setRightnav(String rightnav) {
            this.rightnav = rightnav;
        }

        public String getHidemessagebtn() {
            return hidemessagebtn;
        }

        public void setHidemessagebtn(String hidemessagebtn) {
            this.hidemessagebtn = hidemessagebtn;
        }

        public String getHidesetbtn() {
            return hidesetbtn;
        }

        public void setHidesetbtn(String hidesetbtn) {
            this.hidesetbtn = hidesetbtn;
        }

        public String getHidebalancebtn() {
            return hidebalancebtn;
        }

        public void setHidebalancebtn(String hidebalancebtn) {
            this.hidebalancebtn = hidebalancebtn;
        }

        public String getHideintegralbtn() {
            return hideintegralbtn;
        }

        public void setHideintegralbtn(String hideintegralbtn) {
            this.hideintegralbtn = hideintegralbtn;
        }

        public String getCredit1_text() {
            return credit1_text;
        }

        public void setCredit1_text(String credit1_text) {
            this.credit1_text = credit1_text;
        }

        public String getCredit2_text() {
            return credit2_text;
        }

        public void setCredit2_text(String credit2_text) {
            this.credit2_text = credit2_text;
        }
    }

    public static class StyleBean {
        /**
         * background : #fe5455
         * textcolor : #90ffbf
         * textlight : #fef31f
         * headstyle :
         * bgimg :
         */

        private String background;
        private String textcolor;
        private String textlight;
        private String headstyle;
        private String bgimg;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(String textcolor) {
            this.textcolor = textcolor;
        }

        public String getTextlight() {
            return textlight;
        }

        public void setTextlight(String textlight) {
            this.textlight = textlight;
        }

        public String getHeadstyle() {
            return headstyle;
        }

        public void setHeadstyle(String headstyle) {
            this.headstyle = headstyle;
        }

        public String getBgimg() {
            return bgimg;
        }

        public void setBgimg(String bgimg) {
            this.bgimg = bgimg;
        }
    }

    public static class DataBean {
        /**
         * mobile : 13600000001
         * integral : 0.00
         * balance : 8965.00
         * levelname : 普通会员
         * nickname : 136xxxx0001
         * avatar : http://hidsy.maimaitoo.com/addons/ewei_shopv2/static/images/noface.png
         */

        private String mobile;
        private String integral;
        private String balance;
        private String levelname;
        private String nickname;
        private String avatar;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getLevelname() {
            return levelname;
        }

        public void setLevelname(String levelname) {
            this.levelname = levelname;
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
    }
}
