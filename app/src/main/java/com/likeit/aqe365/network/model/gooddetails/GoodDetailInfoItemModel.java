package com.likeit.aqe365.network.model.gooddetails;

import com.likeit.aqe365.network.model.home.HomeMessage;

public class GoodDetailInfoItemModel extends HomeMessage {

    /**
     * params : {"hideshare":"0","share":"分享","share_icon":"e751"}
     * style : {"background":"#ff8d50","titlecolor":"#3fff4b","subtitlecolor":"#fcce2d","pricecolor":"#ff5555","textcolor":"#2855cc","timecolor":"#fff2e2","timetextcolor":"#ef4f4f"}
     * id : detail_info
     * data : {"title":"骑士MD96136/8美式全铜玻璃客厅灯餐厅灯卧室灯","subtitle":"这个是一个测试副标题","province":"广东省","city":"中山市","marketprice":"1554.00","isdiscount":"0","isdiscount_title":"双十二促销","minprice":"200.00","maxprice":"205.00","isverify":"1","isdiscount_time":"1545622560","sales":"11103","unit":"盏","type":"1","timestart":"1545148800","timeend":"1546248540","showsales":"1","dispatchprice":"12.00","presell":{"ispresell":"0","istime":"0","presellsendtime":"5","presellprice":"101.00","preselltimestart":"1544758560","preselltimeend":"1546077420","presellsendtype":"0","presellsendstatrttime":"1545731820"}}
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
         * hideshare : 0
         * share : 分享
         * share_icon : e751
         */

        private String hideshare;
        private String share;
        private String share_icon;

        public String getHideshare() {
            return hideshare;
        }

        public void setHideshare(String hideshare) {
            this.hideshare = hideshare;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getShare_icon() {
            return share_icon;
        }

        public void setShare_icon(String share_icon) {
            this.share_icon = share_icon;
        }
    }

    public static class StyleBean {
        /**
         * background : #ff8d50
         * titlecolor : #3fff4b
         * subtitlecolor : #fcce2d
         * pricecolor : #ff5555
         * textcolor : #2855cc
         * timecolor : #fff2e2
         * timetextcolor : #ef4f4f
         */

        private String background;
        private String titlecolor;
        private String subtitlecolor;
        private String pricecolor;
        private String textcolor;
        private String timecolor;
        private String timetextcolor;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getTitlecolor() {
            return titlecolor;
        }

        public void setTitlecolor(String titlecolor) {
            this.titlecolor = titlecolor;
        }

        public String getSubtitlecolor() {
            return subtitlecolor;
        }

        public void setSubtitlecolor(String subtitlecolor) {
            this.subtitlecolor = subtitlecolor;
        }

        public String getPricecolor() {
            return pricecolor;
        }

        public void setPricecolor(String pricecolor) {
            this.pricecolor = pricecolor;
        }

        public String getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(String textcolor) {
            this.textcolor = textcolor;
        }

        public String getTimecolor() {
            return timecolor;
        }

        public void setTimecolor(String timecolor) {
            this.timecolor = timecolor;
        }

        public String getTimetextcolor() {
            return timetextcolor;
        }

        public void setTimetextcolor(String timetextcolor) {
            this.timetextcolor = timetextcolor;
        }
    }

    public static class DataBean {
        /**
         * title : 骑士MD96136/8美式全铜玻璃客厅灯餐厅灯卧室灯
         * subtitle : 这个是一个测试副标题
         * province : 广东省
         * city : 中山市
         * marketprice : 1554.00
         * isdiscount : 0
         * isdiscount_title : 双十二促销
         * minprice : 200.00
         * maxprice : 205.00
         * isverify : 1
         * isdiscount_time : 1545622560
         * sales : 11103
         * unit : 盏
         * type : 1
         * timestart : 1545148800
         * timeend : 1546248540
         * showsales : 1
         * dispatchprice : 12.00
         * presell : {"ispresell":"0","istime":"0","presellsendtime":"5","presellprice":"101.00","preselltimestart":"1544758560","preselltimeend":"1546077420","presellsendtype":"0","presellsendstatrttime":"1545731820"}
         */

