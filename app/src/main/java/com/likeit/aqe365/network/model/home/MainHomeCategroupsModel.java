package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomeCategroupsModel extends HomeMessage{

    /**
     * style : {"background":"#ffffff","color":"#666666","bg":"#f5f7f9"}
     * data : [{"title":"名称1","linkurl":"","params":{"id":""},"data":["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Rjn19cg1kKndqIN95D259KUfuqC2kS.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/01/ozbv41ADbA8kNNxrDax8Rb4Jx1kDKa.jpg"]},{"title":"名称2","linkurl":"","params":{"id":""},"data":["http://aoquan.maimaitoo.com/attachment/images/1/2019/01/Fm9TY32y39tV9IIT9MRJiR72mJ2M6Z.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/01/Ef1cJOARFqOJpeJe7A4WFqxo6P47zy.jpg"]},{"title":"名称3","linkurl":"","params":{"id":""},"data":["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Z3HGqOzq5Ole5shvwgzE86V2uNDgV3.jpg","http://aoquan.maimaitoo.com/attachment/images/1/merch/118/l7jzzkU676zTTKO6PTn0K7220SsO2v.jpg"]},{"title":"名称4","linkurl":"","params":{"id":""},"data":["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/UAZJ9j1H4JclLd1ifAJj9wo1lYWGlA.jpg","http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Z3HGqOzq5Ole5shvwgzE86V2uNDgV3.jpg"]}]
     * id : categroups
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

    public static class DataBean {
        /**
         * title : 名称1
         * linkurl :
         * params : {"id":""}
         * data : ["http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Rjn19cg1kKndqIN95D259KUfuqC2kS.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/01/ozbv41ADbA8kNNxrDax8Rb4Jx1kDKa.jpg"]
         */

        private String title;
        private String linkurl;
        private String weburl;
        private ParamsBean params;
        private List<String> data;

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
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
