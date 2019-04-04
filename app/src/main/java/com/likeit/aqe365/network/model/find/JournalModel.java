package com.likeit.aqe365.network.model.find;

import java.util.ArrayList;
import java.util.List;

public class JournalModel {

    /**
     * journal : [{"id":"121","title":"补补补不不不不不不不不不不不不不不不","content":"哈哈刚回国后哈哈","edittime":"1553482044","type":"0","recoverytime":"1553443200","day":"第12天","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/9ecMZwMU16QSP6xzYN7lhZ7IhYZITJDu.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/JHyTqBRlrqIW4ZwbnldsQQU6lEBWlKQB.jpg"],"num":"第2篇日记","likenum":3,"islike":"0"},{"id":"120","title":"1111111111111","content":"就翻江倒海","edittime":"1553482043","type":"0","recoverytime":"1553443200","day":"第12天","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/m1p5griRH2vJT2hoqVWeJe8TZKcqe84q.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/H1btbC3L66BdnT17HwzvAA5Mmg2nDm68.jpg"],"num":"第1篇日记","likenum":1,"islike":"0"}]
     * total : 2
     */

    private String total;
    private List<ListBean> journal;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ListBean> getJournal() {
        return journal;
    }

    public void setJournal(List<ListBean> journal) {
        this.journal = journal;
    }

    public static class ListBean {
        /**
         * id : 121
         * title : 补补补不不不不不不不不不不不不不不不
         * content : 哈哈刚回国后哈哈
         * edittime : 1553482044
         * type : 0
         * recoverytime : 1553443200
         * day : 第12天
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/9ecMZwMU16QSP6xzYN7lhZ7IhYZITJDu.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/JHyTqBRlrqIW4ZwbnldsQQU6lEBWlKQB.jpg"]
         * num : 第2篇日记
         * likenum : 3
         * islike : 0
         */

        private String id;
        private String title;
        private String content;
        private String edittime;
        private String type;
        private String recoverytime;
        private String day;
        private String num;
        private int likenum;
        private String islike;
        public List<String> images = new ArrayList<>();
        public boolean isShowAll = false;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEdittime() {
            return edittime;
        }

        public void setEdittime(String edittime) {
            this.edittime = edittime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRecoverytime() {
            return recoverytime;
        }

        public void setRecoverytime(String recoverytime) {
            this.recoverytime = recoverytime;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public int getLikenum() {
            return likenum;
        }

        public void setLikenum(int likenum) {
            this.likenum = likenum;
        }

        public String getIslike() {
            return islike;
        }

        public void setIslike(String islike) {
            this.islike = islike;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
