package com.likeit.aqe365.network.model.member;

/**
 * 根据memberid获取
 */
public class GetUserInfoModel {

    /**
     * list : {"nickname":"136xxxx0576","id":"5184","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","isuser":"1"}
     */

    private ListBean list;

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * nickname : 136xxxx0576
         * id : 5184
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * isuser : 1
         */

        private String nickname;
        private String id;
        private String avatar;
        private String isuser;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }
    }
}
