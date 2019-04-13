package com.likeit.aqe365.network.model.find;

import java.io.Serializable;
import java.util.List;

public class BoardListModel implements Serializable{

    /**
     * list : [{"id":"2","title":"3333","logo":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/L22498Zi13698118g41409xC38n00B.jpg","desc":"333333333333","postcount":"4","participant":1},{"id":"1","title":"牙科知识讲堂","logo":"http://aoquan.maimaitoo.com/attachment/images/1/2018/09/xurGAlvgPuSDPfSaJRdjUZ9L9U6vA0.jpg","desc":"","postcount":"5","participant":2}]
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

    public static class ListBean implements Serializable{
        /**
         * id : 2
         * title : 3333
         * logo : http://aoquan.maimaitoo.com/attachment/images/1/2019/03/L22498Zi13698118g41409xC38n00B.jpg
         * desc : 333333333333
         * postcount : 4
         * participant : 1
         */

        private String id;
        private String title;
        private String logo;
        private String desc;
        private String postcount;
        private String participant;
        private String isattention;

        public String getIsattention() {
            return isattention;
        }

        public void setIsattention(String isattention) {
            this.isattention = isattention;
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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPostcount() {
            return postcount;
        }

        public void setPostcount(String postcount) {
            this.postcount = postcount;
        }

        public String getParticipant() {
            return participant;
        }

        public void setParticipant(String participant) {
            this.participant = participant;
        }
    }
}
