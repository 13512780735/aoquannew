package com.likeits.simple.network.model.Indent;

import java.util.List;

public class ExpressModel {

    /**
     * com : 中通速递
     * sn : 73107464543398
     * status : 配送中
     * count : 1
     * thumb : http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg
     * expresslist : [{"time":"2018-12-15 22:05:46","step":"【中山市】 快件已在 【中山北区】 签收, 签收人: 拍照签收, 如有疑问请电联:13790738589 / 0760-88709095, 您的快递已经妥投, 如果您对我们的服务感到满意, 请给个五星好评, 鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】"},{"time":"2018-12-15 10:20:14","step":"【中山市】 快件已到达 【中山北区】（0760-88709095）,业务员 张文锋（13790738589） 正在第1次派件, 请保持电话畅通,并耐心等待"},{"time":"2018-12-14 17:23:16","step":"【中山市】 快件离开 【中山中心】 已发往 【中山北区】"},{"time":"2018-12-14 14:11:10","step":"【中山市】 快件已经到达 【中山中心】"},{"time":"2018-12-13 13:40:55","step":"【武汉市】 快件离开 【武汉中转部】 已发往 【中山中心】"},{"time":"2018-12-13 13:09:16","step":"【武汉市】 快件离开 【湖北市场部】 已发往 【武汉中转部】"},{"time":"2018-12-13 11:29:09","step":"【武汉市】 【湖北市场部】（027-83293528） 的 美邦 （18001151789） 已揽收"}]
     * bundlelist : null
     */

    private String com;
    private String sn;
    private String status;
    private int count;
    private String thumb;
    private Object bundlelist;
    private List<ExpresslistBean> expresslist;

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Object getBundlelist() {
        return bundlelist;
    }

    public void setBundlelist(Object bundlelist) {
        this.bundlelist = bundlelist;
    }

    public List<ExpresslistBean> getExpresslist() {
        return expresslist;
    }

    public void setExpresslist(List<ExpresslistBean> expresslist) {
        this.expresslist = expresslist;
    }

    public static class ExpresslistBean {
        /**
         * time : 2018-12-15 22:05:46
         * step : 【中山市】 快件已在 【中山北区】 签收, 签收人: 拍照签收, 如有疑问请电联:13790738589 / 0760-88709095, 您的快递已经妥投, 如果您对我们的服务感到满意, 请给个五星好评, 鼓励一下我们【请在评价快递员处帮忙点亮五颗星星哦~】
         */

        private String time;
        private String step;
        private String defined;
        public ExpresslistBean(String defined, String time, String step) {
            this.defined = defined;
            this.time = time;
            this.step = step;
        }
        public String getDefined() {
            return defined;
        }

        public void setDefined(String defined) {
            this.defined = defined;
        }

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
    }
}
