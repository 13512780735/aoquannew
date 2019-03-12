package com.likeit.aqe365.network.model.member;

import java.util.List;

public class CouponListModel {

    /**
     * list : [{"id":"39","couponid":"15","used":"0","gettime":"1546852001","timedays":"15","thumb":"","couponname":"返利优惠券","tagtitle":"购物返现券","catid":"0","timestr":"2019-01-22","color":"#ff0000 ","imgname":"ling","check":"0","title2":"消费满100元送20积分","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-01-22","title3":"返利","category":"","title4":"满100元"},{"id":"38","couponid":"16","used":"0","gettime":"1546851904","timedays":"15","thumb":"","couponname":"打折","tagtitle":"打折券","catid":"0","timestr":"2019-01-22","color":"#ff0000 ","imgname":"ling","check":"0","title2":"消费打8折","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-01-22","title3":"8折","category":"","title4":"购物任意金额"},{"id":"34","couponid":"11","used":"0","gettime":"1545119472","timedays":"369","thumb":"","couponname":"测试收银台优惠券","tagtitle":"满减券","catid":"0","timestr":"2019-12-22","color":"#0041ff","imgname":"ling","check":"0","title2":"消费满500元立减100元","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-12-22","title3":"￥100","title4":"减100元","category":""},{"id":"33","couponid":"12","used":"0","gettime":"1545114798","timedays":"365","thumb":"","couponname":"600","tagtitle":"代金券","catid":"0","timestr":"2019-12-18","color":"#ffa500","imgname":"ling","check":"0","title2":"消费立减100元","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-12-18","title3":"￥100","title4":"购物任意金额","category":""},{"id":"30","couponid":"7","used":"0","gettime":"1545111783","timedays":"365","thumb":"","couponname":"满300元9折","tagtitle":"打折券","catid":"0","timestr":"2019-12-18","color":"#ff0000 ","imgname":"ling","check":"0","title2":"消费满100元打9折","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-12-18","title3":"9折","category":"","title4":"满100元"},{"id":"28","couponid":"6","used":"0","gettime":"1545111752","timedays":"365","thumb":"","couponname":"满100元减10元","tagtitle":"满减券","catid":"0","timestr":"2019-12-18","color":"#0041ff","imgname":"ling","check":"0","title2":"消费满100元立减10元","iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png","finite_time":"有效期 2019-12-18","title3":"￥10","title4":"满100元","category":""}]
     * total : 6
     */

    private String total;
    private List<ListBean> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 39
         * couponid : 15
         * used : 0
         * gettime : 1546852001
         * timedays : 15
         * thumb :
         * couponname : 返利优惠券
         * tagtitle : 购物返现券
         * catid : 0
         * timestr : 2019-01-22
         * color : #ff0000
         * imgname : ling
         * check : 0
         * title2 : 消费满100元送20积分
         * iconurl : http://hidsy.maimaitoo.com/addons/ewei_shopv2/template/mobile/default/static/images/coupon/ling.png
         * finite_time : 有效期 2019-01-22
         * title3 : 返利
         * category :
         * title4 : 满100元
         */

        private String id;
        private String couponid;
        private String used;
        private String gettime;
        private String timedays;
        private String thumb;
        private String couponname;
        private String tagtitle;
        private String catid;
        private String timestr;
        private String color;
        private String imgname;
        private String check;
        private String title2;
        private String iconurl;
        private String finite_time;
        private String title3;
        private String category;
        private String title4;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCouponid() {
            return couponid;
        }

        public void setCouponid(String couponid) {
            this.couponid = couponid;
        }

        public String getUsed() {
            return used;
        }

        public void setUsed(String used) {
            this.used = used;
        }

        public String getGettime() {
            return gettime;
        }

        public void setGettime(String gettime) {
            this.gettime = gettime;
        }

        public String getTimedays() {
            return timedays;
        }

        public void setTimedays(String timedays) {
            this.timedays = timedays;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getCouponname() {
            return couponname;
        }

        public void setCouponname(String couponname) {
            this.couponname = couponname;
        }

        public String getTagtitle() {
            return tagtitle;
        }

        public void setTagtitle(String tagtitle) {
            this.tagtitle = tagtitle;
        }

        public String getCatid() {
            return catid;
        }

        public void setCatid(String catid) {
            this.catid = catid;
        }

        public String getTimestr() {
            return timestr;
        }

        public void setTimestr(String timestr) {
            this.timestr = timestr;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImgname() {
            return imgname;
        }

        public void setImgname(String imgname) {
            this.imgname = imgname;
        }

        public String getCheck() {
            return check;
        }

        public void setCheck(String check) {
            this.check = check;
        }

        public String getTitle2() {
            return title2;
        }

        public void setTitle2(String title2) {
            this.title2 = title2;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getFinite_time() {
            return finite_time;
        }

        public void setFinite_time(String finite_time) {
            this.finite_time = finite_time;
        }

        public String getTitle3() {
            return title3;
        }

        public void setTitle3(String title3) {
            this.title3 = title3;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTitle4() {
            return title4;
        }

        public void setTitle4(String title4) {
            this.title4 = title4;
        }
    }
}
