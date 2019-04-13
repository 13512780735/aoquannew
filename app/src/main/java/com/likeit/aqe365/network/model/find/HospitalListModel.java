package com.likeit.aqe365.network.model.find;

import java.util.List;

public class HospitalListModel {

    /**
     * list : [{"id":"20","name":"上海余天成医疗美容门诊部","address":"上海余天成医疗美容门诊部","lon":113.34304987694,"lat":22.521619830354,"logo":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/MKksS8Gs9KdNTWk8xSBt5G3k5xN3bb.png"},{"id":"22","name":"北京世熙医疗美容","address":"北京世熙医疗美容","lon":116.22983757575,"lat":40.2155859967,"logo":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/PHNZX0NC37mEc7ECH1M7b730Ucu0Nc.jpg"},{"id":"23","name":"上海华美医疗美容医院","address":"上海华美医疗美容医院","lon":104.27396460249,"lat":34.451086367963,"logo":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/b6KoeFFKfuutheh67PEEH4Up8fe087.png"}]
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
         * id : 20
         * name : 上海余天成医疗美容门诊部
         * address : 上海余天成医疗美容门诊部
         * lon : 113.34304987694
         * lat : 22.521619830354
         * logo : http://aoquan.maimaitoo.com/attachment/images/1/2019/04/MKksS8Gs9KdNTWk8xSBt5G3k5xN3bb.png
         */

        private String id;
        private String name;
        private String address;
        private double lon;
        private double lat;
        private String logo;
        private String linkurl;
        private String weburl;

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }
}
