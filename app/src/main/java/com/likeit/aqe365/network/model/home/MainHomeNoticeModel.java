package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomeNoticeModel extends HomeMessage{


    /**
     * params : {"desc":"公告123","noticedata":"0","direction":"1","noticenum":"5"}
     * style : {"background":"#00ffff","iconcolor":"#0000ff","color":"#666666"}
     * data : [{"title":"测试公告","content":"<p>测试公告内容<\/p>"}]
     * id : notice
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
         * desc : 公告123
         * noticedata : 0
         * direction : 1
         * noticenum : 5
         */

        private String desc;
        private String noticedata;
        private String direction;
        private String noticenum;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getNoticedata() {
            return noticedata;
        }

        public void setNoticedata(String noticedata) {
            this.noticedata = noticedata;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getNoticenum() {
            return noticenum;
        }

        public void setNoticenum(String noticenum) {
            this.noticenum = noticenum;
        }
    }

    public static class StyleBean {
        /**
         * background : #00ffff
         * iconcolor : #0000ff
         * color : #666666
         */

        private String background;
        private String iconcolor;
        private String color;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class DataBean {
        /**
         * title : 测试公告
         * content : <p>测试公告内容</p>
         */

        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
