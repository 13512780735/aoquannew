package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomePictureModel extends HomeMessage{

    /**
     * style : {"paddingtop":0,"paddingleft":0,"background":"#ffffff"}
     * data : [{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/banner-1.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/banner-2.jpg","linkurl":"","params":{"id":""}}]
     * id : picture
     */

    private StyleBean style;
    private String id;
    private List<DataBean> data;

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
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
         * paddingtop : 0
         * paddingleft : 0
         * background : #ffffff
         */

        private int paddingtop;
        private int paddingleft;
        private String background;

        public int getPaddingtop() {
            return paddingtop;
        }

        public void setPaddingtop(int paddingtop) {
            this.paddingtop = paddingtop;
        }

        public int getPaddingleft() {
            return paddingleft;
        }

        public void setPaddingleft(int paddingleft) {
            this.paddingleft = paddingleft;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    public static class DataBean {
        /**
         * imgurl : http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/banner-1.jpg
         * linkurl :
         * params : {"id":""}
         */

        private String imgurl;
        private String linkurl;
        private ParamsBean params;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public static class ParamsBean {
            /**
             * id :
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
