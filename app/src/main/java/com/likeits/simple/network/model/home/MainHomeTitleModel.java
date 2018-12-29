package com.likeits.simple.network.model.home;

import java.io.Serializable;

public class MainHomeTitleModel extends HomeMessage{

    /**
     * params : {"title":"\u2014\u2014 推荐产品 \u2014\u2014","icon":"icox-appreciate","iconcode":"e644"}
     * style : {"background":"#ffffff","color":"#ff40d7","textalign":"center","fontsize":48,"paddingtop":36,"paddingleft":2}
     * id : title
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
         * title : —— 推荐产品 ——
         * icon : icox-appreciate
         * iconcode : e644
         */

        private String title;
        private String icon;
        private String iconcode;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIconcode() {
            return iconcode;
        }

        public void setIconcode(String iconcode) {
            this.iconcode = iconcode;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * color : #ff40d7
         * textalign : center
         * fontsize : 48
         * paddingtop : 36
         * paddingleft : 2
         */

        private String background;
        private String color;
        private String textalign;
        private int fontsize;
        private int paddingtop;
        private int paddingleft;

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

        public String getTextalign() {
            return textalign;
        }

        public void setTextalign(String textalign) {
            this.textalign = textalign;
        }

        public int getFontsize() {
            return fontsize;
        }

        public void setFontsize(int fontsize) {
            this.fontsize = fontsize;
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
    }
}
