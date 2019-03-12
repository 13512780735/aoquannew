package com.likeit.aqe365.network.model.home;


import java.util.List;

public class MainHomeBannerModel  extends HomeMessage  {

    /**
     * style : {"dotstyle":"round","dotalign":"center","background":"#000000","opacity":"0.8"}
     * data : [{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/hRjBo1qybzYr1k3yWnYQnryn0eBE81.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/t9pAVwd4cvKcFF4fDcg9PT4Z444PPv.jpg","linkurl":"","params":{"id":""}},{"imgurl":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/x17PQhpQl71712c9Ki6d2gL4529i77.jpg","linkurl":"","params":{"id":""}}]
     * id : banner
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
         * dotstyle : round
         * dotalign : center
         * background : #000000
         * opacity : 0.8
         */

        private String dotstyle;
        private String dotalign;
        private String background;
        private String opacity;

        public String getDotstyle() {
            return dotstyle;
        }

        public void setDotstyle(String dotstyle) {
            this.dotstyle = dotstyle;
        }

        public String getDotalign() {
            return dotalign;
        }

        public void setDotalign(String dotalign) {
            this.dotalign = dotalign;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getOpacity() {
            return opacity;
        }

        public void setOpacity(String opacity) {
            this.opacity = opacity;
        }
    }

    public static class DataBean {
        /**
         * imgurl : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/hRjBo1qybzYr1k3yWnYQnryn0eBE81.jpg
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
