package com.likeits.simple.network.model.home;

import java.io.Serializable;

public class MainHomeSearch01Model extends HomeMessage{

    /**
     * params : {"placeholder":"请输入关键字进行搜索"}
     * style : {"inputbackground":"#59ff19","background":"#f1f52d","iconcolor":"#b4b4b4","color":"#999999","paddingtop":20,"paddingleft":26,"textalign":"left","searchstyle":"round"}
     * id : search
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;

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
         * placeholder : 请输入关键字进行搜索
         */

        private String placeholder;

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }
    }

    public static class StyleBean {
        /**
         * inputbackground : #59ff19
         * background : #f1f52d
         * iconcolor : #b4b4b4
         * color : #999999
         * paddingtop : 20
         * paddingleft : 26
         * textalign : left
         * searchstyle : round
         */

        private String inputbackground;
        private String background;
        private String iconcolor;
        private String color;
        private int paddingtop;
        private int paddingleft;
        private String textalign;
        private String searchstyle;

        public String getInputbackground() {
            return inputbackground;
        }

        public void setInputbackground(String inputbackground) {
            this.inputbackground = inputbackground;
        }

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

        public String getTextalign() {
            return textalign;
        }

        public void setTextalign(String textalign) {
            this.textalign = textalign;
        }

        public String getSearchstyle() {
            return searchstyle;
        }

        public void setSearchstyle(String searchstyle) {
            this.searchstyle = searchstyle;
        }
    }
}
