package com.likeits.simple.network.model.member;

import java.util.List;

public class CouponCenterModel {

    /**
     * list : [{"id":"16","couponname":"打折","tagtitle":"打折券","deduct":"0.00","gettypestr":"领取","lastratio":100,"title2":"无金额门槛","iconurl":"","usestr":"即领取日内 15 天有效","title3":"8折","color":"#FF0000","category":"","title4":"购物任意金额"},{"id":"15","couponname":"返利优惠券","tagtitle":"购物返现券","deduct":"0.00","gettypestr":"领取","lastratio":100,"title2":"满100元可用","iconurl":"","usestr":"即领取日内 15 天有效","title3":"返利","color":"#FF0000","category":"","title4":"满100元"},{"id":"14","couponname":"满200元减20元","tagtitle":"满减券","deduct":"20.00","gettypestr":"领取","lastratio":100,"title2":"满200元可用","iconurl":"","usestr":"永久有效","title3":"￥20","color":"#0041FF","title4":"满200元","category":""},{"id":"13","couponname":"满100元减10元","tagtitle":"满减券","deduct":"10.00","gettypestr":"领取","lastratio":100,"title2":"满100元可用","iconurl":"","usestr":"永久有效","title3":"￥10","color":"#0041FF","title4":"满100元","category":""},{"id":"12","couponname":"600","tagtitle":"代金券","deduct":"100.00","gettypestr":"领取","lastratio":100,"title2":"无金额门槛","iconurl":"","usestr":"即领取日内 365 天有效","title3":"￥100","color":"#FFA500","title4":"购物任意金额","category":""},{"id":"11","couponname":"测试收银台优惠券","tagtitle":"满减券","deduct":"100.00","gettypestr":"领取","lastratio":100,"title2":"满500元可用","iconurl":"","usestr":"即领取日内 369 天有效","title3":"￥100","color":"#0041FF","title4":"减100元","category":""},{"id":"9","couponname":"测试充值优惠券","tagtitle":"充值返现券","deduct":"0.00","gettypestr":"领取","lastratio":95,"title2":"充值满100元可用","iconurl":"","usestr":"永久有效","title3":"返利","color":"#FF7D7D","category":""},{"id":"8","couponname":"满200元返利20元","tagtitle":"购物返现券","deduct":"0.00","gettypestr":"领取","lastratio":99,"title2":"满200元可用","iconurl":"","usestr":"即领取日内 2 天有效","title3":"返利","color":"#FF0000","category":"","title4":"满200元"},{"id":"7","couponname":"满300元9折","tagtitle":"打折券","deduct":"0.00","gettypestr":"领取","lastratio":90,"title2":"满100元可用","iconurl":"","usestr":"即领取日内 365 天有效","title3":"9折","color":"#FF0000","category":"","title4":"满100元"},{"id":"6","couponname":"满100元减10元","tagtitle":"满减券","deduct":"10.00","gettypestr":"领取","lastratio":100,"title2":"满100元可用","iconurl":"","usestr":"即领取日内 365 天有效","title3":"￥10","color":"#0041FF","title4":"满100元","category":""}]
     * total : 6
     * categpry : [{"id":"7","name":"双十二优惠券"},{"id":"6","name":"新人发券"}]
     */

    private String total;
    private List<ListBean> list;
    private List<CategpryBean> categpry;

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

    public List<CategpryBean> getCategpry() {
        return categpry;
    }

    public void setCategpry(List<CategpryBean> categpry) {
        this.categpry = categpry;
    }

    public static class ListBean {
        /**
         * id : 16
         * couponname : 打折
         * tagtitle : 打折券
         * deduct : 0.00
         * gettypestr : 领取
         * lastratio : 100
         * title2 : 无金额门槛
         * iconurl :
         * usestr : 即领取日内 15 天有效
         * title3 : 8折
         * color : #FF0000
         * category :
         * title4 : 购物任意金额
         */

        private String id;
        private String couponname;
        private String tagtitle;
        private String deduct;
        private String gettypestr;
        private int lastratio;
        private String title2;
        private String iconurl;
        private String usestr;
        private String title3;
        private String color;
        private String category;
        private String title4;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getDeduct() {
            return deduct;
        }

        public void setDeduct(String deduct) {
            this.deduct = deduct;
        }

        public String getGettypestr() {
            return gettypestr;
        }

        public void setGettypestr(String gettypestr) {
            this.gettypestr = gettypestr;
        }

        public int getLastratio() {
            return lastratio;
        }

        public void setLastratio(int lastratio) {
            this.lastratio = lastratio;
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

        public String getUsestr() {
            return usestr;
        }

        public void setUsestr(String usestr) {
            this.usestr = usestr;
        }

        public String getTitle3() {
            return title3;
        }

        public void setTitle3(String title3) {
            this.title3 = title3;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
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

    public static class CategpryBean {
        /**
         * id : 7
         * name : 双十二优惠券
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
