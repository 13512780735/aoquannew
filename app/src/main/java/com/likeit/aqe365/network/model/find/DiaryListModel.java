package com.likeit.aqe365.network.model.find;

import java.util.List;

public class DiaryListModel {


    /**
     * list : [{"id":"187","diaryid":"113","edittime":"1天前","title":"测试康复期日记","content":"开车出门嗨皮去了，很多人问我为什么拍照那么好看，我人好看呀，哈哈\r今天出门去玩下，感觉最近不怎么出门，一出门就是各种的激动。","views":"22","type":"0","openid":"oX6xmwqVTeONWdcMDQJOwNJmyNJk","surgery_image":"a:2:{i:0;s:51:\"images/1/2019/04/ktyzg49I9auy1U02iYYjyo4qJGtjU0.jpg\";i:1;s:51:\"images/1/2019/04/feB6YY1C3bfsn635B7c4f8161dmf5Z.jpg\";}","memberid":"2239","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","isuser":"1","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/KhiaBwrC2HY2zcstQToBb4A8wT4tTZ.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/SxQYgWwquMztM4gbMuy7oX9uBz3U1M.jpg"]},{"id":"189","diaryid":"114","edittime":"1天前","title":"测试图文日记","content":"开车出门嗨皮去了，很多人问我为什么拍照那么好看，我人好看呀，哈哈\r今天出门去玩下，感觉最近不怎么出门，一出门就是各种的激动。","views":"11","type":"1","openid":"oX6xmwqVTeONWdcMDQJOwNJmyNJk","surgery_image":"a:3:{i:0;s:51:\"images/1/2019/04/VmLVqgXH1avqKQ1GGAsQ1kNHG3SgLq.jpg\";i:1;s:51:\"images/1/2019/04/xGM9m0I1iJ60gMX69gEjmmXOy9jY9L.jpg\";i:2;s:51:\"images/1/2019/04/jUNN4usZnU242uVU42VM425UOOd4ON.jpg\";}","memberid":"2239","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","nickname":"永恒","isuser":"1","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/VmLVqgXH1avqKQ1GGAsQ1kNHG3SgLq.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/xGM9m0I1iJ60gMX69gEjmmXOy9jY9L.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/jUNN4usZnU242uVU42VM425UOOd4ON.jpg"]}]
     * total : 2
     * isuser : 0
     */

    private String total;
    private String isuser;
    private List<ListBean> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getIsuser() {
        return isuser;
    }

    public void setIsuser(String isuser) {
        this.isuser = isuser;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 187
         * diaryid : 113
         * edittime : 1天前
         * title : 测试康复期日记
         * content : 开车出门嗨皮去了，很多人问我为什么拍照那么好看，我人好看呀，哈哈今天出门去玩下，感觉最近不怎么出门，一出门就是各种的激动。
         * views : 22
         * type : 0
         * openid : oX6xmwqVTeONWdcMDQJOwNJmyNJk
         * surgery_image : a:2:{i:0;s:51:"images/1/2019/04/ktyzg49I9auy1U02iYYjyo4qJGtjU0.jpg";i:1;s:51:"images/1/2019/04/feB6YY1C3bfsn635B7c4f8161dmf5Z.jpg";}
         * memberid : 2239
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
         * nickname : 永恒
         * isuser : 1
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/KhiaBwrC2HY2zcstQToBb4A8wT4tTZ.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/SxQYgWwquMztM4gbMuy7oX9uBz3U1M.jpg"]
         */

        private String id;
        private String diaryid;
        private String edittime;
        private String title;
        private String content;
        private String views;
        private String type;
        private String openid;
        private String surgery_image;
        private String memberid;
        private String avatar;
        private String nickname;
        private String isuser;
        private List<String> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDiaryid() {
            return diaryid;
        }

        public void setDiaryid(String diaryid) {
            this.diaryid = diaryid;
        }

        public String getEdittime() {
            return edittime;
        }

        public void setEdittime(String edittime) {
            this.edittime = edittime;
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

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSurgery_image() {
            return surgery_image;
        }

        public void setSurgery_image(String surgery_image) {
            this.surgery_image = surgery_image;
        }

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
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

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
