package com.likeits.simple.network.model.gooddetails;

public class GoodDetailNavbarItemModel {

    /**
     * params : {"hidelike":"0","hideshop":"0","hidecart":"0","hidecartbtn":"0","textbuy":"您已经超出最大0件购买量","goodstext":"商品","liketext":"关注","likeiconclass":"e669","onlikeiconclass":"e668","shoptext":"店铺","shopiconclass":"e676","carttext":"购物车","carticonclass":"e698","nobuybgcolor":"#000000"}
     * style : {"background":"#ffffff","textcolor":"#999999","iconcolor":"#999999","cartcolor":"#fe9402","buycolor":"#fd5555"}
     * id : detail_navbar
     * data : {"navbar":null}
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
         * hidelike : 0
         * hideshop : 0
         * hidecart : 0
         * hidecartbtn : 0
         * textbuy : 您已经超出最大0件购买量
         * goodstext : 商品
         * liketext : 关注
         * likeiconclass : e669
         * onlikeiconclass : e668
         * shoptext : 店铺
         * shopiconclass : e676
         * carttext : 购物车
         * carticonclass : e698
         * nobuybgcolor : #000000
         */

        private String hidelike;
        private String hideshop;
        private String hidecart;
        private String hidecartbtn;
        private String textbuy;
        private String goodstext;
        private String liketext;
        private String likeiconclass;
        private String onlikeiconclass;
        private String shoptext;
        private String shopiconclass;
        private String carttext;
        private String carticonclass;
        private String nobuybgcolor;

        public String getHidelike() {
            return hidelike;
        }

        public void setHidelike(String hidelike) {
            this.hidelike = hidelike;
        }

        public String getHideshop() {
            return hideshop;
        }

        public void setHideshop(String hideshop) {
            this.hideshop = hideshop;
        }

        public String getHidecart() {
            return hidecart;
        }

        public void setHidecart(String hidecart) {
            this.hidecart = hidecart;
        }

        public String getHidecartbtn() {
            return hidecartbtn;
        }

        public void setHidecartbtn(String hidecartbtn) {
            this.hidecartbtn = hidecartbtn;
        }

        public String getTextbuy() {
            return textbuy;
        }

        public void setTextbuy(String textbuy) {
            this.textbuy = textbuy;
        }

        public String getGoodstext() {
            return goodstext;
        }

        public void setGoodstext(String goodstext) {
            this.goodstext = goodstext;
        }

        public String getLiketext() {
            return liketext;
        }

        public void setLiketext(String liketext) {
            this.liketext = liketext;
        }

        public String getLikeiconclass() {
            return likeiconclass;
        }

        public void setLikeiconclass(String likeiconclass) {
            this.likeiconclass = likeiconclass;
        }

        public String getOnlikeiconclass() {
            return onlikeiconclass;
        }

        public void setOnlikeiconclass(String onlikeiconclass) {
            this.onlikeiconclass = onlikeiconclass;
        }

        public String getShoptext() {
            return shoptext;
        }

        public void setShoptext(String shoptext) {
            this.shoptext = shoptext;
        }

        public String getShopiconclass() {
            return shopiconclass;
        }

        public void setShopiconclass(String shopiconclass) {
            this.shopiconclass = shopiconclass;
        }

        public String getCarttext() {
            return carttext;
        }

        public void setCarttext(String carttext) {
            this.carttext = carttext;
        }

        public String getCarticonclass() {
            return carticonclass;
        }

        public void setCarticonclass(String carticonclass) {
            this.carticonclass = carticonclass;
        }

        public String getNobuybgcolor() {
            return nobuybgcolor;
        }

        public void setNobuybgcolor(String nobuybgcolor) {
            this.nobuybgcolor = nobuybgcolor;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * textcolor : #999999
         * iconcolor : #999999
         * cartcolor : #fe9402
         * buycolor : #fd5555
         */

        private String background;
        private String textcolor;
        private String iconcolor;
        private String cartcolor;
        private String buycolor;

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

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getCartcolor() {
            return cartcolor;
        }

        public void setCartcolor(String cartcolor) {
            this.cartcolor = cartcolor;
        }

        public String getBuycolor() {
            return buycolor;
        }

        public void setBuycolor(String buycolor) {
            this.buycolor = buycolor;
        }
    }

    public static class DataBean {
        /**
         * navbar : null
         */

        private Object navbar;

        public Object getNavbar() {
            return navbar;
        }

        public void setNavbar(Object navbar) {
            this.navbar = navbar;
        }
    }
}
