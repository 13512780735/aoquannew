package com.likeit.aqe365.network.model.main;

import com.likeit.aqe365.network.model.testModel;

import java.io.Serializable;
import java.util.List;

public class MainNavigationModel implements Serializable {


    /**
     * style : {"iconcolor":"#999999","iconcoloron":"#4d98fe"}
     * items : [{"linkurl":"home","iconclass":"icox-home1","iconclasscode":"e6d8","text":"首页","weburl":"http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member"},{"linkurl":"discover","iconclass":"icox-discover","iconclasscode":"e67e","text":"发现","weburl":"http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member"},{"linkurl":"notice","iconclass":"icox-notice","iconclasscode":"e771","text":"消息","weburl":"http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member"},{"linkurl":"cart","iconclass":"icox-cart1","iconclasscode":"e6d0","text":"购物车","weburl":"http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member"},{"linkurl":"member","iconclass":"icox-people","iconclasscode":"e798","text":"我的","weburl":"http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member"}]
     * adv : {"params":{"autoclose":"5"},"data":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qhHu53s6AsZWzWUu335huhH5uwG8Nu.png"]}
     * app_basic : {"appname":"澳泉医销网","logo":"http://aoquan.maimaitoo.com/attachment/images/1/2018/04/c8kRc814B6KDD8r8JOBj86DWud6rU8.png","app_shopcolor":"#4d98fe","allow_enter_index":"1","sellout_icon":"","loading_icon":"","default_avatar":"","app_wxloginopen":"1","app_qqloginopen":"1","app_agreement":"0","app_agreement_content":""}
     */

    private StyleBean style;
    private AdvBean adv;
    private StartadvBean startadv;
    private AppBasicBean app_basic;
    private List<ItemsBean> items;

    public StartadvBean getStartadv() {
        return startadv;
    }

    public void setStartadv(StartadvBean startadv) {
        this.startadv = startadv;
    }

    public StyleBean getStyle() {
        return style;
    }

    public void setStyle(StyleBean style) {
        this.style = style;
    }

    public AdvBean getAdv() {
        return adv;
    }

    public void setAdv(AdvBean adv) {
        this.adv = adv;
    }

    public AppBasicBean getApp_basic() {
        return app_basic;
    }

    public void setApp_basic(AppBasicBean app_basic) {
        this.app_basic = app_basic;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class StyleBean {
        /**
         * iconcolor : #999999
         * iconcoloron : #4d98fe
         */

        private String iconcolor;
        private String iconcoloron;

        public String getIconcolor() {
            return iconcolor;
        }

        public void setIconcolor(String iconcolor) {
            this.iconcolor = iconcolor;
        }

        public String getIconcoloron() {
            return iconcoloron;
        }

        public void setIconcoloron(String iconcoloron) {
            this.iconcoloron = iconcoloron;
        }
    }

    public static class AdvBean {
        /**
         * params : {"autoclose":"5"}
         * data : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qhHu53s6AsZWzWUu335huhH5uwG8Nu.png"]
         */

        private ParamsBean params;
        private List<String> data;

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
             * autoclose : 5
             */

            private String autoclose;

            public String getAutoclose() {
                return autoclose;
            }

            public void setAutoclose(String autoclose) {
                this.autoclose = autoclose;
            }
        }
    }

    public static class StartadvBean {
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
            private testModel.DataBean.ParamsBeanX params;

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

            public testModel.DataBean.ParamsBeanX getParams() {
                return params;
            }

            public void setParams(testModel.DataBean.ParamsBeanX params) {
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

    public static class AppBasicBean {
        /**
         * appname : 澳泉医销网
         * logo : http://aoquan.maimaitoo.com/attachment/images/1/2018/04/c8kRc814B6KDD8r8JOBj86DWud6rU8.png
         * app_shopcolor : #4d98fe
         * allow_enter_index : 1
         * sellout_icon :
         * loading_icon :
         * default_avatar :
         * app_wxloginopen : 1
         * app_qqloginopen : 1
         * app_agreement : 0
         * app_agreement_content :
         */

        private String appname;
        private String logo;
        private String app_shopcolor;
        private String allow_enter_index;
        private String sellout_icon;
        private String loading_icon;
        private String default_avatar;
        private String app_wxloginopen;
        private String app_qqloginopen;
        private String app_agreement;
        private String app_agreement_content;

        public String getAppname() {
            return appname;
        }

        public void setAppname(String appname) {
            this.appname = appname;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getApp_shopcolor() {
            return app_shopcolor;
        }

        public void setApp_shopcolor(String app_shopcolor) {
            this.app_shopcolor = app_shopcolor;
        }

        public String getAllow_enter_index() {
            return allow_enter_index;
        }

        public void setAllow_enter_index(String allow_enter_index) {
            this.allow_enter_index = allow_enter_index;
        }

        public String getSellout_icon() {
            return sellout_icon;
        }

        public void setSellout_icon(String sellout_icon) {
            this.sellout_icon = sellout_icon;
        }

        public String getLoading_icon() {
            return loading_icon;
        }

        public void setLoading_icon(String loading_icon) {
            this.loading_icon = loading_icon;
        }

        public String getDefault_avatar() {
            return default_avatar;
        }

        public void setDefault_avatar(String default_avatar) {
            this.default_avatar = default_avatar;
        }

        public String getApp_wxloginopen() {
            return app_wxloginopen;
        }

        public void setApp_wxloginopen(String app_wxloginopen) {
            this.app_wxloginopen = app_wxloginopen;
        }

        public String getApp_qqloginopen() {
            return app_qqloginopen;
        }

        public void setApp_qqloginopen(String app_qqloginopen) {
            this.app_qqloginopen = app_qqloginopen;
        }

        public String getApp_agreement() {
            return app_agreement;
        }

        public void setApp_agreement(String app_agreement) {
            this.app_agreement = app_agreement;
        }

        public String getApp_agreement_content() {
            return app_agreement_content;
        }

        public void setApp_agreement_content(String app_agreement_content) {
            this.app_agreement_content = app_agreement_content;
        }
    }

    public static class ItemsBean {
        /**
         * linkurl : home
         * iconclass : icox-home1
         * iconclasscode : e6d8
         * text : 首页
         * weburl : http://aoquan.maimaitoo.com/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=member
         */

        private String linkurl;
        private String iconclass;
        private String iconclasscode;
        private String text;
        private String weburl;

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getIconclass() {
            return iconclass;
        }

        public void setIconclass(String iconclass) {
            this.iconclass = iconclass;
        }

        public String getIconclasscode() {
            return iconclasscode;
        }

        public void setIconclasscode(String iconclasscode) {
            this.iconclasscode = iconclasscode;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }
    }
}