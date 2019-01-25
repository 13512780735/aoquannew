package com.likeits.simple.network.model.Indent;

import java.util.List;

public class GoodsRefundmodel {

    /**
     * rtypetext : 退款
     * goods : [{"goodsid":"266","goods_refundstate":"1","goods_refundid":"143","goods_refundtime":"1548381718","optionid":"0","title":"金玉满堂P9271-12+6吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/Q08N0Gni8nhoz0SNQNvnJ2JMNhiGjG.jpg","realprice":"6760.00","optiontitle":""},{"goodsid":"269","goods_refundstate":"1","goods_refundid":"143","goods_refundtime":"1548381718","optionid":"0","title":"金玉满堂P9271-6吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/u90WTQQk9qr79e7tZwSeC8qK7zTofW.jpg","realprice":"2360.00","optiontitle":""},{"goodsid":"403","goods_refundstate":"1","goods_refundid":"143","goods_refundtime":"1548381718","optionid":"0","title":"金玉满堂P9271-8+4吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/gCrJDV15jq988i89Q5kW4koQsb9nQ1.jpg","realprice":"6560.00","optiontitle":""}]
     * handletype : 仅退款
     * goods_refund : {"id":"143","uniacid":"1","orderid":"575","goodsid":"266,269,403","refundno":"SR20190124113026811858","reason":"拍错规格/型号/款式","images":["http://hidsy.maimaitoo.com/attachment/images/1/2019/01/OHw7zipRhQR1f2fErfp1EV0EH2z2ei.jpg"],"content":"","createtime":"1548314291","refundtype":"1","status":"1","merch_status":"1","reply":"","price":"15680.00","applyprice":"15680.00","rtype":"1","refundaddress":null,"message":null,"express":"","expresscom":"","expresssn":"","operatetime":"1548381718","sendtime":"0","returntime":"0","refundtime":"1548381718","rexpress":"","rexpresscom":"","rexpresssn":"","refundaddressid":"0","endtime":"0","merchid":"113","parts_num":"0","optionid":"0,0,0","realgrefundprice":"15680.00","goods_status":"","openid":null,"ordersn":null,"merch_remark":"优秀","merch_status_time":"1548381678","isread":"1","statustext":"退款处理已完成"}
     * order : {"id":"575","status":"-1","price":"22800.00","dispatchprice":"0.00","ordersn":"ME20190121164558604864","finishtime":"0","merchid":"113"}
     * goodslist : [{"title":"金玉满堂P9271-12+6吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/Q08N0Gni8nhoz0SNQNvnJ2JMNhiGjG.jpg","optiontitle":"","optionid":"0","goodsid":"266","realprice":"6760.00"},{"title":"金玉满堂P9271-8吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/IK0e0HB0kbyy0b424B42l0PPK22n0T.jpg","optiontitle":"","optionid":"0","goodsid":"268","realprice":"3160.00"},{"title":"金玉满堂P9271-6吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/u90WTQQk9qr79e7tZwSeC8qK7zTofW.jpg","optiontitle":"","optionid":"0","goodsid":"269","realprice":"2360.00"},{"title":"金玉满堂P9271-8+4吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/gCrJDV15jq988i89Q5kW4koQsb9nQ1.jpg","optiontitle":"","optionid":"0","goodsid":"403","realprice":"6560.00"},{"title":"金玉满堂P9271-10吊灯艺术水晶灯客厅灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/kpr381y3885RP0004reX3iXtZkRr97.jpg","optiontitle":"","optionid":"0","goodsid":"267","realprice":"3960.00"}]
     * step : 3
     */

    private String rtypetext;
    private String handletype;
    private GoodsRefundBean goods_refund;
    private OrderBean order;
    private int step;
    private List<GoodsBean> goods;
    private List<GoodslistBean> goodslist;

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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
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
         * id : 143
         * uniacid : 1
         * orderid : 575
         * goodsid : 266,269,403
         * refundno : SR20190124113026811858
         * reason : 拍错规格/型号/款式
         * images : ["http://hidsy.maimaitoo.com/attachment/images/1/2019/01/OHw7zipRhQR1f2fErfp1EV0EH2z2ei.jpg"]
         * content :
         * createtime : 1548314291
         * refundtype : 1
         * status : 1
         * merch_status : 1
         * reply :
         * price : 15680.00
         * applyprice : 15680.00
         * rtype : 1
         * refundaddress : null
         * message : null
         * express :
         * expresscom :
         * expresssn :
         * operatetime : 1548381718
         * sendtime : 0
         * returntime : 0
         * refundtime : 1548381718
         * rexpress :
         * rexpresscom :
         * rexpresssn :
         * refundaddressid : 0
         * endtime : 0
         * merchid : 113
         * parts_num : 0
         * optionid : 0,0,0
         * realgrefundprice : 15680.00
         * goods_status :
         * openid : null
         * ordersn : null
         * merch_remark : 优秀
         * merch_status_time : 1548381678
         * isread : 1
         * statustext : 退款处理已完成
         */

        private String id;
        private String uniacid;
        private String orderid;
        private String goodsid;
        private String refundno;
        private String reason;
        private String content;
        private String createtime;
        private String refundtype;
        private String status;
        private String merch_status;
        private String reply;
        private String price;
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
        private String merch_remark;
        private String merch_status_time;
        private String isread;
        private String statustext;
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

        public String getRefundtype() {
            return refundtype;
        }

        public void setRefundtype(String refundtype) {
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

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
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

        public String getMerch_remark() {
            return merch_remark;
        }

        public void setMerch_remark(String merch_remark) {
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

        public String getStatustext() {
            return statustext;
        }

        public void setStatustext(String statustext) {
            this.statustext = statustext;
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
         * id : 575
         * status : -1
         * price : 22800.00
         * dispatchprice : 0.00
         * ordersn : ME20190121164558604864
         * finishtime : 0
         * merchid : 113
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
         * goodsid : 266
         * goods_refundstate : 1
         * goods_refundid : 143
         * goods_refundtime : 1548381718
         * optionid : 0
         * title : 金玉满堂P9271-12+6吊灯艺术水晶灯客厅灯餐厅灯卧室灯
         * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/09/Q08N0Gni8nhoz0SNQNvnJ2JMNhiGjG.jpg
         * realprice : 6760.00
         * optiontitle :
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
         * title : 金玉满堂P9271-12+6吊灯艺术水晶灯客厅灯餐厅灯卧室灯
         * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/09/Q08N0Gni8nhoz0SNQNvnJ2JMNhiGjG.jpg
         * optiontitle :
         * optionid : 0
         * goodsid : 266
         * realprice : 6760.00
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
