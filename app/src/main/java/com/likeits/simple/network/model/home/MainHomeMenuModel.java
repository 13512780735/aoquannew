package com.likeits.simple.network.model.home;

import java.io.Serializable;
import java.util.List;

public class MainHomeMenuModel extends HomeMessage{

    /**
     * style : {"navstyle":"","background":"#f5fffa","rownum":"5","showtype":"0","pagenum":"8","showdot":"1","row":"2"}
     * data : [{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/R3aiIDiGiV3IIV5QugdieFuIDGD3Ii.png","linkurl":"","text":"积分商城","color":"#666666","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qhRkQeXRE9Ydx95qQ9SQQq5k9x9XSr.png","linkurl":"","text":"领券中心","color":"#666666","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/IVove5ht5TTgyGlR9GTVmbGSS9HLVR.png","linkurl":"","text":"新人福利","color":"#666666","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/fQZ5KXn5K7h5sLxpZLNCnmHnTkK3zL.png","linkurl":"","text":"我的足迹","color":"#666666","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/L8WGQu1rV0ttW80qw1wR1tn4qw08Xt.png","linkurl":"","text":"会员福利","color":"#666666","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/nCwLF2RO5f446e2XnEoK32VvU5W2E2.png","linkurl":"","text":"活动专场","color":"#666666","params":{"id":""}}]
     * id : menu
     */

    private StyleBean style;
    private String id;
    private List<DataBean> data;

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

    public static class StyleBean {
        /**
         * navstyle :
         * background : #f5fffa
         * rownum : 5
         * showtype : 0
         * pagenum : 8
         * showdot : 1
         * row : 2
         */

        private String navstyle;
        private String background;
        private String rownum;
        private String showtype;
        private String pagenum;
        private String showdot;
        private String row;

        public String getNavstyle() {
            return navstyle;
        }

        public void setNavstyle(String navstyle) {
            this.navstyle = navstyle;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getRownum() {
            return rownum;
        }

        public void setRownum(String rownum) {
            this.rownum = rownum;
        }

        public String getShowtype() {
            return showtype;
        }

        public void setShowtype(String showtype) {
            this.showtype = showtype;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }

        public String getShowdot() {
            return showdot;
        }

        public void setShowdot(String showdot) {
            this.showdot = showdot;
        }

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }
    }

    public static class DataBean {
        /**
         * imgurl : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/R3aiIDiGiV3IIV5QugdieFuIDGD3Ii.png
         * linkurl :
         * text : 积分商城
         * color : #666666
         * params : {"id":""}
         */

        private String imgurl;
        private String linkurl;
        private String text;
        private String color;
        private ParamsBean params;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public static class ParamsBean {
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
