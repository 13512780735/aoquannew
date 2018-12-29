package com.likeits.simple.network.model.home;

import java.io.Serializable;

public class MainHomeBlankModel extends HomeMessage{

    /**
     * style : {"height":20,"background":"#f5f5f5"}
     * id : blank
     */

    private StyleBean style;
    private String id;

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

    public static class StyleBean {
        /**
         * height : 20
         * background : #f5f5f5
         */

        private int height;
        private String background;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }
}
