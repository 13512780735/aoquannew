package com.likeit.aqe365.network.model.Indent;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class GoodsRefundmodel implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private List<Express_list> express_list;

    public List<Express_list> getExpress_list() {
        return express_list;
    }

    public void setExpress_list(List<Express_list> express_list) {
        this.express_list = express_list;
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

    public static class GoodsRefundBean implements Serializable {
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
        private Refundaddress refundaddress;
        private String message;
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
        private String openid;
        private String ordersn;
        private String merch_remark;
        private String merch_status_time;
        private String isread;
        private String statustext;
        private String goods_refund_statustext;
        private List<String> images;
        private List<String> desc;

        public Refundaddress getRefundaddress() {
            return refundaddress;
        }

        public void setRefundaddress(Refundaddress refundaddress) {
            this.refundaddress = refundaddress;
        }

        public String getGoods_refund_statustext() {
            return goods_refund_statustext;
        }

        public void setGoods_refund_statustext(String goods_refund_statustext) {
            this.goods_refund_statustext = goods_refund_statustext;
        }

        public List<String> getDesc() {
            return desc;
        }

        public void setDesc(List<String> desc) {
            this.desc = desc;
        }

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


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
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

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public Object getOrdersn() {
            return ordersn;
        }

        public void setOrdersn(String ordersn) {
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

    public static class OrderBean implements Serializable {
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

    public static class GoodsBean implements Parcelable {
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
        //        private String goods_refundstate;
//        private String goods_refundid;
//        private String goods_refundtime;
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

//        public String getGoods_refundstate() {
//            return goods_refundstate;
//        }
//
//        public void setGoods_refundstate(String goods_refundstate) {
//            this.goods_refundstate = goods_refundstate;
//        }
//
//        public String getGoods_refundid() {
//            return goods_refundid;
//        }
//
//        public void setGoods_refundid(String goods_refundid) {
//            this.goods_refundid = goods_refundid;
//        }
//
//        public String getGoods_refundtime() {
//            return goods_refundtime;
//        }
//
//        public void setGoods_refundtime(String goods_refundtime) {
//            this.goods_refundtime = goods_refundtime;
//        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(thumb);
            dest.writeString(optiontitle);
            dest.writeString(optionid);
            dest.writeString(goodsid);
            dest.writeString(realprice);
        }

        public static final Parcelable.Creator<GoodsBean> CREATOR = new Creator() {

            @Override
            public GoodsBean createFromParcel(Parcel source) {
                // TODO Auto-generated method stub
                // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
                GoodsBean p = new GoodsBean();
                p.setTitle(source.readString());
                p.setThumb(source.readString());
                p.setOptiontitle(source.readString());
                p.setOptionid(source.readString());
                p.setGoodsid(source.readString());
                p.setRealprice(source.readString());
                return p;
            }

            @Override
            public GoodsBean[] newArray(int size) {
                // TODO Auto-generated method stub
                return new GoodsBean[size];
            }
        };
    }

    public static class Express_list implements Parcelable {
        /**
         * "express": "shunfeng",
         * "name": "顺丰"
         */
        private String name;
        private String express;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExpress() {
            return express;
        }

        public void setExpress(String express) {
            this.express = express;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(express);
        }

        public static final Parcelable.Creator<Express_list> CREATOR = new Creator() {

            @Override
            public Express_list createFromParcel(Parcel source) {
                // TODO Auto-generated method stub
                // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
                Express_list p = new Express_list();
                p.setName(source.readString());
                p.setExpress(source.readString());
                return p;
            }

            @Override
            public Express_list[] newArray(int size) {
                // TODO Auto-generated method stub
                return new Express_list[size];
            }
        };
    }

    public static class GoodslistBean implements Parcelable {
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
        public boolean isChoosed;
        private boolean checked;

//        public GoodslistBean(String title, String thumb, String optiontitle, String optionid, String goodsid, String realprice, Boolean checked) {
//            this.title = title;
//            this.thumb = thumb;
//            this.optiontitle = optiontitle;
//            this.optionid = optionid;
//            this.goodsid = goodsid;
//            this.realprice = realprice;
//            this.checked = checked;
//        }

        public boolean getChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public boolean isChoosed() {
            return isChoosed;
        }

        public void setChoosed(boolean choosed) {
            isChoosed = choosed;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(title);
            dest.writeString(thumb);
            dest.writeString(optiontitle);
            dest.writeString(optionid);
            dest.writeString(goodsid);
            dest.writeString(realprice);
        }

        public static final Parcelable.Creator<GoodslistBean> CREATOR = new Creator() {

            @Override
            public GoodslistBean createFromParcel(Parcel source) {
                // TODO Auto-generated method stub
                // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
                GoodslistBean p = new GoodslistBean();
                p.setTitle(source.readString());
                p.setThumb(source.readString());
                p.setOptiontitle(source.readString());
                p.setOptionid(source.readString());
                p.setGoodsid(source.readString());
                p.setRealprice(source.readString());
                return p;
            }

            @Override
            public GoodslistBean[] newArray(int size) {
                // TODO Auto-generated method stub
                return new GoodslistBean[size];
            }
        };
    }

    private static class Refundaddress implements Serializable {
        /**
         * "id": "9",
         * "title": "测试退货地址",
         * "name": "测试",
         * "tel": "",
         * "mobile": "13600000000",
         * "province": "天津",
         * "city": "河西区",
         * "area": "全境",
         * "province_id": "3",
         * "city_id": "51039",
         * "area_id": "2985",
         * "address": "测试退货",
         * "zipcode": "",
         * "content": null,
         * "merchid": "0"
         */
        private String id;
        private String title;
        private String name;
        private String tel;
        private String mobile;
        private String province;
        private String city;
        private String area;
        private String province_id;
        private String city_id;
        private String area_id;
        private String address;
        private String zipcode;
        private String content;
        private String merchid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMerchid() {
            return merchid;
        }

        public void setMerchid(String merchid) {
            this.merchid = merchid;
        }
    }
}
