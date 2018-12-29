package com.likeits.simple.network.model.home;

import java.util.List;

public class MainHomeSeckillgroupModel extends HomeMessage{


    /**
     * params : {"iconurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/diypage/static/images/default/seckill.png","hideborder":"0","tag":""}
     * style : {"margintop":20,"titlecolor":"#ff3300","marketpricecolor":"#ff40ff","productpricecolor":"#ff9200"}
     * id : seckillgroup
     * data : {"tag":"秒杀","status":0,"nowtime":1544776623,"time":"16","endtime":1544803199,"starttime":1544774400,"goods":[{"thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/N0DAI9OOz1AbV1bDgrB2RV2ZriGR2C.jpg","price":"1000","marketprice":"3200"}]}
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * iconurl : http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/diypage/static/images/default/seckill.png
         * hideborder : 0
         * tag :
         */

        private String iconurl;
        private String hideborder;
        private String tag;

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public String getHideborder() {
            return hideborder;
        }

        public void setHideborder(String hideborder) {
            this.hideborder = hideborder;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
    }

    public static class StyleBean {
        /**
         * margintop : 20
         * titlecolor : #ff3300
         * marketpricecolor : #ff40ff
         * productpricecolor : #ff9200
         */

        private int margintop;
        private String titlecolor;
        private String marketpricecolor;
        private String productpricecolor;

        public int getMargintop() {
            return margintop;
        }

        public void setMargintop(int margintop) {
            this.margintop = margintop;
        }

        public String getTitlecolor() {
            return titlecolor;
        }

        public void setTitlecolor(String titlecolor) {
            this.titlecolor = titlecolor;
        }

        public String getMarketpricecolor() {
            return marketpricecolor;
        }

        public void setMarketpricecolor(String marketpricecolor) {
            this.marketpricecolor = marketpricecolor;
        }

        public String getProductpricecolor() {
            return productpricecolor;
        }

        public void setProductpricecolor(String productpricecolor) {
            this.productpricecolor = productpricecolor;
        }
    }

    public static class DataBean {
        /**
         * tag : 秒杀
         * status : 0
         * nowtime : 1544776623
         * time : 16
         * endtime : 1544803199
         * starttime : 1544774400
         * goods : [{"thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/N0DAI9OOz1AbV1bDgrB2RV2ZriGR2C.jpg","price":"1000","marketprice":"3200"}]
         */

        private String tag;
        private int status;
        private int nowtime;
        private String time;
        private int endtime;
        private int starttime;
        private List<GoodsBean> goods;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getNowtime() {
            return nowtime;
        }

        public void setNowtime(int nowtime) {
            this.nowtime = nowtime;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getEndtime() {
            return endtime;
        }

        public void setEndtime(int endtime) {
            this.endtime = endtime;
        }

        public int getStarttime() {
            return starttime;
        }

        public void setStarttime(int starttime) {
            this.starttime = starttime;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/08/N0DAI9OOz1AbV1bDgrB2RV2ZriGR2C.jpg
             * price : 1000
             * marketprice : 3200
             */

            private String thumb;
            private String price;
            private String marketprice;

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getMarketprice() {
                return marketprice;
            }

            public void setMarketprice(String marketprice) {
                this.marketprice = marketprice;
            }
        }
    }
}
