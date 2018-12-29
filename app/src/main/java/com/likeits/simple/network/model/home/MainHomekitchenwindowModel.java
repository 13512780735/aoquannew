package com.likeits.simple.network.model.home;

import java.io.Serializable;
import java.util.List;

public class MainHomekitchenwindowModel extends HomeMessage{

    /**
     * params : {"showtype":"0","pagenum":"2"}
     * style : {"background":"#ffffff","paddingtop":20,"paddingleft":36,"showdot":"0","showbtn":"0"}
     * data : [{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/cube-1.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/cube-2.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/cube-3.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/cube-4.jpg","linkurl":"","params":{"id":""}}]
     * id : kitchenwindow
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private List<DataBean> data;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

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

    public static class ParamsBean {
        /**
         * showtype : 0
         * pagenum : 2
         */

        private String showtype;
        private String pagenum;

        public String getShowtype() {
            return showtype;
        }

        public void setShowtype(String showtype) {
            this.showtype = showtype;
        }

        public String getPagenum() {
            return pagenum;
        }

        public void setPagenum(String pagenum) {
            this.pagenum = pagenum;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * paddingtop : 20
         * paddingleft : 36
         * showdot : 0
         * showbtn : 0
         */

        private String background;
        private int paddingtop;
        private int paddingleft;
        private String showdot;
        private String showbtn;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

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

        public String getShowdot() {
            return showdot;
        }

        public void setShowdot(String showdot) {
            this.showdot = showdot;
        }

        public String getShowbtn() {
            return showbtn;
        }

        public void setShowbtn(String showbtn) {
            this.showbtn = showbtn;
        }
    }

    public static class DataBean {
        /**
         * imgurl : http://hidsy.maimaitoo.com/addons/ewei_shopv2/plugin/nativeapp/static/images/default/cube-1.jpg
         * linkurl :
         * params : {"id":""}
         */

        private String imgurl;
        private String linkurl;
        private ParamsBeanX params;

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

        public ParamsBeanX getParams() {
            return params;
        }

        public void setParams(ParamsBeanX params) {
            this.params = params;
        }

        public static class ParamsBeanX {
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
