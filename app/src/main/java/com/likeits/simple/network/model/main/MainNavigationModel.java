package com.likeits.simple.network.model.main;

import java.io.Serializable;
import java.util.List;

public class MainNavigationModel implements Serializable {


    /**
     * style : {"iconcolor":"#c0c0c0","iconcoloron":"#5cf2ff"}
     * items : [{"linkurl":"home","iconclass":"icox-home1","iconclasscode":"e6d8","text":"首页"},{"linkurl":"category","iconclass":"icox-category","iconclasscode":"e699","text":"分类"},{"linkurl":"notice","iconclass":"icox-notice","iconclasscode":"e771","text":"公告"},{"linkurl":"cart","iconclass":"icox-cart1","iconclasscode":"e6d0","text":"购物车"},{"linkurl":"member","iconclass":"icox-people","text":"我的","iconclasscode":"e798"}]
     * adv : {"params":{"autoclose":"5"},"data":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"]}
     */

    private StyleBean style;
    private AdvBean adv;
    private List<ItemsBean> items;

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public AdvBean getAdv() {
        return adv;
    }

    public void setAdv(AdvBean adv) {
        this.adv = adv;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class StyleBean {
        /**
         * iconcolor : #c0c0c0
         * iconcoloron : #5cf2ff
         */

        private String iconcolor;
        private String iconcoloron;

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getIconcoloron() {
            return iconcoloron;
        }

        public void setIconcoloron(String iconcoloron) {
            this.iconcoloron = iconcoloron;
        }
    }

    public static class AdvBean {
        /**
         * params : {"autoclose":"5"}
         * data : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"]
         */

        private ParamsBean params;
        private List<String> data;

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        public static class ParamsBean {
            /**
             * autoclose : 5
             */

            private String autoclose;

            public String getAutoclose() {
                return autoclose;
            }

            public void setAutoclose(String autoclose) {
                this.autoclose = autoclose;
            }
        }
    }

    public static class ItemsBean {
        /**
         * linkurl : home
         * iconclass : icox-home1
         * iconclasscode : e6d8
         * text : 首页
         */

        private String linkurl;
        private String iconclass;
        private String iconclasscode;
        private String text;

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
    }
}