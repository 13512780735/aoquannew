package com.likeit.aqe365.network.model.member;

import java.util.ArrayList;
import java.util.List;

public class PostUserModel {

    /**
     * list : [{"id":"230","title":"测试123456","createtime":"2天前","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"测试视频111111111111411111444445","views":"25"},{"id":"229","title":"测试123456","createtime":"2天前","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"测试视频111111111111411111444445","views":"14"},{"id":"228","title":"牙齿矫正","createtime":"2天前","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/kxA6DIqQP0d60fs8G2LADifMZlq6PS.jpg"],"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"第一次带托槽矫正，内心还是比较激动的。带上去没有想象中的疼痛或者特别紧绷的感觉，由于个人原因没有选择\u201c铁齿钢牙\u201d款的。毕竟不是学生时代了，带出去不好看，一不小心得了钢牙哥的绰号怎么办，所以选择了隐形款的，带上去不仔细观察的话不太看得出来，第一天暂时还啥变化，后面我会陆续进行记录供你们参考。","views":"27"},{"id":"225","title":"哈哈哈哈哈哈","createtime":"2019-04-10","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵","views":"10"},{"id":"224","title":"哈哈哈哈哈哈","createtime":"2019-04-10","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵","views":"2"},{"id":"214","title":"大叔大婶多","createtime":"2019-04-08","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"阿法士大夫","views":"49"},{"id":"213","title":"发送到发大叔大婶多","createtime":"2019-04-08","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"差实打实大所多","views":"51"},{"id":"212","title":"测试2","createtime":"2019-04-08","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"测试2","views":"10"},{"id":"211","title":"asdasdasd","createtime":"2019-04-08","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"fasdfsadfasdfdfsadf","views":"5"},{"id":"210","title":"测试111","createtime":"2019-04-08","images":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","content":"测试111","views":"4"}]
     * total : 34
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
         * id : 230
         * title : 测试123456
         * createtime : 2天前
         * images : null
         * nickname : 136xxxx0576
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * content : 测试视频111111111111411111444445
         * views : 25
         */

        private String id;
        private String title;
        private String createtime;
        public List<String> images = new ArrayList<>();
        private String nickname;
        private String avatar;
        private String type;
        private String content;
        private String views;
        private String huati;
        public boolean isShowAll = false;

        public String getHuati() {
            return huati;
        }

        public void setHuati(String huati) {
            this.huati = huati;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

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

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }


        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }
    }
}
