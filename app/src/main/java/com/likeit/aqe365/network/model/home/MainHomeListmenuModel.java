package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomeListmenuModel extends HomeMessage{

    /**
     * style : {"margintop":20,"background":"#4cff58","iconcolor":"#ff285f","textcolor":"#7132fe","remarkcolor":"#4c8852"}
     * data : [{"text":"品牌专场","linkurl":"","iconclass":"","remark":"更多","dotnum":"","iconclasscode":"","params":{"id":""}},{"text":"文字1","linkurl":"","iconclass":"icox-cart","iconclasscode":"e698","remark":"查看","dotnum":"","params":{"id":""}}]
     * id : listmenu
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
         * margintop : 20
         * background : #4cff58
         * iconcolor : #ff285f
         * textcolor : #7132fe
         * remarkcolor : #4c8852
         */

        private int margintop;
        private String background;
        private String iconcolor;
        private String textcolor;
        private String remarkcolor;

        public int getMargintop() {
            return margintop;
        }

        public void setMargintop(int margintop) {
            this.margintop = margintop;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(String textcolor) {
            this.textcolor = textcolor;
        }

        public String getRemarkcolor() {
            return remarkcolor;
        }

        public void setRemarkcolor(String remarkcolor) {
            this.remarkcolor = remarkcolor;
        }
    }

    public static class DataBean {
        /**
         * text : 品牌专场
         * linkurl :
         * iconclass :
         * remark : 更多
         * dotnum :
         * iconclasscode :
         * params : {"id":""}
         */

        private String text;
        private String linkurl;
        private String iconclass;
        private String remark;
        private String dotnum;
        private String weburl;
        private String iconclasscode;
        private ParamsBean params;

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
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

        public String getIconclass() {
            return iconclass;
        }

        public void setIconclass(String iconclass) {
            this.iconclass = iconclass;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDotnum() {
            return dotnum;
        }

        public void setDotnum(String dotnum) {
            this.dotnum = dotnum;
        }

        public String getIconclasscode() {
            return iconclasscode;
        }

        public void setIconclasscode(String iconclasscode) {
            this.iconclasscode = iconclasscode;
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
