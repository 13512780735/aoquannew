package com.likeits.simple.network.model.Indent;

import java.util.List;

public class GoodsRefundmodel {

    /**
     * rtype : 1
     * rtypetext : 退款
     * goods : [{"goodsid":"595","goods_refundstate":"1","goods_refundid":"142","goods_refundtime":"0","optionid":"843","title":"测试","thumb":"images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png","realprice":"8.00","optiontitle":"02+04"}]
     * handletype : 仅退款
     * goods_refund : {"id":"142","uniacid":"1","orderid":"571","goodsid":"595","refundno":"SR20190121162049264848","reason":"拍错规格/型号/款式","images":["images/1/2019/01/Gc29E9jSA2922Z1KAw713DaD9WGKyc.jpg"],"content":"","createtime":"1548058849","refundtype":null,"status":"0","merch_status":"0","reply":null,"price":null,"applyprice":"8.00","rtype":"1","refundaddress":null,"message":null,"express":"","expresscom":"","expresssn":"","operatetime":"0","sendtime":"0","returntime":"0","refundtime":"0","rexpress":"","rexpresscom":"","rexpresssn":"","refundaddressid":"0","endtime":"0","merchid":"0","parts_num":"0","optionid":"843","realgrefundprice":"0.00","goods_status":"","openid":null,"ordersn":null,"merch_remark":null,"merch_status_time":"0","isread":"0"}
     * order : {"id":"571","status":"1","price":"23.00","dispatchprice":"15.00","ordersn":"SH20190118163919262212","finishtime":"0","merchid":"0"}
     * goodslist : [{"title":"测试","thumb":"images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png","optiontitle":"02+04","optionid":"843","goodsid":"595","realprice":"8.00"}]
     */

    private int rtype;
    private String rtypetext;
    private String handletype;
    private GoodsRefundBean goods_refund;
    private OrderBean order;
    private List<GoodsBean> goods;
    private List<GoodslistBean> goodslist;

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public String getRtypetext() {
        return rtypetext;
    }

    public void setRtypetext(String rtypetext) {
        this.rtypetext = rtypetext;
    }

    public String getHandletype() {
        return handletype;
    }

    public void setHandletype(String handletype) {
        this.handletype = handletype;
    }

    public GoodsRefundBean getGoods_refund() {
        return goods_refund;
    }

