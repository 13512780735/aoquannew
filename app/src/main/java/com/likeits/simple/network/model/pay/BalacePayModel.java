package com.likeits.simple.network.model.pay;

import java.io.Serializable;

public class BalacePayModel implements Serializable{

    /**
     * order : {"id":471,"isverify":"0","virtual":"0","isvirtual":"0","isvirtualsend":"0","virtualsend_info":null,"virtual_str":null,"status":"订单支付成功","text":"您的包裹整装待发","price":"767.00"}
     * paytype : 实付金额
     * carrier : false
     * address : {"id":"87","uniacid":"1","openid":"wap_user_1_13600000000","realname":"ppp","mobile":"15019911212","province":"上海市","city":"杨浦区","area":"杨浦区","address":"999","isdefault":"1","zipcode":"","deleted":"0","street":"","datavalue":"","streetdatavalue":"","lng":"","lat":""}
     * stores : false
     * store : false
     * icon : e623
     * seckill_color :
     */

    private OrderBean order;
    private String paytype;
    private boolean carrier;
    private AddressBean address;
    private boolean stores;
    private boolean store;
    private String icon;
    private String seckill_color;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public boolean isCarrier() {
        return carrier;
    }

    public void setCarrier(boolean carrier) {
        this.carrier = carrier;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public boolean isStores() {
        return stores;
    }

    public void setStores(boolean stores) {
        this.stores = stores;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSeckill_color() {
        return seckill_color;
    }

    public void setSeckill_color(String seckill_color) {
        this.seckill_color = seckill_color;
    }

    public static class OrderBean {
        /**
         * id : 471
         * isverify : 0
         * virtual : 0
         * isvirtual : 0
         * isvirtualsend : 0
         * virtualsend_info : null
         * virtual_str : null
         * status : 订单支付成功
         * text : 您的包裹整装待发
         * price : 767.00
         */

        private int id;
        private String isverify;
        private String virtual;
        private String isvirtual;
        private String isvirtualsend;
        private Object virtualsend_info;
        private Object virtual_str;
        private String status;
        private String text;
        private String price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIsverify() {
            return isverify;
        }

        public void setIsverify(String isverify) {
            this.isverify = isverify;
        }

        public String getVirtual() {
            return virtual;
        }

        public void setVirtual(String virtual) {
            this.virtual = virtual;
        }

        public String getIsvirtual() {
            return isvirtual;
        }

        public void setIsvirtual(String isvirtual) {
            this.isvirtual = isvirtual;
        }

        public String getIsvirtualsend() {
            return isvirtualsend;
        }

        public void setIsvirtualsend(String isvirtualsend) {
            this.isvirtualsend = isvirtualsend;
        }

        public Object getVirtualsend_info() {
            return virtualsend_info;
        }

        public void setVirtualsend_info(Object virtualsend_info) {
            this.virtualsend_info = virtualsend_info;
        }

        public Object getVirtual_str() {
            return virtual_str;
        }

        public void setVirtual_str(Object virtual_str) {
            this.virtual_str = virtual_str;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public static class AddressBean {
        /**
         * id : 87
         * uniacid : 1
         * openid : wap_user_1_13600000000
         * realname : ppp
         * mobile : 15019911212
         * province : 上海市
         * city : 杨浦区
         * area : 杨浦区
         * address : 999
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
}
