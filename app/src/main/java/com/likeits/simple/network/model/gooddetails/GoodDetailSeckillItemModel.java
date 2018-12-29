package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailSeckillItemModel extends HomeMessage {

    /**
     * style : {"theme":"#ff80ff","bgcolor":"#ef4f4f50","percent":"#ef4f4f90"}
     * id : detail_seckill
     * data : {"taskid":"1","roomid":"2","timeid":"15","total":"1000","count":0,"selfcount":0,"selftotalcount":0,"notpay":0,"selfnotpay":0,"selftotalnotpay":0,"maxbuy":"1","totalmaxbuy":"1","tag":"秒杀","time":"23","options":[{"id":"46","uniacid":"1","displayorder":"1","taskid":"1","roomid":"2","timeid":"15","goodsid":"716","optionid":"0","price":"1000.00","total":"1000","maxbuy":"1","totalmaxbuy":"1","commission1":"1.00","commission2":"0.00","commission3":"0.00","start_time":1545231600,"end_time":1545235199}],"starttime":1545231600,"endtime":1545235199,"price":"1000","percent":0,"status":1,"nowtime":1545203446}
     */

    private StyleBean style;
    private String id;
    private DataBean data;

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

    public static class StyleBean {
        /**
         * theme : #ff80ff
         * bgcolor : #ef4f4f50
         * percent : #ef4f4f90
         */

        private String theme;
        private String bgcolor;
        private String percent;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getBgcolor() {
            return bgcolor;
        }

        public void setBgcolor(String bgcolor) {
            this.bgcolor = bgcolor;
        }

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }
    }

    public static class DataBean {
        /**
         * taskid : 1
         * roomid : 2
         * timeid : 15
         * total : 1000
         * count : 0
         * selfcount : 0
         * selftotalcount : 0
         * notpay : 0
         * selfnotpay : 0
         * selftotalnotpay : 0
         * maxbuy : 1
         * totalmaxbuy : 1
         * tag : 秒杀
         * time : 23
         * options : [{"id":"46","uniacid":"1","displayorder":"1","taskid":"1","roomid":"2","timeid":"15","goodsid":"716","optionid":"0","price":"1000.00","total":"1000","maxbuy":"1","totalmaxbuy":"1","commission1":"1.00","commission2":"0.00","commission3":"0.00","start_time":1545231600,"end_time":1545235199}]
         * starttime : 1545231600
         * endtime : 1545235199
         * price : 1000
         * percent : 0
         * status : 1
         * nowtime : 1545203446
         */

        private String taskid;
        private String roomid;
        private String timeid;
        private String total;
        private int count;
        private int selfcount;
        private int selftotalcount;
        private int notpay;
        private int selfnotpay;
        private int selftotalnotpay;
        private String maxbuy;
        private String totalmaxbuy;
        private String tag;
        private String time;
        private int starttime;
        private int endtime;
        private String price;
        private int percent;
        private int status;
        private int nowtime;
        private List<OptionsBean> options;

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getRoomid() {
            return roomid;
        }

        public void setRoomid(String roomid) {
            this.roomid = roomid;
        }

        public String getTimeid() {
            return timeid;
        }

        public void setTimeid(String timeid) {
            this.timeid = timeid;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getSelfcount() {
            return selfcount;
        }

        public void setSelfcount(int selfcount) {
            this.selfcount = selfcount;
        }

        public int getSelftotalcount() {
            return selftotalcount;
        }

        public void setSelftotalcount(int selftotalcount) {
            this.selftotalcount = selftotalcount;
        }

        public int getNotpay() {
            return notpay;
        }

        public void setNotpay(int notpay) {
            this.notpay = notpay;
        }

        public int getSelfnotpay() {
            return selfnotpay;
        }

        public void setSelfnotpay(int selfnotpay) {
            this.selfnotpay = selfnotpay;
        }

        public int getSelftotalnotpay() {
            return selftotalnotpay;
        }

        public void setSelftotalnotpay(int selftotalnotpay) {
            this.selftotalnotpay = selftotalnotpay;
        }

        public String getMaxbuy() {
            return maxbuy;
        }

        public void setMaxbuy(String maxbuy) {
            this.maxbuy = maxbuy;
        }

        public String getTotalmaxbuy() {
            return totalmaxbuy;
        }

        public void setTotalmaxbuy(String totalmaxbuy) {
            this.totalmaxbuy = totalmaxbuy;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getStarttime() {
            return starttime;
        }

        public void setStarttime(int starttime) {
            this.starttime = starttime;
        }

        public int getEndtime() {
            return endtime;
        }

        public void setEndtime(int endtime) {
            this.endtime = endtime;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getPercent() {
            return percent;
        }

        public void setPercent(int percent) {
            this.percent = percent;
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

        public List<OptionsBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionsBean> options) {
            this.options = options;
        }

        public static class OptionsBean {
            /**
             * id : 46
             * uniacid : 1
             * displayorder : 1
             * taskid : 1
             * roomid : 2
             * timeid : 15
             * goodsid : 716
             * optionid : 0
             * price : 1000.00
             * total : 1000
             * maxbuy : 1
             * totalmaxbuy : 1
             * commission1 : 1.00
             * commission2 : 0.00
             * commission3 : 0.00
             * start_time : 1545231600
             * end_time : 1545235199
             */

            private String id;
            private String uniacid;
            private String displayorder;
            private String taskid;
            private String roomid;
            private String timeid;
            private String goodsid;
            private String optionid;
            private String price;
            private String total;
            private String maxbuy;
            private String totalmaxbuy;
            private String commission1;
            private String commission2;
            private String commission3;
            private int start_time;
            private int end_time;

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

            public String getDisplayorder() {
                return displayorder;
            }

            public void setDisplayorder(String displayorder) {
                this.displayorder = displayorder;
            }

            public String getTaskid() {
                return taskid;
            }

            public void setTaskid(String taskid) {
                this.taskid = taskid;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getTimeid() {
                return timeid;
            }

            public void setTimeid(String timeid) {
                this.timeid = timeid;
            }

            public String getGoodsid() {
                return goodsid;
            }

            public void setGoodsid(String goodsid) {
                this.goodsid = goodsid;
            }

            public String getOptionid() {
                return optionid;
            }

            public void setOptionid(String optionid) {
                this.optionid = optionid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getMaxbuy() {
                return maxbuy;
            }

            public void setMaxbuy(String maxbuy) {
                this.maxbuy = maxbuy;
            }

            public String getTotalmaxbuy() {
                return totalmaxbuy;
            }

            public void setTotalmaxbuy(String totalmaxbuy) {
                this.totalmaxbuy = totalmaxbuy;
            }

            public String getCommission1() {
                return commission1;
            }

            public void setCommission1(String commission1) {
                this.commission1 = commission1;
            }

            public String getCommission2() {
                return commission2;
            }

            public void setCommission2(String commission2) {
                this.commission2 = commission2;
            }

            public String getCommission3() {
                return commission3;
            }

            public void setCommission3(String commission3) {
                this.commission3 = commission3;
            }

            public int getStart_time() {
                return start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }
        }
    }
}
