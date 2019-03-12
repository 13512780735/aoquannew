package com.likeit.aqe365.network.model;

import java.util.List;

public class DiyTabModel {

    /**
     * style : {"color":"#333","activecolor":"#0080ff"}
     * params : {"tab_left":"1","tab_lefticon":"icox-cameraaddfill","tab_lefticoncode":"e78c","tab_leftcolor":"#999999","tab_right":"1","tab_righticon":"icox-roundaddfill","tab_righticoncode":"e727","tab_rightcolor":"#999999","tab_lefticonurl":"home","tab_righticonurl":"goods"}
     * data : [{"text":"首页","linkurl":"home"},{"text":"推荐","linkurl":"isrecommand"},{"text":"关注","linkurl":"isdiscount"},{"text":"最新","linkurl":"isnew"}]
     * id : tab
     */

    private StyleBean style;
    private ParamsBean params;
    private String id;
    private List<DataBean> data;

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StyleBean {
        /**
         * color : #333
         * activecolor : #0080ff
         */

        private String color;
        private String activecolor;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getActivecolor() {
            return activecolor;
        }

        public void setActivecolor(String activecolor) {
            this.activecolor = activecolor;
        }
    }

    public static class ParamsBean {
        /**
         * tab_left : 1
         * tab_lefticon : icox-cameraaddfill
         * tab_lefticoncode : e78c
         * tab_leftcolor : #999999
         * tab_right : 1
         * tab_righticon : icox-roundaddfill
         * tab_righticoncode : e727
         * tab_rightcolor : #999999
         * tab_lefticonurl : home
         * tab_righticonurl : goods
         */

        private String tab_left;
        private String tab_lefticon;
        private String tab_lefticoncode;
        private String tab_leftcolor;
        private String tab_right;
        private String tab_righticon;
        private String tab_righticoncode;
        private String tab_rightcolor;
        private String tab_lefticonurl;
        private String tab_righticonurl;

        public String getTab_left() {
            return tab_left;
        }

        public void setTab_left(String tab_left) {
            this.tab_left = tab_left;
        }

        public String getTab_lefticon() {
            return tab_lefticon;
        }

        public void setTab_lefticon(String tab_lefticon) {
            this.tab_lefticon = tab_lefticon;
        }

        public String getTab_lefticoncode() {
            return tab_lefticoncode;
        }

        public void setTab_lefticoncode(String tab_lefticoncode) {
            this.tab_lefticoncode = tab_lefticoncode;
        }

        public String getTab_leftcolor() {
            return tab_leftcolor;
        }

        public void setTab_leftcolor(String tab_leftcolor) {
            this.tab_leftcolor = tab_leftcolor;
        }

        public String getTab_right() {
            return tab_right;
        }

        public void setTab_right(String tab_right) {
            this.tab_right = tab_right;
        }

        public String getTab_righticon() {
            return tab_righticon;
        }

        public void setTab_righticon(String tab_righticon) {
            this.tab_righticon = tab_righticon;
        }

        public String getTab_righticoncode() {
            return tab_righticoncode;
        }

        public void setTab_righticoncode(String tab_righticoncode) {
            this.tab_righticoncode = tab_righticoncode;
        }

        public String getTab_rightcolor() {
            return tab_rightcolor;
        }

        public void setTab_rightcolor(String tab_rightcolor) {
            this.tab_rightcolor = tab_rightcolor;
        }

        public String getTab_lefticonurl() {
            return tab_lefticonurl;
        }

        public void setTab_lefticonurl(String tab_lefticonurl) {
            this.tab_lefticonurl = tab_lefticonurl;
        }

        public String getTab_righticonurl() {
            return tab_righticonurl;
        }

        public void setTab_righticonurl(String tab_righticonurl) {
            this.tab_righticonurl = tab_righticonurl;
        }
    }

    public static class DataBean {
        /**
         * text : 首页
         * linkurl : home
         */

        private String text;
        private String linkurl;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }
}
