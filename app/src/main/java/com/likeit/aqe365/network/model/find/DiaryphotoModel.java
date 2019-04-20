package com.likeit.aqe365.network.model.find;

import java.util.List;

public class DiaryphotoModel {

    /**
     * list : [{"day":"","title":"术前照片","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/Ip8787IH8GguKCc9G8ZhC98OP5HexI.jpg"]},{"title":"康复期","day":"第5天","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/JVVklclfrQjPeyFXsP6XPyyfE7LxrZ.jpg"]}]
     * total : 1
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
         * day :
         * title : 术前照片
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/Ip8787IH8GguKCc9G8ZhC98OP5HexI.jpg"]
         */

        private String day;
        private String title;
        private List<String> images;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
