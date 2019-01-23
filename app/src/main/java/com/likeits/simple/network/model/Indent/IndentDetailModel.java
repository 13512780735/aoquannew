package com.likeits.simple.network.model.Indent;

import java.io.Serializable;
import java.util.List;

public class IndentDetailModel implements Serializable{

    /**
     * order : {"id":"523","ordersn":"ME20190116151439565841","createtime":"2019-01-16 15:14:39","paytime":"2019-01-16 15:14:41","sendtime":"2019-01-17 14:52:25","finishtime":"","status":"2","statusstr":"卖家已发货","price":"4010.00","goodsprice":"8020.00","dispatchprice":"0.00","ispackage":"0","seckilldiscountprice":"0.00","deductenough":"0.00","couponprice":"0.00","discountprice":"4010.00","isdiscountprice":"0.00","deductprice":"0.00","deductcredit2":"0.00","diyformfields":null,"diyformdata":null,"showverify":false,"verifytitle":"消费码","dispatchtype":"0","verifyinfo":false,"invoicename":null,"merchid":155,"virtual":"0","virtual_str":"","virtual_info":"","isvirtualsend":"0","virtualsend_info":"","canrefund":true,"refundtext":"申请售后","refundtext_btn":"申请售后","cancancel":false,"canpay":false,"canverify":false,"candelete":false,"cancomment":false,"cancomment2":false,"cancomplete":true,"cancancelrefund":false,"candelete2":false,"canrestore":false,"verifytype":"0","refundstate":"0","icon":"e623","city_express_state":null,"iscycelbuy":"0","isonlyverifygoods":false}
     * gift : null
     * address : {"id":"102","uniacid":"1","openid":"wap_user_1_13715679523","realname":"长春机场见","mobile":"123123123","province":"天津市","city":"天津辖县","area":"静海县","address":"12123","isdefault":"1","zipcode":"","deleted":"0","street":"","datavalue":"","streetdatavalue":"","lng":"","lat":""}
     * express : {"time":"2018-10-13 13:15:12","step":"【中山市】 快件已在 【中山北区】 签收, 签收人: 拍照签收, 如有疑问请电联:13790738589 / 0760-88709095, 您的快递已经妥投, 如果您对我们的服务感到满意, 请给个五星好评, 鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】","expresscom":"中通速递","expresssn":"73104808754885"}
     * carrier : false
     * store : false
     * stores : false
     * shop : {"name":"四合堂","logo":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tK3k9KJ9JJj7nIIn0jPNKn3KJNzfJr.jpg","goods":[{"id":"787","title":"新中式全铜如意系列SHT8807-8吊灯","price":"3380.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/yPShSE0EO1vhi1PZg0EP12NzsgEoWE.png","total":"1","isfullback":"0","fullbackgoods":null,"status":"1","optionname":"","diyformdata":null,"diyformfields":null,"refundtext_btn":"申请售后","closecomment":"0","goods_refundid":"0","optionid":"0","goods_refundtime":"0","rtype":"0","refundstatustext":"售后申请","isshowbtn":true,"payrefund":false,"afterrefund":true,"payrefundtext":"（未收到货）(包含未签收，)或卖家协商同意前提下","afterrefundtext":"(已收到货,产品有损坏或不符合)，需要卖家退货或退换"},{"id":"788","title":"新中式全铜如意系列SHT8807-8+4吊灯","price":"4640.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg","total":"1","isfullback":"0","fullbackgoods":null,"status":"1","optionname":"","diyformdata":null,"diyformfields":null,"refundtext_btn":"申请售后","closecomment":"0","goods_refundid":"0","optionid":"0","goods_refundtime":"0","rtype":"0","refundstatustext":"售后申请","isshowbtn":true,"payrefund":false,"afterrefund":true,"payrefundtext":"（未收到货）(包含未签收，)或卖家协商同意前提下","afterrefundtext":"(已收到货,产品有损坏或不符合)，需要卖家退货或退换"}]}
     * customer : 0
     * phone : 0
     * fullbacktext : 全返
     * seckill_color :
     * use_membercard : false
     * membercard_info : null
     */

