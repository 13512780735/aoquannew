package com.likeit.aqe365.network.model.find;

import java.util.List;

public class UserListModel {

    /**
     * list : [{"nickname":"小灰爸爸","avatar":"http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccPw0vWebC0cJEfJI8AIkjcGev65GrhNSK0t1gcfNIFI6z5rmoz7BkZKYicQ10icjSiawwse6DjA0XXu3FZibLDqemOR/132","id":"2188","journal_num":"0","post_num":"0","kilometers":3.0073816950195,"coordinate":"3.0km"},{"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","id":"5184","journal_num":"2","post_num":"7","kilometers":3.2334095704245,"coordinate":"3.2km"},{"nickname":"发发大魔王","avatar":"http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8qUbdswBCydJMpicFWEicQbCstHRvZibrUhNLHSMK3Zm4l8XQuic3utJFYeLicGLsj3ia4icHVsJAG4GPGQSYN7eLrictL/132","id":"2191","journal_num":"0","post_num":"0","kilometers":3.2334095704245,"coordinate":"3.2km"},{"nickname":"Mr.zou ","avatar":"http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8MTE29PFDREniaB79P82eXibzqN9thOicW42Ik6UxqHYgXhsicBxWBb6TMzic9BmNJsMhRVpctJ7JhE9tMhqgBOqavl/132","id":"2189","journal_num":"0","post_num":"1","kilometers":5.1218274678542,"coordinate":"5.1km"},{"nickname":"凌小航","avatar":"http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccMS0WQh5bzGvsfr8ibCEGQTbwE1OYiadxdUOr1icX8kiaOYbOx1OPXWXbtEmVKjQplb8fvFicwouutSKnoOVdI3ib09gt/132","id":"2190","journal_num":"0","post_num":"0","kilometers":5.4654832103024,"coordinate":"5.5km"}]
     * total : 5
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
         * nickname : 小灰爸爸
         * avatar : http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccPw0vWebC0cJEfJI8AIkjcGev65GrhNSK0t1gcfNIFI6z5rmoz7BkZKYicQ10icjSiawwse6DjA0XXu3FZibLDqemOR/132
         * id : 2188
         * journal_num : 0
         * post_num : 0
         * kilometers : 3.0073816950195
         * coordinate : 3.0km
         */

        private String nickname;
        private String avatar;
        private String id;
        private String journal_num;
        private String post_num;
        private double kilometers;
        private String coordinate;
        private String isuser;

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJournal_num() {
            return journal_num;
        }

        public void setJournal_num(String journal_num) {
            this.journal_num = journal_num;
        }

        public String getPost_num() {
            return post_num;
        }

        public void setPost_num(String post_num) {
            this.post_num = post_num;
        }

        public double getKilometers() {
            return kilometers;
        }

        public void setKilometers(double kilometers) {
            this.kilometers = kilometers;
        }

        public String getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }
    }
}
