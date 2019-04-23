package com.likeit.aqe365.network.model;

import java.util.List;

public class testModel {


    /**
     * params : {"showtype":"1","showtime":"60"}
     * data : [{"imgurl":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/JVVklclfrQjPeyFXsP6XPyyfE7LxrZ.jpg","linkurl":"goods.detail","weburl":"","params":{"id":"781"}},{"imgurl":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/Ip8787IH8GguKCc9G8ZhC98OP5HexI.jpg","linkurl":"diypage","weburl":"","params":{"id":"18"}},{"imgurl":"http://aoquan.maimaitoo.com/attachment/images/1/2019/04/pa6ZS6RBiUsR7wsukkzBys7L6I7yS6.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=brands.shop&id=32","params":{"id":""}}]
     */

    private ParamsBean params;
    private List<DataBean> data;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * showtype : 1
         * showtime : 60
         */

        private String showtype;
        private String showtime;

        public String getShowtype() {
            return showtype;
        }

        public void setShowtype(String showtype) {
            this.showtype = showtype;
        }

        public String getShowtime() {
            return showtime;
        }

        public void setShowtime(String showtime) {
            this.showtime = showtime;
        }
    }

    public static class DataBean {
        /**
         * imgurl : http://aoquan.maimaitoo.com/attachment/images/1/2019/04/JVVklclfrQjPeyFXsP6XPyyfE7LxrZ.jpg
         * linkurl : goods.detail
         * weburl :
         * params : {"id":"781"}
         */

        private String imgurl;
        private String linkurl;
        private String weburl;
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

        public static class ParamsBeanX {
            /**
             * id : 781
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
