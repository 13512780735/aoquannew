package com.likeits.simple.network.model.gooddetails;

import java.util.List;

public class GoodTopTabItemModel {

    /**
     * goodsid : 716
     * type : 1
     * total : 9999
     * params : [{"title":"asdasd","value":""}]
     * showcomments : true
     * productprice : 2000.00
     * discounts : {"type":"0","default":"","default_pay":""}
     * marketprice : 1554.00
     * content : http://hidsy.maimaitoo.com/api/nativeapp.goods.get_contenthtml?id=716
     */

    private int goodsid;
    private String type;
    private String total;
    private boolean showcomments;
    private String productprice;
    private String discounts;
    private String marketprice;
    private String content;
    private List<ParamsBean> params;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public boolean isShowcomments() {
        return showcomments;
    }

    public void setShowcomments(boolean showcomments) {
        this.showcomments = showcomments;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getDiscounts() {
        return discounts;
    }

    public void setDiscounts(String discounts) {
        this.discounts = discounts;
    }

    public String getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(String marketprice) {
        this.marketprice = marketprice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ParamsBean> getParams() {
        return params;
    }

    public void setParams(List<ParamsBean> params) {
        this.params = params;
    }

    public static class ParamsBean {
        /**
         * title : asdasd
         * value :
         */

        private String title;
        private String value;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
