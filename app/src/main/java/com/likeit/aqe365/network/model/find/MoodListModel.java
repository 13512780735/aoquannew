package com.likeit.aqe365.network.model.find;

import java.util.ArrayList;
import java.util.List;

public class MoodListModel {


    /**
     * list : [{"id":"103","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"恶露俯卧阿莫","images":null,"createtime":"16小时前","views":"0","videoimage":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/AM3ydK4DkrYHfRKuJjRypuccKkcbc7.jpg","huati":"#牙科知识讲堂 "},{"id":"102","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"111啊路婆媳","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/iuQluq0Q03lJ9fr8fk7l8LJQJKUFlQ.jpg"],"createtime":"16小时前","views":"0","videoimage":"","huati":"#牙科知识讲堂 "},{"id":"101","bid":"0","bids":"5,4","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","nickname":"136xxxx0576","title":"","content":"","images":null,"createtime":"16小时前","views":"0","videoimage":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/HlgHNcOtvbSBkEIsPc3CwgvQINFAVxWc.jpg","huati":"#测试3 #测试4 "},{"id":"100","bid":"0","bids":"5,4","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","nickname":"136xxxx0576","title":"","content":"","images":null,"createtime":"16小时前","views":"0","videoimage":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/zQR4F0QLjMJR8ux2BoPicIPc7zKMWFgS.jpg","huati":"#测试3 #测试4 "},{"id":"99","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"11111","images":null,"createtime":"16小时前","views":"0","videoimage":"","huati":"#牙科知识讲堂 "},{"id":"98","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"11111","images":null,"createtime":"16小时前","views":"0","videoimage":"","huati":"#牙科知识讲堂 "},{"id":"97","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"路路通通讯","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/g0f75H80wUYy775FF7BttV7I0lF7b5.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/eR1E2LwIsLqv7SnZv42rc442Ewnc4q.jpg"],"createtime":"17小时前","views":"0","videoimage":"","huati":"#牙科知识讲堂 "},{"id":"96","bid":"0","bids":"1","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"1111","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/XTibVf0nnSzgJ0s7TJIB7zUGR66Dub.jpg"],"createtime":"17小时前","views":"0","videoimage":"","huati":"#牙科知识讲堂 "},{"id":"93","bid":"0","bids":"1,2,3,4","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","title":"","content":"dasdlaksjdakjdlasdjlasdj","images":null,"createtime":"1天前","views":"14","videoimage":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/sDXzWzxwttb7U7w7unB91WadWXnXs7.jpg","huati":"#牙科知识讲堂 #测试1 #测试2 #测试3 "},{"id":"92","bid":"0","bids":"2,1","avatar":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qe1iBYrpW6vJmmGE5bPyAkPmADzAdaOF.jpg","nickname":"健","title":"","content":"ufjfjf 家","images":null,"createtime":"1天前","views":"11","videoimage":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/sDXzWzxwttb7U7w7unB91WadWXnXs7.jpg","huati":"#牙科知识讲堂 #测试1 "}]
     * total : 33
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
         * id : 103
         * bid : 0
         * bids : 1
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
         * nickname : 永恒
         * title :
         * content : 恶露俯卧阿莫
         * images : null
         * createtime : 16小时前
         * views : 0
         * videoimage : http://aoquan.maimaitoo.com/attachment/images/1/2019/04/AM3ydK4DkrYHfRKuJjRypuccKkcbc7.jpg
         * huati : #牙科知识讲堂
         */

        private String id;
        private String bid;
        private String bids;
        private String avatar;
        private String nickname;
        private String title;
        private String content;
        private String createtime;
        private String views;
        private String videoimage;
        private String huati;
        private String type;
        public List<String> images = new ArrayList<>();

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isShowAll = false;

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getBids() {
            return bids;
        }

        public void setBids(String bids) {
            this.bids = bids;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getVideoimage() {
            return videoimage;
        }

        public void setVideoimage(String videoimage) {
            this.videoimage = videoimage;
        }

        public String getHuati() {
            return huati;
        }

        public void setHuati(String huati) {
            this.huati = huati;
        }
    }
}
