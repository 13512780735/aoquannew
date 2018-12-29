package com.likeits.simple.network.model.home;

import java.util.List;

public class MainHomeCouponModel extends HomeMessage{

    /**
     * params : {"couponstyle":"3"}
     * style : {"background":"#2bfeff","margintop":14,"marginleft":20}
     * data : [{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}},{"imgurl":"","couponid":"","name":"优惠券","params":{"id":""}}]
     * id : coupon
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private List<DataBean> data;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * couponstyle : 3
         */

        private String couponstyle;

        public String getCouponstyle() {
            return couponstyle;
        }

        public void setCouponstyle(String couponstyle) {
            this.couponstyle = couponstyle;
        }
    }

    public static class StyleBean {
        /**
         * background : #2bfeff
         * margintop : 14
         * marginleft : 20
         */

        private String background;
        private int margintop;
        private int marginleft;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public int getMargintop() {
            return margintop;
        }

        public void setMargintop(int margintop) {
            this.margintop = margintop;
        }

        public int getMarginleft() {
            return marginleft;
        }

        public void setMarginleft(int marginleft) {
            this.marginleft = marginleft;
        }
    }

    public static class DataBean {
        /**
         * imgurl :
         * couponid :
         * name : 优惠券
         * params : {"id":""}
         */

        private String imgurl;
        private String couponid;
        private String name;
        private ParamsBeanX params;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getCouponid() {
            return couponid;
        }

        public void setCouponid(String couponid) {
            this.couponid = couponid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ParamsBeanX getParams() {
            return params;
        }

        public void setParams(ParamsBeanX params) {
            this.params = params;
        }

        public static class ParamsBeanX {
            /**
             * id :
             */

            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
