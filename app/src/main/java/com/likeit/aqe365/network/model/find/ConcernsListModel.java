package com.likeit.aqe365.network.model.find;

import java.io.Serializable;
import java.util.List;

public class ConcernsListModel implements Serializable {

    /**
     * 关联用户
     * list : [{"nickname":"Mr.zou ","avatar":"http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8MTE29PFDREniaB79P82eXibzqN9thOicW42Ik6UxqHYgXhsicBxWBb6TMzic9BmNJsMhRVpctJ7JhE9tMhqgBOqavl/132","id":"2189"},{"nickname":"小灰爸爸","avatar":"http://thirdwx.qlogo.cn/mmopen/jZajuIr8ccPw0vWebC0cJEfJI8AIkjcGev65GrhNSK0t1gcfNIFI6z5rmoz7BkZKYicQ10icjSiawwse6DjA0XXu3FZibLDqemOR/132","id":"2188"}]
     * total : 2
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

    public static class ListBean implements Serializable {
        /**
         * nickname : Mr.zou
         * avatar : http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8MTE29PFDREniaB79P82eXibzqN9thOicW42Ik6UxqHYgXhsicBxWBb6TMzic9BmNJsMhRVpctJ7JhE9tMhqgBOqavl/132
         * id : 2189
         */

        private String nickname;
        private String avatar;
        private String id;
        private Boolean checked;
        public boolean isChoosed;

//
//        public ListBean(String nickname,String id, String avatar, Boolean checked) {
//            this.nickname = nickname;
//            this.id = id;
//            this.avatar = avatar;
//            this.checked = checked;
//        }

        public Boolean getChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

        public boolean isChoosed() {
            return isChoosed;
        }

        public void setChoosed(boolean choosed) {
            isChoosed = choosed;
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
    }
}
