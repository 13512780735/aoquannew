package com.likeit.aqe365.network.model.find;

import java.util.List;

public class HospitalandServeModel {

    /**
     * list : [{"id":"20","name":"123","proves":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/Y8EEL58M9t2T2smyT2eas85HA2zhy8.png"},{"id":"22","name":"测试别删1","proves":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/Y8EEL58M9t2T2smyT2eas85HA2zhy8.png"},{"id":"23","name":"测试别删2","proves":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/Y8EEL58M9t2T2smyT2eas85HA2zhy8.png"}]
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
         * name : 123
         * proves : http://aoquan.maimaitoo.com/attachment/images/1/2019/03/Y8EEL58M9t2T2smyT2eas85HA2zhy8.png
         */

        private String id;
        private String name;
        private String proves;

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

        public String getProves() {
            return proves;
        }

        public void setProves(String proves) {
            this.proves = proves;
        }
    }
}