    public void setGoods_refund(GoodsRefundBean goods_refund) {
        this.goods_refund = goods_refund;
    }

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public List<GoodslistBean> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<GoodslistBean> goodslist) {
        this.goodslist = goodslist;
    }

    public static class GoodsRefundBean {
        /**
         * id : 142
         * uniacid : 1
         * orderid : 571
         * goodsid : 595
         * refundno : SR20190121162049264848
         * reason : 拍错规格/型号/款式
         * images : ["images/1/2019/01/Gc29E9jSA2922Z1KAw713DaD9WGKyc.jpg"]
         * content :
         * createtime : 1548058849
         * refundtype : null
         * status : 0
         * merch_status : 0
         * reply : null
         * price : null
         * applyprice : 8.00
         * rtype : 1
         * refundaddress : null
         * message : null
         * express :
         * expresscom :
         * expresssn :
         * operatetime : 0
         * sendtime : 0
         * returntime : 0
         * refundtime : 0
         * rexpress :
         * rexpresscom :
         * rexpresssn :
         * refundaddressid : 0
         * endtime : 0
         * merchid : 0
         * parts_num : 0
         * optionid : 843
         * realgrefundprice : 0.00
         * goods_status :
         * openid : null
         * ordersn : null
         * merch_remark : null
         * merch_status_time : 0
         * isread : 0
         */

        private String id;
        private String uniacid;
        private String orderid;
        private String goodsid;
        private String refundno;
        private String reason;
        private String content;
        private String createtime;
        private Object refundtype;
        private String status;
        private String merch_status;
        private Object reply;
        private Object price;
        private String applyprice;
        private String rtype;
        private Object refundaddress;
        private Object message;
        private String express;
        private String expresscom;
        private String expresssn;
        private String operatetime;
        private String sendtime;
        private String returntime;
        private String refundtime;
        private String rexpress;
        private String rexpresscom;
        private String rexpresssn;
        private String refundaddressid;
        private String endtime;
        private String merchid;
        private String parts_num;
        private String optionid;
        private String realgrefundprice;
        private String goods_status;
        private Object openid;
        private Object ordersn;
        private Object merch_remark;
        private String merch_status_time;
        private String isread;
        private List<String> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUniacid() {
            return uniacid;
        }

        public void setUniacid(String uniacid) {
            this.uniacid = uniacid;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getRefundno() {
            return refundno;
        }

        public void setRefundno(String refundno) {
            this.refundno = refundno;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getRefundtype() {
            return refundtype;
        }

        public void setRefundtype(Object refundtype) {
            this.refundtype = refundtype;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMerch_status() {
            return merch_status;
        }

        public void setMerch_status(String merch_status) {
            this.merch_status = merch_status;
        }

        public Object getReply() {
            return reply;
        }

        public void setReply(Object reply) {
            this.reply = reply;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public String getApplyprice() {
            return applyprice;
        }

        public void setApplyprice(String applyprice) {
            this.applyprice = applyprice;
        }

        public String getRtype() {
            return rtype;
        }

        public void setRtype(String rtype) {
            this.rtype = rtype;
        }

        public Object getRefundaddress() {
            return refundaddress;
        }

        public void setRefundaddress(Object refundaddress) {
            this.refundaddress = refundaddress;
        }

        public Object getMessage() {
            return message;
        }

        public void setMessage(Object message) {
            this.message = message;
        }

        public String getExpress() {
            return express;
        }

        public void setExpress(String express) {
            this.express = express;
        }

        public String getExpresscom() {
            return expresscom;
        }

        public void setExpresscom(String expresscom) {
            this.expresscom = expresscom;
        }

        public String getExpresssn() {
            return expresssn;
        }

        public void setExpresssn(String expresssn) {
            this.expresssn = expresssn;
        }

        public String getOperatetime() {
            return operatetime;
        }

        public void setOperatetime(String operatetime) {
            this.operatetime = operatetime;
        }

        public String getSendtime() {
            return sendtime;
        }

        public void setSendtime(String sendtime) {
            this.sendtime = sendtime;
        }

        public String getReturntime() {
            return returntime;
        }

        public void setReturntime(String returntime) {
            this.returntime = returntime;
        }

        public String getRefundtime() {
            return refundtime;
        }

        public void setRefundtime(String refundtime) {
            this.refundtime = refundtime;
        }

        public String getRexpress() {
            return rexpress;
        }

        public void setRexpress(String rexpress) {
            this.rexpress = rexpress;
        }

        public String getRexpresscom() {
            return rexpresscom;
        }

        public void setRexpresscom(String rexpresscom) {
            this.rexpresscom = rexpresscom;
        }

        public String getRexpresssn() {
            return rexpresssn;
        }

        public void setRexpresssn(String rexpresssn) {
            this.rexpresssn = rexpresssn;
        }

        public String getRefundaddressid() {
            return refundaddressid;
        }

        public void setRefundaddressid(String refundaddressid) {
            this.refundaddressid = refundaddressid;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getMerchid() {
            return merchid;
        }

        public void setMerchid(String merchid) {
            this.merchid = merchid;
        }

        public String getParts_num() {
            return parts_num;
        }

        public void setParts_num(String parts_num) {
            this.parts_num = parts_num;
        }

        public String getOptionid() {
            return optionid;
        }

        public void setOptionid(String optionid) {
            this.optionid = optionid;
        }

        public String getRealgrefundprice() {
            return realgrefundprice;
        }

        public void setRealgrefundprice(String realgrefundprice) {
            this.realgrefundprice = realgrefundprice;
        }

        public String getGoods_status() {
            return goods_status;
        }

        public void setGoods_status(String goods_status) {
            this.goods_status = goods_status;
        }

        public Object getOpenid() {
            return openid;
        }

        public void setOpenid(Object openid) {
            this.openid = openid;
        }

        public Object getOrdersn() {
            return ordersn;
        }

        public void setOrdersn(Object ordersn) {
            this.ordersn = ordersn;
        }

        public Object getMerch_remark() {
            return merch_remark;
        }

        public void setMerch_remark(Object merch_remark) {
            this.merch_remark = merch_remark;
        }

        public String getMerch_status_time() {
            return merch_status_time;
        }

        public void setMerch_status_time(String merch_status_time) {
            this.merch_status_time = merch_status_time;
        }

        public String getIsread() {
            return isread;
        }

        public void setIsread(String isread) {
            this.isread = isread;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class OrderBean {
        /**
         * id : 571
         * status : 1
         * price : 23.00
         * dispatchprice : 15.00
         * ordersn : SH20190118163919262212
         * finishtime : 0
         * merchid : 0
         */

        private String id;
        private String status;
        private String price;
        private String dispatchprice;
        private String ordersn;
        private String finishtime;
        private String merchid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDispatchprice() {
            return dispatchprice;
        }

        public void setDispatchprice(String dispatchprice) {
            this.dispatchprice = dispatchprice;
        }

        public String getOrdersn() {
            return ordersn;
        }

        public void setOrdersn(String ordersn) {
            this.ordersn = ordersn;
        }

        public String getFinishtime() {
            return finishtime;
        }

        public void setFinishtime(String finishtime) {
            this.finishtime = finishtime;
        }

        public String getMerchid() {
            return merchid;
        }

        public void setMerchid(String merchid) {
            this.merchid = merchid;
        }
    }

    public static class GoodsBean {
        /**
         * goodsid : 595
         * goods_refundstate : 1
         * goods_refundid : 142
         * goods_refundtime : 0
         * optionid : 843
         * title : 测试
         * thumb : images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png
         * realprice : 8.00
         * optiontitle : 02+04
         */

        private String goodsid;
        private String goods_refundstate;
        private String goods_refundid;
        private String goods_refundtime;
        private String optionid;
        private String title;
        private String thumb;
        private String realprice;
        private String optiontitle;

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getGoods_refundstate() {
            return goods_refundstate;
        }

        public void setGoods_refundstate(String goods_refundstate) {
            this.goods_refundstate = goods_refundstate;
        }

        public String getGoods_refundid() {
            return goods_refundid;
        }

        public void setGoods_refundid(String goods_refundid) {
            this.goods_refundid = goods_refundid;
        }

        public String getGoods_refundtime() {
            return goods_refundtime;
        }

        public void setGoods_refundtime(String goods_refundtime) {
            this.goods_refundtime = goods_refundtime;
        }

        public String getOptionid() {
            return optionid;
        }

        public void setOptionid(String optionid) {
            this.optionid = optionid;
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

        public String getRealprice() {
            return realprice;
        }

        public void setRealprice(String realprice) {
            this.realprice = realprice;
        }

        public String getOptiontitle() {
            return optiontitle;
        }

        public void setOptiontitle(String optiontitle) {
            this.optiontitle = optiontitle;
        }
    }

    public static class GoodslistBean {
        /**
         * title : 测试
         * thumb : images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png
         * optiontitle : 02+04
         * optionid : 843
         * goodsid : 595
         * realprice : 8.00
         */

        private String title;
        private String thumb;
        private String optiontitle;
        private String optionid;
        private String goodsid;
        private String realprice;

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

        public String getOptiontitle() {
            return optiontitle;
        }

        public void setOptiontitle(String optiontitle) {
            this.optiontitle = optiontitle;
        }

        public String getOptionid() {
            return optionid;
        }

        public void setOptionid(String optionid) {
            this.optionid = optionid;
        }

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getRealprice() {
            return realprice;
        }

        public void setRealprice(String realprice) {
            this.realprice = realprice;
        }
    }
}
