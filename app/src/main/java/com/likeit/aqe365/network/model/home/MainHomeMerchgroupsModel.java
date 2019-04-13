package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomeMerchgroupsModel extends HomeMessage {

    /**
     * style : {"background":"#ffffff","color":"#666666","bg":"#f5f7f9"}
     * params : {"type":"2"}
     * data : [{"merchname":"","logocatename":"鑫尔乐医疗","linkurl":"brand","weburl":"","params":{"id":"5"},"logo":"http://aoquan.maimaitoo.com/attachment/images/1/2018/08/FheNh9dE2TNzz9skANEgTeAc2Gee8e.png","data":["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/NXA17vaR7U1Y2aOuRx2ZxyYu67su5v.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2018/08/wefZF1EeZ4sRfNzdze40sxyy4X3z4b.png","http://aoquan.maimaitoo.com/attachment/images/1/merch/118/L5AGMYz8vSmrAbnRaKV8nNPQ8A5n7y.jpg"]},{"merchname":"","logocatename":"新华医疗","linkurl":"brand","weburl":"","params":{"id":"6"},"logo":"http://aoquan.maimaitoo.com/attachment/images/1/2018/08/FheNh9dE2TNzz9skANEgTeAc2Gee8e.png","data":["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/hBc8jTCCOczFZNT4od5jFU2n3t2PC8.jpg","http://aoquan.maimaitoo.com/addons/ewei_shopv2/plugin/app/static/images/default/goods-3.jpg","http://aoquan.maimaitoo.com/addons/ewei_shopv2/plugin/app/static/images/default/goods-3.jpg"]}]
     * id : merchgroups
     */

    private StyleBean style;
    private ParamsBean params;
    private String id;
    private List<DataBean> data;

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * color : #666666
         * bg : #f5f7f9
         */

        private String background;
        private String color;
        private String bg;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBg() {
            return bg;
        }

        public void setBg(String bg) {
            this.bg = bg;
        }
    }

    public static class ParamsBean {
        /**
         * type : 2
         */

        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class DataBean {
        /**
         * merchname :
         * logocatename : 鑫尔乐医疗
         * linkurl : brand
         * weburl :
         * params : {"id":"5"}
         * logo : http://aoquan.maimaitoo.com/attachment/images/1/2018/08/FheNh9dE2TNzz9skANEgTeAc2Gee8e.png
         * data : ["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/NXA17vaR7U1Y2aOuRx2ZxyYu67su5v.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2018/08/wefZF1EeZ4sRfNzdze40sxyy4X3z4b.png","http://aoquan.maimaitoo.com/attachment/images/1/merch/118/L5AGMYz8vSmrAbnRaKV8nNPQ8A5n7y.jpg"]
         */

        private String name;
        private String linkurl;
        private String weburl;
        private ParamsBeanX params;
        private String logo;
        private List<String> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

        public ParamsBeanX getParams() {
            return params;
        }

        public void setParams(ParamsBeanX params) {
            this.params = params;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        public static class ParamsBeanX {
            /**
             * id : 5
             */

            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
