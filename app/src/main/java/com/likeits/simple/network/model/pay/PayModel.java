package com.likeits.simple.network.model.pay;

import java.util.List;

public class PayModel {

    /**
     * id : 464
     * pay : [{"success":true,"name":"credit","current":"99966434.50"}]
     */

    private String id;
    private List<PayBean> pay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PayBean> getPay() {
        return pay;
    }

    public void setPay(List<PayBean> pay) {
        this.pay = pay;
    }

    public static class PayBean {
        /**
         * success : true
         * name : credit
         * current : 99966434.50
         */

        private boolean success;
        private String name;
        private String current;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCurrent() {
            return current;
        }

        public void setCurrent(String current) {
            this.current = current;
        }
    }
}
