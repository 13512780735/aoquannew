package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomePicturewModel extends HomeMessage{

    /**
     * params : {"row":"2","showtype":"0","pagenum":"2"}
     * style : {"background":"#fff047","paddingtop":6,"paddingleft":6,"showdot":"0","showbtn":"0"}
     * data : [{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ShMRVp90Ez9SvrUasZ9ZHnl1lAUsHC.png","linkurl":"goods.detail","params":{"id":"595"}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/i7LcoYXU7l1jxxUPzuPuXhPxl7IaYJ.png","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/BYbv3LybNb0I44vEEL3bkvAWV4VIYV.png","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/A3dciezhcH7i83d8nkEEI08nTD5O58.png","linkurl":"","params":{"id":""}}]
     * id : picturew
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
         * row : 2
         * showtype : 0
         * pagenum : 2
         */

        private String row;
        private String showtype;
        private String pagenum;

        public String getRow() {
            return row;
        }

        public void setRow(String row) {
            this.row = row;
        }

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
         * background : #fff047
         * paddingtop : 6
         * paddingleft : 6
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
         * imgurl : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ShMRVp90Ez9SvrUasZ9ZHnl1lAUsHC.png
         * linkurl : goods.detail
         * params : {"id":"595"}
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
             * id : 595
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
