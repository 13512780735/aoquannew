package com.likeit.aqe365.network.model.find;

import java.util.List;

public class PostListModel {

    /**
     * 推荐列表
     */

    /**
     * list : [{"id":"6","title":"什么是奶瓶龋？又如何预防呢","createtime":"1551666039","nickname":"AQ_邹定谔","avatar":"http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccOw23ER57f0cDuT8iaHjjRT2Q1cLI1aVaTZUN4aqqDPMNNVMPVc3KAc9Mb1ialiaCh7yhsFVYyQV4ZjeTgKZBPy4Y1/132","coordinate":"5,637.5km","thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2018/09/xurGAlvgPuSDPfSaJRdjUZ9L9U6vA0.jpg"},{"id":"13","title":"1111111","createtime":"1551859339","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","coordinate":"","thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/WGS96sFWZS2IRWCGsSQqFg9Ww2W0IP.gif"},{"id":"11","title":"","createtime":"1551844150","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","coordinate":"","thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/L22498Zi13698118g41409xC38n00B.jpg"},{"id":"10","title":"牙科吸管","createtime":"1551841854","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","coordinate":"","thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/L22498Zi13698118g41409xC38n00B.jpg"}]
     * total : 4
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
         * id : 6
         * title : 什么是奶瓶龋？又如何预防呢
         * createtime : 1551666039
         * nickname : AQ_邹定谔
         * avatar : http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccOw23ER57f0cDuT8iaHjjRT2Q1cLI1aVaTZUN4aqqDPMNNVMPVc3KAc9Mb1ialiaCh7yhsFVYyQV4ZjeTgKZBPy4Y1/132
         * coordinate : 5,637.5km
         * thumb : http://aoquan.maimaitoo.com/attachment/images/1/2018/09/xurGAlvgPuSDPfSaJRdjUZ9L9U6vA0.jpg
         */

        private String id;
        private String title;
        private String createtime;
        private String nickname;
        private String avatar;
        private String coordinate;
        private String thumb;

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

        public String getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }






}
