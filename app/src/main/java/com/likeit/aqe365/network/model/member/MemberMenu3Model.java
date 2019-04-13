package com.likeit.aqe365.network.model.member;

import com.likeit.aqe365.network.model.home.HomeMessage;

import java.util.List;

public class MemberMenu3Model extends HomeMessage {


    /**
     * style : {"background":"#4d98fe"}
     * data : [{"text":"日记","textcolor":"#ffffff","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.my.diarylist","params":{"id":""},"dotnum":0},{"text":"发布","textcolor":"#ffffff","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.my.postlist","params":{"id":""},"dotnum":0},{"text":"话题","textcolor":"#ffffff","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.boardList","params":{"id":""},"dotnum":0},{"text":"粉丝","textcolor":"#ffffff","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.myfans","params":{"id":""},"dotnum":0},{"text":"关注","textcolor":"#ffffff","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.myattention","params":{"id":""},"dotnum":0}]
     * id : menu3
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
         * background : #4d98fe
         */

        private String background;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    public static class DataBean {
        /**
         * text : 日记
         * textcolor : #ffffff
         * linkurl :
         * weburl : http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member.my.diarylist
         * params : {"id":""}
         * dotnum : 0
         */

        private String text;
        private String textcolor;
        private String linkurl;
        private String weburl;
        private ParamsBean params;
        private int dotnum;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTextcolor() {
            return textcolor;
        }

        public void setTextcolor(String textcolor) {
            this.textcolor = textcolor;
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

        public ParamsBean getParams() {
            return params;
        }

        public void setParams(ParamsBean params) {
            this.params = params;
        }

        public int getDotnum() {
            return dotnum;
        }

        public void setDotnum(int dotnum) {
            this.dotnum = dotnum;
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
