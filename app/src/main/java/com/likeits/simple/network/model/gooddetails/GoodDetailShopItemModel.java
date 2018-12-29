package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

public class GoodDetailShopItemModel extends HomeMessage {

    /**
     * params : {"shoplogo":"../addons/ewei_shopv2/static/images/designer.jpg","shopname":"","shopdesc":"","hidenum":"0","leftnavtext":"全部商品","leftnavlink":"","rightnavtext":"进店逛逛","rightnavlink":""}
     * style : {"margintop":20,"marginbottom":"0","background":"#a6fbff","goodsnumcolor":"#333333","goodstextcolor":"#7c7c7c","rightnavcolor":"#65ff3f","shopnamecolor":"#ffced1","shopdesccolor":"#a96bc4"}
     * id : detail_shop
     * data : {"merch":{"logo":"http://hidsy.maimaitoo.com/attachment/images/1/2018/11/PtB6N0eT6eTs0VkOkownbeKX8KB9K8.png","shopname":"大商云商城","description":"花样百出花样百出","merchid":0,"btnurl":"home"}}
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
         * shoplogo : ../addons/ewei_shopv2/static/images/designer.jpg
         * shopname :
         * shopdesc :
         * hidenum : 0
         * leftnavtext : 全部商品
         * leftnavlink :
         * rightnavtext : 进店逛逛
         * rightnavlink :
         */

        private String shoplogo;
        private String shopname;
        private String shopdesc;
        private String hidenum;
        private String leftnavtext;
        private String leftnavlink;
        private String rightnavtext;
        private String rightnavlink;

        public String getShoplogo() {
            return shoplogo;
        }

        public void setShoplogo(String shoplogo) {
            this.shoplogo = shoplogo;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getShopdesc() {
            return shopdesc;
        }

        public void setShopdesc(String shopdesc) {
            this.shopdesc = shopdesc;
        }

        public String getHidenum() {
            return hidenum;
        }

        public void setHidenum(String hidenum) {
            this.hidenum = hidenum;
        }

        public String getLeftnavtext() {
            return leftnavtext;
        }

        public void setLeftnavtext(String leftnavtext) {
            this.leftnavtext = leftnavtext;
        }

        public String getLeftnavlink() {
            return leftnavlink;
        }

        public void setLeftnavlink(String leftnavlink) {
            this.leftnavlink = leftnavlink;
        }

        public String getRightnavtext() {
            return rightnavtext;
        }

        public void setRightnavtext(String rightnavtext) {
            this.rightnavtext = rightnavtext;
        }

        public String getRightnavlink() {
            return rightnavlink;
        }

        public void setRightnavlink(String rightnavlink) {
            this.rightnavlink = rightnavlink;
        }
    }

    public static class StyleBean {
        /**
         * margintop : 20
         * marginbottom : 0
         * background : #a6fbff
         * goodsnumcolor : #333333
         * goodstextcolor : #7c7c7c
         * rightnavcolor : #65ff3f
         * shopnamecolor : #ffced1
         * shopdesccolor : #a96bc4
         */

        private int margintop;
        private String marginbottom;
        private String background;
        private String goodsnumcolor;
        private String goodstextcolor;
        private String rightnavcolor;
        private String shopnamecolor;
        private String shopdesccolor;

        public int getMargintop() {
            return margintop;
        }

        public void setMargintop(int margintop) {
            this.margintop = margintop;
        }

        public String getMarginbottom() {
            return marginbottom;
        }

        public void setMarginbottom(String marginbottom) {
            this.marginbottom = marginbottom;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getGoodsnumcolor() {
            return goodsnumcolor;
        }

        public void setGoodsnumcolor(String goodsnumcolor) {
            this.goodsnumcolor = goodsnumcolor;
        }

        public String getGoodstextcolor() {
            return goodstextcolor;
        }

        public void setGoodstextcolor(String goodstextcolor) {
            this.goodstextcolor = goodstextcolor;
        }

        public String getRightnavcolor() {
            return rightnavcolor;
        }

        public void setRightnavcolor(String rightnavcolor) {
            this.rightnavcolor = rightnavcolor;
        }

        public String getShopnamecolor() {
            return shopnamecolor;
        }

        public void setShopnamecolor(String shopnamecolor) {
            this.shopnamecolor = shopnamecolor;
        }

        public String getShopdesccolor() {
            return shopdesccolor;
        }

        public void setShopdesccolor(String shopdesccolor) {
            this.shopdesccolor = shopdesccolor;
        }
    }

    public static class DataBean {
        /**
         * merch : {"logo":"http://hidsy.maimaitoo.com/attachment/images/1/2018/11/PtB6N0eT6eTs0VkOkownbeKX8KB9K8.png","shopname":"大商云商城","description":"花样百出花样百出","merchid":0,"btnurl":"home"}
         */

        private MerchBean merch;

        public MerchBean getMerch() {
            return merch;
        }

        public void setMerch(MerchBean merch) {
            this.merch = merch;
        }

        public static class MerchBean {
            /**
             * logo : http://hidsy.maimaitoo.com/attachment/images/1/2018/11/PtB6N0eT6eTs0VkOkownbeKX8KB9K8.png
             * shopname : 大商云商城
             * description : 花样百出花样百出
             * merchid : 0
             * btnurl : home
             */

            private String logo;
            private String shopname;
            private String description;
            private int merchid;
            private String btnurl;

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getShopname() {
                return shopname;
            }

            public void setShopname(String shopname) {
                this.shopname = shopname;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getMerchid() {
                return merchid;
            }

            public void setMerchid(int merchid) {
                this.merchid = merchid;
            }

            public String getBtnurl() {
                return btnurl;
            }

            public void setBtnurl(String btnurl) {
                this.btnurl = btnurl;
            }
        }
    }
}
