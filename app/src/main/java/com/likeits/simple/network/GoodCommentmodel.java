package com.likeits.simple.network;

import java.util.List;

public class GoodCommentmodel {


    /**
     * count : {"all":"2","good":"1","normal":"1","bad":"0","pic":"2"}
     * list : [{"id":"9","uniacid":"1","orderid":"0","goodsid":"526","openid":"","nickname":"用**6","headimgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg","level":"5","content":"测试评价内容&图片","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ZKUDvkaM3mzRkzr8nv3BBveB2v8uAV.png","http://hidsy.maimaitoo.com/attachment/images/1/2019/01/Qad5bE1k1DsSLw4eBDLSlBKSCSL55d.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png"],"createtime":"2019-01-05 13:56","deleted":"0","append_content":"2019第二次追加评价","append_images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/GsDiR8PdBH3iGsBT31h8Bz1PbhIPB1.jpg","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"],"reply_content":"店铺回复内容","reply_images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/QNUKHU81kvWwjuNtBZHb14kJtl880Z.png"],"append_reply_content":"店铺第二次追加回复内容0001111","append_reply_images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"],"istop":"0","checked":"0","replychecked":"0"}]
     */

    private CountBean count;
    private List<ListBean> list;

    public CountBean getCount() {
        return count;
    }

    public void setCount(CountBean count) {
        this.count = count;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CountBean {
        /**
         * all : 2
         * good : 1
         * normal : 1
         * bad : 0
         * pic : 2
         */

        private String all;
        private String good;
        private String normal;
        private String bad;
        private String pic;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getNormal() {
            return normal;
        }

        public void setNormal(String normal) {
            this.normal = normal;
        }

        public String getBad() {
            return bad;
        }

        public void setBad(String bad) {
            this.bad = bad;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }

    public static class ListBean {
        /**
         * id : 9
         * uniacid : 1
         * orderid : 0
         * goodsid : 526
         * openid :
         * nickname : 用**6
         * headimgurl : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg
         * level : 5
         * content : 测试评价内容&图片
         * images : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ZKUDvkaM3mzRkzr8nv3BBveB2v8uAV.png","http://hidsy.maimaitoo.com/attachment/images/1/2019/01/Qad5bE1k1DsSLw4eBDLSlBKSCSL55d.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png"]
         * createtime : 2019-01-05 13:56
         * deleted : 0
         * append_content : 2019第二次追加评价
         * append_images : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/GsDiR8PdBH3iGsBT31h8Bz1PbhIPB1.jpg","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"]
         * reply_content : 店铺回复内容
         * reply_images : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/QNUKHU81kvWwjuNtBZHb14kJtl880Z.png"]
         * append_reply_content : 店铺第二次追加回复内容0001111
         * append_reply_images : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"]
         * istop : 0
         * checked : 0
         * replychecked : 0
         */

        private String id;
        private String uniacid;
        private String orderid;
        private String goodsid;
        private String openid;
        private String nickname;
        private String headimgurl;
        private String level;
        private String content;
        private String createtime;
        private String deleted;
        private String append_content;
        private String reply_content;
        private String append_reply_content;
        private String istop;
        private String checked;
        private String replychecked;
        private List<String> images;
        private List<String> append_images;
        private List<String> reply_images;
        private List<String> append_reply_images;

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

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(String goodsid) {
            this.goodsid = goodsid;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getAppend_content() {
            return append_content;
        }

        public void setAppend_content(String append_content) {
            this.append_content = append_content;
        }

        public String getReply_content() {
            return reply_content;
        }

        public void setReply_content(String reply_content) {
            this.reply_content = reply_content;
        }

        public String getAppend_reply_content() {
            return append_reply_content;
        }

        public void setAppend_reply_content(String append_reply_content) {
            this.append_reply_content = append_reply_content;
        }

        public String getIstop() {
            return istop;
        }

        public void setIstop(String istop) {
            this.istop = istop;
        }

        public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }

        public String getReplychecked() {
            return replychecked;
        }

        public void setReplychecked(String replychecked) {
            this.replychecked = replychecked;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getAppend_images() {
            return append_images;
        }

        public void setAppend_images(List<String> append_images) {
            this.append_images = append_images;
        }

        public List<String> getReply_images() {
            return reply_images;
        }

        public void setReply_images(List<String> reply_images) {
            this.reply_images = reply_images;
        }

        public List<String> getAppend_reply_images() {
            return append_reply_images;
        }

        public void setAppend_reply_images(List<String> append_reply_images) {
            this.append_reply_images = append_reply_images;
        }
    }
}
