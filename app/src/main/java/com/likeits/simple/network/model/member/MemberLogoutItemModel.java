package com.likeits.simple.network.model.member;

import com.likeits.simple.network.model.home.HomeMessage;

public class MemberLogoutItemModel extends HomeMessage{

    /**
     * style : {"pwdbgcolor":"#ff5555","pwdtextcolor":"#ffffff","pwdbordercolor":"#ff5555","logoutbgcolor":"#ffffff","logouttextcolor":"#ff5555","logoutbordercolor":"#ff5555"}
     * id : logout
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
         * pwdbgcolor : #ff5555
         * pwdtextcolor : #ffffff
         * pwdbordercolor : #ff5555
         * logoutbgcolor : #ffffff
         * logouttextcolor : #ff5555
         * logoutbordercolor : #ff5555
         */

        private String pwdbgcolor;
        private String pwdtextcolor;
        private String pwdbordercolor;
        private String logoutbgcolor;
        private String logouttextcolor;
        private String logoutbordercolor;

        public String getPwdbgcolor() {
            return pwdbgcolor;
        }

        public void setPwdbgcolor(String pwdbgcolor) {
            this.pwdbgcolor = pwdbgcolor;
        }

        public String getPwdtextcolor() {
            return pwdtextcolor;
        }

        public void setPwdtextcolor(String pwdtextcolor) {
            this.pwdtextcolor = pwdtextcolor;
        }

        public String getPwdbordercolor() {
            return pwdbordercolor;
        }

        public void setPwdbordercolor(String pwdbordercolor) {
            this.pwdbordercolor = pwdbordercolor;
        }

        public String getLogoutbgcolor() {
            return logoutbgcolor;
        }

        public void setLogoutbgcolor(String logoutbgcolor) {
            this.logoutbgcolor = logoutbgcolor;
        }

        public String getLogouttextcolor() {
            return logouttextcolor;
        }

        public void setLogouttextcolor(String logouttextcolor) {
            this.logouttextcolor = logouttextcolor;
        }

        public String getLogoutbordercolor() {
            return logoutbordercolor;
        }

        public void setLogoutbordercolor(String logoutbordercolor) {
            this.logoutbordercolor = logoutbordercolor;
        }
    }
}
