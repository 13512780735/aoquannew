package com.likeit.aqe365.network.model.home;

public class MainHomeVideoModel extends HomeMessage {

    /**
     * style : {"ratio":"0"}
     * params : {"videourl":"https://v.qq.com/txp/iframe/player.html?vid=k0806d2rbo2","poster":""}
     * id : video
     */

    private StyleBean style;
    private ParamsBean params;
    private String id;

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

    public static class StyleBean {
        /**
         * ratio : 0
         */

        private String ratio;

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }
    }

    public static class ParamsBean {
        /**
         * videourl : https://v.qq.com/txp/iframe/player.html?vid=k0806d2rbo2
         * poster :
         */

        private String videourl;
        private String poster;

        public String getVideourl() {
            return videourl;
        }

        public void setVideourl(String videourl) {
            this.videourl = videourl;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }
    }
}
