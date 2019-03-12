package com.likeit.aqe365.network.model.Indent;

public class CommentShopModel {

    /**
     * goods : {"id":"604","goodsid":"788","price":"4640.00","title":"新中式全铜如意系列SHT8807-8+4吊灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg","total":"1","credit":"","optionid":"0","optiontitle":null}
     * shopname : 大商云商城
     */

    private GoodsBean goods;
    private String shopname;

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public static class GoodsBean {
        /**
         * id : 604
         * goodsid : 788
         * price : 4640.00
         * title : 新中式全铜如意系列SHT8807-8+4吊灯
         * thumb : http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg
         * total : 1
         * credit :
         * optionid : 0
         * optiontitle : null
         */

        private String id;
        private String goodsid;
        private String price;
        private String title;
        private String thumb;
        private String total;
        private String credit;
        private String optionid;
        private String optiontitle;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getOptionid() {
            return optionid;
        }

        public void setOptionid(String optionid) {
            this.optionid = optionid;
        }

        public String getOptiontitle() {
            return optiontitle;
        }

        public void setOptiontitle(String optiontitle) {
            this.optiontitle = optiontitle;
        }
    }
}
