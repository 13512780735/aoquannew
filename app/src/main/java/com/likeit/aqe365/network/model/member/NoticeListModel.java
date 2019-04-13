package com.likeit.aqe365.network.model.member;

import java.util.List;

public class NoticeListModel {

    /**
     * list : [{"id":"8","title":"春节放假发货通知","thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/JXR4EmRj0Uew5VU545El0x5v0E04z4.jpg","createtime":"2019年01月26日","content":"<p>@所有人<br/><\/p><p>您好！春节将至，由于第三方快递即将陆续停运，为了避免您的快递丢失，公司售后部门即日起停止收发所有售后件（含退换货，售后维修件），商城停发货时间为1月25日。暂定恢复时间为：2月14号，请知悉！<\/p><p>澳泉医销网祝您春节快乐！<\/p><p><br/><\/p>"}]
     * total : 1
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
         * id : 8
         * title : 春节放假发货通知
         * thumb : http://aoquan.maimaitoo.com/attachment/images/1/2019/01/JXR4EmRj0Uew5VU545El0x5v0E04z4.jpg
         * createtime : 2019年01月26日
         * content : <p>@所有人<br/></p><p>您好！春节将至，由于第三方快递即将陆续停运，为了避免您的快递丢失，公司售后部门即日起停止收发所有售后件（含退换货，售后维修件），商城停发货时间为1月25日。暂定恢复时间为：2月14号，请知悉！</p><p>澳泉医销网祝您春节快乐！</p><p><br/></p>
         */

        private String id;
        private String title;
        private String thumb;
        private String createtime;
        private String content;

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

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
