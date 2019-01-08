package com.likeits.simple.network.model.gooddetails;

import java.util.List;

public class GoodParams {

    /**
     * goodsid : 716
     * type : 1
     * total : 888
     * productprice : 0.00
     * isseckill : false
     * canbuy : 1
     * params : [{"title":"品牌","value":"品牌名称"},{"title":"灯具","value":"8头"},{"title":"发货方式","value":"中通物流"},{"title":"参数02","value":"参数详情20190105"},{"title":"参数03","value":"55555"}]
     * showcomments : true
     * nowtime : 1546677049
     * content : http://hidsy.maimaitoo.com/api/nativeapp.goods.get_contenthtml?id=716
     */

    private String goodsid;
    private String type;
    private String total;
    private String productprice;
    private boolean isseckill;
    private int canbuy;
    private boolean showcomments;
    private int nowtime;
    private String content;
    private List<ParamsBean> params;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
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

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public boolean isIsseckill() {
        return isseckill;
    }

    public void setIsseckill(boolean isseckill) {
        this.isseckill = isseckill;
    }

    public int getCanbuy() {
        return canbuy;
    }

    public void setCanbuy(int canbuy) {
        this.canbuy = canbuy;
    }

    public boolean isShowcomments() {
        return showcomments;
    }

    public void setShowcomments(boolean showcomments) {
        this.showcomments = showcomments;
    }

    public int getNowtime() {
        return nowtime;
    }

    public void setNowtime(int nowtime) {
        this.nowtime = nowtime;
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
         * title : 品牌
         * value : 品牌名称
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
