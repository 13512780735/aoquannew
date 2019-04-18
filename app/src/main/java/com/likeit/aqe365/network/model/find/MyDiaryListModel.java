package com.likeit.aqe365.network.model.find;

import java.util.List;

public class MyDiaryListModel {

    private List<ListBean> list;
    private String total;
    private String memberid;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

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
         * booktitle : 你好吗
         * id : 72
         * type : 0
         * num : 0
         */

        private String booktitle;
        private String id;
        private String type;
        private String num;

        public String getBooktitle() {
            return booktitle;
        }

        public void setBooktitle(String booktitle) {
            this.booktitle = booktitle;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }
}