        private String title;
        private String subtitle;
        private String province;
        private String city;
        private String marketprice;
        private String isdiscount;
        private String isdiscount_title;
        private String minprice;
        private String maxprice;
        private String isverify;
        private String isdiscount_time;
        private String sales;
        private String unit;
        private String type;
        private String timestart;
        private String timeend;
        private String showsales;
        private String dispatchprice;
        private PresellBean presell;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
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

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }

        public String getIsdiscount() {
            return isdiscount;
        }

        public void setIsdiscount(String isdiscount) {
            this.isdiscount = isdiscount;
        }

        public String getIsdiscount_title() {
            return isdiscount_title;
        }

        public void setIsdiscount_title(String isdiscount_title) {
            this.isdiscount_title = isdiscount_title;
        }

        public String getMinprice() {
            return minprice;
        }

        public void setMinprice(String minprice) {
            this.minprice = minprice;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public String getIsverify() {
            return isverify;
        }

        public void setIsverify(String isverify) {
            this.isverify = isverify;
        }

        public String getIsdiscount_time() {
            return isdiscount_time;
        }

        public void setIsdiscount_time(String isdiscount_time) {
            this.isdiscount_time = isdiscount_time;
        }

        public String getSales() {
            return sales;
        }

        public void setSales(String sales) {
            this.sales = sales;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTimestart() {
            return timestart;
        }

        public void setTimestart(String timestart) {
            this.timestart = timestart;
        }

        public String getTimeend() {
            return timeend;
        }

        public void setTimeend(String timeend) {
            this.timeend = timeend;
        }

        public String getShowsales() {
            return showsales;
        }

        public void setShowsales(String showsales) {
            this.showsales = showsales;
        }

        public String getDispatchprice() {
            return dispatchprice;
        }

        public void setDispatchprice(String dispatchprice) {
            this.dispatchprice = dispatchprice;
        }

        public PresellBean getPresell() {
            return presell;
        }

        public void setPresell(PresellBean presell) {
            this.presell = presell;
        }

        public static class PresellBean {
            /**
             * ispresell : 0
             * istime : 0
             * presellsendtime : 5
             * presellprice : 101.00
             * preselltimestart : 1544758560
             * preselltimeend : 1546077420
             * presellsendtype : 0
             * presellsendstatrttime : 1545731820
             */

            private String ispresell;
            private String istime;
            private String presellsendtime;
            private String presellprice;
            private String preselltimestart;
            private String preselltimeend;
            private String presellsendtype;
            private String presellsendstatrttime;

            public String getIspresell() {
                return ispresell;
            }

            public void setIspresell(String ispresell) {
                this.ispresell = ispresell;
            }

            public String getIstime() {
                return istime;
            }

            public void setIstime(String istime) {
                this.istime = istime;
            }

            public String getPresellsendtime() {
                return presellsendtime;
            }

            public void setPresellsendtime(String presellsendtime) {
                this.presellsendtime = presellsendtime;
            }

            public String getPresellprice() {
                return presellprice;
            }

            public void setPresellprice(String presellprice) {
                this.presellprice = presellprice;
            }

            public String getPreselltimestart() {
                return preselltimestart;
            }

            public void setPreselltimestart(String preselltimestart) {
                this.preselltimestart = preselltimestart;
            }

            public String getPreselltimeend() {
                return preselltimeend;
            }

            public void setPreselltimeend(String preselltimeend) {
                this.preselltimeend = preselltimeend;
            }

            public String getPresellsendtype() {
                return presellsendtype;
            }

            public void setPresellsendtype(String presellsendtype) {
                this.presellsendtype = presellsendtype;
            }

            public String getPresellsendstatrttime() {
                return presellsendstatrttime;
            }

            public void setPresellsendstatrttime(String presellsendstatrttime) {
                this.presellsendstatrttime = presellsendstatrttime;
            }
        }
    }
}
