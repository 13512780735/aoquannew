package com.likeit.aqe365.network.model.home;

public class MainHomeSearchModel extends HomeMessage{

    /**
     * istop : 2
     * max : 1
     * only : toptab
     * params : {"leftnav":"1","rightnav":"1","rightnavclick":"0","leftnavicon":"icox-category","rightnavicon":"icox-cart","searchstyle":"round","placeholder":"输入关键字进行搜索","leftnavlink":"category","rightnavlink":"cart","leftnaviconcode":"e699","rightnaviconcode":"e698"}
     * style : {"background":"#ffffff","opacity":"0.8","opacityinput":"0.8","leftnavcolor":"#989898","rightnavcolor":"#989898","searchbackground":"#ffffff","searchtextcolor":"#757575"}
     * id : fixedsearch
     */

    private String istop;
    private String max;
    private String only;
    private ParamsBean params;
    private StyleBean style;
    private String id;

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getOnly() {
        return only;
    }

    public void setOnly(String only) {
        this.only = only;
    }

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

    public static class ParamsBean {
        /**
         * leftnav : 1
         * rightnav : 1
         * rightnavclick : 0
         * leftnavicon : icox-category
         * rightnavicon : icox-cart
         * searchstyle : round
         * placeholder : 输入关键字进行搜索
         * leftnavlink : category
         * rightnavlink : cart
         * leftnaviconcode : e699
         * rightnaviconcode : e698
         */

        private String leftnav;
        private String rightnav;
        private String rightnavclick;
        private String leftnavicon;
        private String rightnavicon;
        private String searchstyle;
        private String placeholder;
        private String leftnavlink;
        private String rightnavlink;
        private String leftnaviconcode;
        private String rightnaviconcode;
        private String islocation;

        public String getIslocation() {
            return islocation;
        }

        public void setIslocation(String islocation) {
            this.islocation = islocation;
        }

        public String getLeftnav() {
            return leftnav;
        }

        public void setLeftnav(String leftnav) {
            this.leftnav = leftnav;
        }

        public String getRightnav() {
            return rightnav;
        }

        public void setRightnav(String rightnav) {
            this.rightnav = rightnav;
        }

        public String getRightnavclick() {
            return rightnavclick;
        }

        public void setRightnavclick(String rightnavclick) {
            this.rightnavclick = rightnavclick;
        }

        public String getLeftnavicon() {
            return leftnavicon;
        }

        public void setLeftnavicon(String leftnavicon) {
            this.leftnavicon = leftnavicon;
        }

        public String getRightnavicon() {
            return rightnavicon;
        }

        public void setRightnavicon(String rightnavicon) {
            this.rightnavicon = rightnavicon;
        }

        public String getSearchstyle() {
            return searchstyle;
        }

        public void setSearchstyle(String searchstyle) {
            this.searchstyle = searchstyle;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public String getLeftnavlink() {
            return leftnavlink;
        }

        public void setLeftnavlink(String leftnavlink) {
            this.leftnavlink = leftnavlink;
        }

        public String getRightnavlink() {
            return rightnavlink;
        }

        public void setRightnavlink(String rightnavlink) {
            this.rightnavlink = rightnavlink;
        }

        public String getLeftnaviconcode() {
            return leftnaviconcode;
        }

        public void setLeftnaviconcode(String leftnaviconcode) {
            this.leftnaviconcode = leftnaviconcode;
        }

        public String getRightnaviconcode() {
            return rightnaviconcode;
        }

        public void setRightnaviconcode(String rightnaviconcode) {
            this.rightnaviconcode = rightnaviconcode;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * opacity : 0.8
         * opacityinput : 0.8
         * leftnavcolor : #989898
         * rightnavcolor : #989898
         * searchbackground : #ffffff
         * searchtextcolor : #757575
         */

        private String background;
        private String opacity;
        private String opacityinput;
        private String leftnavcolor;
        private String rightnavcolor;
        private String searchbackground;
        private String searchtextcolor;

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

        public String getOpacityinput() {
            return opacityinput;
        }

        public void setOpacityinput(String opacityinput) {
            this.opacityinput = opacityinput;
        }

        public String getLeftnavcolor() {
            return leftnavcolor;
        }

        public void setLeftnavcolor(String leftnavcolor) {
            this.leftnavcolor = leftnavcolor;
        }

        public String getRightnavcolor() {
            return rightnavcolor;
        }

        public void setRightnavcolor(String rightnavcolor) {
            this.rightnavcolor = rightnavcolor;
        }

        public String getSearchbackground() {
            return searchbackground;
        }

        public void setSearchbackground(String searchbackground) {
            this.searchbackground = searchbackground;
        }

        public String getSearchtextcolor() {
            return searchtextcolor;
        }

        public void setSearchtextcolor(String searchtextcolor) {
            this.searchtextcolor = searchtextcolor;
        }
    }
}