    private OrderBean order;
    private Object gift;
    private AddressBean address;
    private ExpressBean express;
    private boolean carrier;
    private boolean store;
    private boolean stores;
    private ShopBean shop;
    private int customer;
    private int phone;
    private String fullbacktext;
    private String seckill_color;
    private boolean use_membercard;
    private Object membercard_info;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public Object getGift() {
        return gift;
    }

    public void setGift(Object gift) {
        this.gift = gift;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public ExpressBean getExpress() {
        return express;
    }

    public void setExpress(ExpressBean express) {
        this.express = express;
    }

    public boolean isCarrier() {
        return carrier;
    }

    public void setCarrier(boolean carrier) {
        this.carrier = carrier;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public boolean isStores() {
        return stores;
    }

    public void setStores(boolean stores) {
        this.stores = stores;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFullbacktext() {
        return fullbacktext;
    }

    public void setFullbacktext(String fullbacktext) {
        this.fullbacktext = fullbacktext;
    }

    public String getSeckill_color() {
        return seckill_color;
    }

    public void setSeckill_color(String seckill_color) {
        this.seckill_color = seckill_color;
    }

    public boolean isUse_membercard() {
        return use_membercard;
    }

    public void setUse_membercard(boolean use_membercard) {
        this.use_membercard = use_membercard;
    }

    public Object getMembercard_info() {
        return membercard_info;
    }

    public void setMembercard_info(Object membercard_info) {
        this.membercard_info = membercard_info;
    }

    public static class OrderBean {
        /**
         * id : 523
         * ordersn : ME20190116151439565841
         * createtime : 2019-01-16 15:14:39
         * paytime : 2019-01-16 15:14:41
         * sendtime : 2019-01-17 14:52:25
         * finishtime :
         * status : 2
         * statusstr : 卖家已发货
         * price : 4010.00
         * goodsprice : 8020.00
         * dispatchprice : 0.00
         * ispackage : 0
         * seckilldiscountprice : 0.00
         * deductenough : 0.00
         * couponprice : 0.00
         * discountprice : 4010.00
         * isdiscountprice : 0.00
         * deductprice : 0.00
         * deductcredit2 : 0.00
         * diyformfields : null
         * diyformdata : null
         * showverify : false
         * verifytitle : 消费码
         * dispatchtype : 0
         * verifyinfo : false
         * invoicename : null
         * merchid : 155
         * virtual : 0
         * virtual_str :
         * virtual_info :
         * isvirtualsend : 0
         * virtualsend_info :
         * canrefund : true
         * refundtext : 申请售后
         * refundtext_btn : 申请售后
         * cancancel : false
         * canpay : false
         * canverify : false
         * candelete : false
         * cancomment : false
         * cancomment2 : false
         * cancomplete : true
         * cancancelrefund : false
         * candelete2 : false
         * canrestore : false
         * verifytype : 0
         * refundstate : 0
         * icon : e623
         * city_express_state : null
         * iscycelbuy : 0
         * isonlyverifygoods : false
         */

        private String id;
        private String ordersn;
        private String createtime;
        private String paytime;
        private String sendtime;
        private String finishtime;
        private String status;
        private String statusstr;
        private String price;
        private String goodsprice;
        private String dispatchprice;
        private String ispackage;
        private String seckilldiscountprice;
        private String deductenough;
        private String couponprice;
        private String discountprice;
        private String isdiscountprice;
        private String deductprice;
        private String deductcredit2;
        private Object diyformfields;
        private Object diyformdata;
        private boolean showverify;
        private String verifytitle;
        private String dispatchtype;
        private boolean verifyinfo;
        private Object invoicename;
        private int merchid;
        private String virtual;
        private String virtual_str;
        private String virtual_info;
        private String isvirtualsend;
        private String virtualsend_info;
        private boolean canrefund;
        private String refundtext;
        private String refundtext_btn;
        private boolean cancancel;
        private boolean canpay;
        private boolean canverify;
        private boolean candelete;
        private boolean cancomment;
        private boolean cancomment2;
        private boolean cancomplete;
        private boolean cancancelrefund;
        private boolean candelete2;
        private boolean canrestore;
        private String verifytype;
        private String refundstate;
        private String icon;
        private Object city_express_state;
        private String iscycelbuy;
        private boolean isonlyverifygoods;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrdersn() {
            return ordersn;
        }

        public void setOrdersn(String ordersn) {
            this.ordersn = ordersn;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getPaytime() {
            return paytime;
        }

        public void setPaytime(String paytime) {
            this.paytime = paytime;
        }

        public String getSendtime() {
            return sendtime;
        }

        public void setSendtime(String sendtime) {
            this.sendtime = sendtime;
        }

        public String getFinishtime() {
            return finishtime;
        }

        public void setFinishtime(String finishtime) {
            this.finishtime = finishtime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatusstr() {
            return statusstr;
        }

        public void setStatusstr(String statusstr) {
            this.statusstr = statusstr;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getGoodsprice() {
            return goodsprice;
        }

        public void setGoodsprice(String goodsprice) {
            this.goodsprice = goodsprice;
        }

        public String getDispatchprice() {
            return dispatchprice;
        }

        public void setDispatchprice(String dispatchprice) {
            this.dispatchprice = dispatchprice;
        }

        public String getIspackage() {
            return ispackage;
        }

        public void setIspackage(String ispackage) {
            this.ispackage = ispackage;
        }

        public String getSeckilldiscountprice() {
            return seckilldiscountprice;
        }

        public void setSeckilldiscountprice(String seckilldiscountprice) {
            this.seckilldiscountprice = seckilldiscountprice;
        }

        public String getDeductenough() {
            return deductenough;
        }

        public void setDeductenough(String deductenough) {
            this.deductenough = deductenough;
        }

        public String getCouponprice() {
            return couponprice;
        }

        public void setCouponprice(String couponprice) {
            this.couponprice = couponprice;
        }

        public String getDiscountprice() {
            return discountprice;
        }

        public void setDiscountprice(String discountprice) {
            this.discountprice = discountprice;
        }

        public String getIsdiscountprice() {
            return isdiscountprice;
        }

        public void setIsdiscountprice(String isdiscountprice) {
            this.isdiscountprice = isdiscountprice;
        }

        public String getDeductprice() {
            return deductprice;
        }

        public void setDeductprice(String deductprice) {
            this.deductprice = deductprice;
        }

        public String getDeductcredit2() {
            return deductcredit2;
        }

        public void setDeductcredit2(String deductcredit2) {
            this.deductcredit2 = deductcredit2;
        }

        public Object getDiyformfields() {
            return diyformfields;
        }

        public void setDiyformfields(Object diyformfields) {
            this.diyformfields = diyformfields;
        }

        public Object getDiyformdata() {
            return diyformdata;
        }

        public void setDiyformdata(Object diyformdata) {
            this.diyformdata = diyformdata;
        }

        public boolean isShowverify() {
            return showverify;
        }

        public void setShowverify(boolean showverify) {
            this.showverify = showverify;
        }

        public String getVerifytitle() {
            return verifytitle;
        }

        public void setVerifytitle(String verifytitle) {
            this.verifytitle = verifytitle;
        }

        public String getDispatchtype() {
            return dispatchtype;
        }

        public void setDispatchtype(String dispatchtype) {
            this.dispatchtype = dispatchtype;
        }

        public boolean isVerifyinfo() {
            return verifyinfo;
        }

        public void setVerifyinfo(boolean verifyinfo) {
            this.verifyinfo = verifyinfo;
        }

        public Object getInvoicename() {
            return invoicename;
        }

        public void setInvoicename(Object invoicename) {
            this.invoicename = invoicename;
        }

        public int getMerchid() {
            return merchid;
        }

        public void setMerchid(int merchid) {
            this.merchid = merchid;
        }

        public String getVirtual() {
            return virtual;
        }

        public void setVirtual(String virtual) {
            this.virtual = virtual;
        }

        public String getVirtual_str() {
            return virtual_str;
        }

        public void setVirtual_str(String virtual_str) {
            this.virtual_str = virtual_str;
        }

        public String getVirtual_info() {
            return virtual_info;
        }

        public void setVirtual_info(String virtual_info) {
            this.virtual_info = virtual_info;
        }

        public String getIsvirtualsend() {
            return isvirtualsend;
        }

        public void setIsvirtualsend(String isvirtualsend) {
            this.isvirtualsend = isvirtualsend;
        }

        public String getVirtualsend_info() {
            return virtualsend_info;
        }

        public void setVirtualsend_info(String virtualsend_info) {
            this.virtualsend_info = virtualsend_info;
        }

        public boolean isCanrefund() {
            return canrefund;
        }

        public void setCanrefund(boolean canrefund) {
            this.canrefund = canrefund;
        }

        public String getRefundtext() {
            return refundtext;
        }

        public void setRefundtext(String refundtext) {
            this.refundtext = refundtext;
        }

        public String getRefundtext_btn() {
            return refundtext_btn;
        }

        public void setRefundtext_btn(String refundtext_btn) {
            this.refundtext_btn = refundtext_btn;
        }

        public boolean isCancancel() {
            return cancancel;
        }

        public void setCancancel(boolean cancancel) {
            this.cancancel = cancancel;
        }

        public boolean isCanpay() {
            return canpay;
        }

        public void setCanpay(boolean canpay) {
            this.canpay = canpay;
        }

        public boolean isCanverify() {
            return canverify;
        }

        public void setCanverify(boolean canverify) {
            this.canverify = canverify;
        }

        public boolean isCandelete() {
            return candelete;
        }

        public void setCandelete(boolean candelete) {
            this.candelete = candelete;
        }

        public boolean isCancomment() {
            return cancomment;
        }

        public void setCancomment(boolean cancomment) {
            this.cancomment = cancomment;
        }

        public boolean isCancomment2() {
            return cancomment2;
        }

        public void setCancomment2(boolean cancomment2) {
            this.cancomment2 = cancomment2;
        }

        public boolean isCancomplete() {
            return cancomplete;
        }

        public void setCancomplete(boolean cancomplete) {
            this.cancomplete = cancomplete;
        }

        public boolean isCancancelrefund() {
            return cancancelrefund;
        }

        public void setCancancelrefund(boolean cancancelrefund) {
            this.cancancelrefund = cancancelrefund;
        }

        public boolean isCandelete2() {
            return candelete2;
        }

        public void setCandelete2(boolean candelete2) {
            this.candelete2 = candelete2;
        }

        public boolean isCanrestore() {
            return canrestore;
        }

        public void setCanrestore(boolean canrestore) {
            this.canrestore = canrestore;
        }

        public String getVerifytype() {
            return verifytype;
        }

        public void setVerifytype(String verifytype) {
            this.verifytype = verifytype;
        }

        public String getRefundstate() {
            return refundstate;
        }

        public void setRefundstate(String refundstate) {
            this.refundstate = refundstate;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Object getCity_express_state() {
            return city_express_state;
        }

        public void setCity_express_state(Object city_express_state) {
            this.city_express_state = city_express_state;
        }

        public String getIscycelbuy() {
            return iscycelbuy;
        }

        public void setIscycelbuy(String iscycelbuy) {
            this.iscycelbuy = iscycelbuy;
        }

        public boolean isIsonlyverifygoods() {
            return isonlyverifygoods;
        }

        public void setIsonlyverifygoods(boolean isonlyverifygoods) {
            this.isonlyverifygoods = isonlyverifygoods;
        }
    }

    public static class AddressBean {
        /**
         * id : 102
         * uniacid : 1
         * openid : wap_user_1_13715679523
         * realname : 长春机场见
         * mobile : 123123123
         * province : 天津市
         * city : 天津辖县
         * area : 静海县
         * address : 12123
         * isdefault : 1
         * zipcode :
         * deleted : 0
         * street :
         * datavalue :
         * streetdatavalue :
         * lng :
         * lat :
         */

        private String id;
        private String uniacid;
        private String openid;
        private String realname;
        private String mobile;
        private String province;
        private String city;
        private String area;
        private String address;
        private String isdefault;
        private String zipcode;
        private String deleted;
        private String street;
        private String datavalue;
        private String streetdatavalue;
        private String lng;
        private String lat;

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

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIsdefault() {
            return isdefault;
        }

        public void setIsdefault(String isdefault) {
            this.isdefault = isdefault;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getDatavalue() {
            return datavalue;
        }

        public void setDatavalue(String datavalue) {
            this.datavalue = datavalue;
        }

        public String getStreetdatavalue() {
            return streetdatavalue;
        }

        public void setStreetdatavalue(String streetdatavalue) {
            this.streetdatavalue = streetdatavalue;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }

    public static class ExpressBean {
        /**
         * time : 2018-10-13 13:15:12
         * step : 【中山市】 快件已在 【中山北区】 签收, 签收人: 拍照签收, 如有疑问请电联:13790738589 / 0760-88709095, 您的快递已经妥投, 如果您对我们的服务感到满意, 请给个五星好评, 鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】
         * expresscom : 中通速递
         * expresssn : 73104808754885
         */

        private String time;
        private String step;
        private String expresscom;
        private String expresssn;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
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
    }

    public static class ShopBean {
        /**
         * name : 四合堂
         * logo : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tK3k9KJ9JJj7nIIn0jPNKn3KJNzfJr.jpg
         * goods : [{"id":"787","title":"新中式全铜如意系列SHT8807-8吊灯","price":"3380.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/yPShSE0EO1vhi1PZg0EP12NzsgEoWE.png","total":"1","isfullback":"0","fullbackgoods":null,"status":"1","optionname":"","diyformdata":null,"diyformfields":null,"refundtext_btn":"申请售后","closecomment":"0","goods_refundid":"0","optionid":"0","goods_refundtime":"0","rtype":"0","refundstatustext":"售后申请","isshowbtn":true,"payrefund":false,"afterrefund":true,"payrefundtext":"（未收到货）(包含未签收，)或卖家协商同意前提下","afterrefundtext":"(已收到货,产品有损坏或不符合)，需要卖家退货或退换"},{"id":"788","title":"新中式全铜如意系列SHT8807-8+4吊灯","price":"4640.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg","total":"1","isfullback":"0","fullbackgoods":null,"status":"1","optionname":"","diyformdata":null,"diyformfields":null,"refundtext_btn":"申请售后","closecomment":"0","goods_refundid":"0","optionid":"0","goods_refundtime":"0","rtype":"0","refundstatustext":"售后申请","isshowbtn":true,"payrefund":false,"afterrefund":true,"payrefundtext":"（未收到货）(包含未签收，)或卖家协商同意前提下","afterrefundtext":"(已收到货,产品有损坏或不符合)，需要卖家退货或退换"}]
         */

        private String name;
        private String logo;
        private List<GoodsBean> goods;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * id : 787
             * title : 新中式全铜如意系列SHT8807-8吊灯
             * price : 3380.00
             * thumb : http://hidsy.maimaitoo.com/attachment/images/1/merch/155/yPShSE0EO1vhi1PZg0EP12NzsgEoWE.png
             * total : 1
             * isfullback : 0
             * fullbackgoods : null
             * status : 1
             * optionname :
             * diyformdata : null
             * diyformfields : null
             * refundtext_btn : 申请售后
             * closecomment : 0
             * goods_refundid : 0
             * optionid : 0
             * comment_btn
             * goods_refundtime : 0
             * rtype : 0
             * refundstatustext : 售后申请
             * isshowbtn : true
             * payrefund : false
             * afterrefund : true
             * payrefundtext : （未收到货）(包含未签收，)或卖家协商同意前提下
             * afterrefundtext : (已收到货,产品有损坏或不符合)，需要卖家退货或退换
             */

            private String id;
            private String title;
            private String price;
            private String thumb;
            private String total;
            private String isfullback;
            private Object fullbackgoods;
            private String status;
            private String optionname;
            private Object diyformdata;
            private Object diyformfields;
            private String refundtext_btn;
            private String closecomment;
            private String goods_refundid;
            private String optionid;
            private String goods_refundtime;
            private String rtype;
            private String refundstatustext;
            private  String comment_btn;
            private boolean isshowbtn;
            private boolean payrefund;
            private boolean afterrefund;
            private String payrefundtext;
            private String afterrefundtext;

            public String getComment_btn() {
                return comment_btn;
            }

            public void setComment_btn(String comment_btn) {
                this.comment_btn = comment_btn;
            }

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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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

            public String getIsfullback() {
                return isfullback;
            }

            public void setIsfullback(String isfullback) {
                this.isfullback = isfullback;
            }

            public Object getFullbackgoods() {
                return fullbackgoods;
            }

            public void setFullbackgoods(Object fullbackgoods) {
                this.fullbackgoods = fullbackgoods;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getOptionname() {
                return optionname;
            }

            public void setOptionname(String optionname) {
                this.optionname = optionname;
            }

            public Object getDiyformdata() {
                return diyformdata;
            }

            public void setDiyformdata(Object diyformdata) {
                this.diyformdata = diyformdata;
            }

            public Object getDiyformfields() {
                return diyformfields;
            }

            public void setDiyformfields(Object diyformfields) {
                this.diyformfields = diyformfields;
            }

            public String getRefundtext_btn() {
                return refundtext_btn;
            }

            public void setRefundtext_btn(String refundtext_btn) {
                this.refundtext_btn = refundtext_btn;
            }

            public String getClosecomment() {
                return closecomment;
            }

            public void setClosecomment(String closecomment) {
                this.closecomment = closecomment;
            }

            public String getGoods_refundid() {
                return goods_refundid;
            }

            public void setGoods_refundid(String goods_refundid) {
                this.goods_refundid = goods_refundid;
            }

            public String getOptionid() {
                return optionid;
            }

            public void setOptionid(String optionid) {
                this.optionid = optionid;
            }

            public String getGoods_refundtime() {
                return goods_refundtime;
            }

            public void setGoods_refundtime(String goods_refundtime) {
                this.goods_refundtime = goods_refundtime;
            }

            public String getRtype() {
                return rtype;
            }

            public void setRtype(String rtype) {
                this.rtype = rtype;
            }

            public String getRefundstatustext() {
                return refundstatustext;
            }

            public void setRefundstatustext(String refundstatustext) {
                this.refundstatustext = refundstatustext;
            }

            public boolean isIsshowbtn() {
                return isshowbtn;
            }

            public void setIsshowbtn(boolean isshowbtn) {
                this.isshowbtn = isshowbtn;
            }

            public boolean isPayrefund() {
                return payrefund;
            }

            public void setPayrefund(boolean payrefund) {
                this.payrefund = payrefund;
            }

            public boolean isAfterrefund() {
                return afterrefund;
            }

            public void setAfterrefund(boolean afterrefund) {
                this.afterrefund = afterrefund;
            }

            public String getPayrefundtext() {
                return payrefundtext;
            }

            public void setPayrefundtext(String payrefundtext) {
                this.payrefundtext = payrefundtext;
            }

            public String getAfterrefundtext() {
                return afterrefundtext;
            }

            public void setAfterrefundtext(String afterrefundtext) {
                this.afterrefundtext = afterrefundtext;
            }
        }
    }
}
