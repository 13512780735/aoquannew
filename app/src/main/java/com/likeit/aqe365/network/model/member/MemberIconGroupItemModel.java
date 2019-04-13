package com.likeit.aqe365.network.model.member;

import com.likeit.aqe365.network.model.home.HomeMessage;

import java.util.List;

public class MemberIconGroupItemModel extends HomeMessage{

    /**
     * params : {"rownum":"4","border":"1","bordertop":"1","borderbottom":"1"}
     * style : {"background":"#ffffff","bordercolor":"#ffffff","textcolor":"#000000","iconcolor":"#666666","dotcolor":"#ff0011"}
     * data : [{"iconclass":"icox-appreciate","iconclasscode":"e644","text":"待付款","linkurl":"","dotnum":"0","params":{"id":""}},{"iconclass":"icox-check","iconclasscode":"e645","text":"待发货","linkurl":"","dotnum":"0","params":{"id":""}},{"iconclass":"icox-close1","iconclasscode":"e646","text":"待收货","linkurl":"","dotnum":"0","params":{"id":""}},{"iconclass":"icox-edit1","iconclasscode":"e649","text":"退换货","linkurl":"","dotnum":"0","params":{"id":""}}]
     * id : icongroup
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * rownum : 4
         * border : 1
         * bordertop : 1
         * borderbottom : 1
         */

        private String rownum;
        private String border;
        private String bordertop;
        private String borderbottom;

        public String getRownum() {
            return rownum;
        }

        public void setRownum(String rownum) {
            this.rownum = rownum;
        }

        public String getBorder() {
            return border;
        }

        public void setBorder(String border) {
            this.border = border;
        }

        public String getBordertop() {
            return bordertop;
        }

        public void setBordertop(String bordertop) {
            this.bordertop = bordertop;
        }

        public String getBorderbottom() {
            return borderbottom;
        }

        public void setBorderbottom(String borderbottom) {
            this.borderbottom = borderbottom;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * bordercolor : #ffffff
         * textcolor : #000000
         * iconcolor : #666666
         * dotcolor : #ff0011
         */

        private String background;
        private String bordercolor;
        private String textcolor;
        private String iconcolor;
        private String dotcolor;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getBordercolor() {
            return bordercolor;
        }

        public void setBordercolor(String bordercolor) {
            this.bordercolor = bordercolor;
        }

        public String getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(String textcolor) {
            this.textcolor = textcolor;
        }

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getDotcolor() {
            return dotcolor;
        }

        public void setDotcolor(String dotcolor) {
            this.dotcolor = dotcolor;
        }
    }

    public static class DataBean {
        /**
         * iconclass : icox-appreciate
         * iconclasscode : e644
         * text : 待付款
         * linkurl :
         * dotnum : 0
         * params : {"id":""}
         */

        private String iconclass;
        private String iconclasscode;
        private String text;
        private String linkurl;
        private String dotnum;
        private String weburl;
        private ParamsBeanX params;

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getIconclass() {
            return iconclass;
        }

        public void setIconclass(String iconclass) {
            this.iconclass = iconclass;
        }

        public String getIconclasscode() {
            return iconclasscode;
        }

        public void setIconclasscode(String iconclasscode) {
            this.iconclasscode = iconclasscode;
        }

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

        public String getDotnum() {
            return dotnum;
        }

        public void setDotnum(String dotnum) {
            this.dotnum = dotnum;
        }

        public ParamsBeanX getParams() {
            return params;
        }

        public void setParams(ParamsBeanX params) {
            this.params = params;
        }

        public static class ParamsBeanX {
            /**
             * id :
             */

            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
