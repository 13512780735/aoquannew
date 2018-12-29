package com.likeits.simple.network.model.main;

import java.io.Serializable;
import java.util.List;

public class MainNavigationModel implements Serializable {


    /**
     * style : {"iconcolor":"#008040","iconcoloron":"#999999"}
     * items : [{"linkurl":"home","iconclass":"icox-warehouse-delivery","iconclasscode":"e87e","text":"商城首页"},{"linkurl":"goods","iconclass":"icox-category","iconclasscode":"e699","text":"全部商品"},{"linkurl":"commission","iconclass":"icox-favorite","iconclasscode":"e6a0","text":"分销中心"},{"linkurl":"cart","iconclass":"icox-cart","iconclasscode":"e698","text":"购物车"},{"linkurl":"member","iconclass":"icox-account","iconclasscode":"e6b8","text":"个人中心"}]
     */

    private StyleBean style;
    private List<ItemsBean> items;

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class StyleBean {
        /**
         * iconcolor : #008040
         * iconcoloron : #999999
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

    public static class ItemsBean {
        /**
         * linkurl : home
         * iconclass : icox-warehouse-delivery
         * iconclasscode : e87e
         * text : 商城首页
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