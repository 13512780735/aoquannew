package com.likeit.aqe365.network.model.member;

import java.util.List;

public class MyUserModel {

    /**
     * list : [{"nickname":"永恒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","id":"2239","journal_num":"7","post_num":"1","kilometers":"","isuser":"0","coordinate":""},{"nickname":"健","avatar":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qe1iBYrpW6vJmmGE5bPyAkPmADzAdaOF.jpg","id":"4198","journal_num":"89","post_num":"4","kilometers":"","isuser":"1","coordinate":""},{"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","id":"5184","journal_num":"12","post_num":"34","kilometers":"","isuser":"1","coordinate":""}]
     * total : 3
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
         * nickname : 永恒
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
         * id : 2239
         * journal_num : 7
         * post_num : 1
         * kilometers :
         * isuser : 0
         * coordinate :
         */

        private String nickname;
        private String avatar;
        private String id;
        private String journal_num;
        private String post_num;
        private String kilometers;
        private String isuser;
        private String coordinate;

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

        public String getKilometers() {
            return kilometers;
        }

        public void setKilometers(String kilometers) {
            this.kilometers = kilometers;
        }

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }

        public String getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }
    }
}
