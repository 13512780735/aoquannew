package com.likeit.aqe365.network.model.home;

import java.util.List;

public class MainHomeMarkingModel extends HomeMessage{

    /**
     * params : {"flashsaletitle":"限时抢购","hitstitle":"本月人气榜单","groupstitle":"每日必拼","foundtitle":"发现好货","newproducttitle":"新品首发","flashsalelinkurl":"","hitslinkurl":"diypage?id=15","groupslinkurl":"","foundlinkurl":"diypage?id=17","newproductlinkurl":"diypage?id=18","flashsaleweburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","hitsweburl":"","groupsweburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","foundweburl":"","newproductweburl":""}
     * style : {"timerbg":"#44abf7","background":"#ffffff","color":"#666666","bg":"#f5f7f9"}
     * id : marketing
     * data : {"seckill":{"title":"限时抢购","starttime":1555117200,"endtime":1555120799,"status":0,"nowtime":1555119500,"data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/xBOwGRazHZvA77ob6rgropXrBROhVb.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/FhaS71222a1c1Ms1xSs38mSqsI3Tts.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}}]},"renqibang":{"title":"本月人气榜单","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Zfb24F6OBFz2zFrcOcySVF91jfFS73.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2018/08/YWxRXI58aEzx8WjExX17X5mXW591Re.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}}]},"groupbuy":{"title":"每日必拼","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/NKGZ058w0a3Eg3F6DEu86jKW318Urw.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/pp80o0Mb8A2zoRlz8x12KOO2oQo2Po.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}}]},"haohuo":{"title":"发现好货","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/lNfTFCQlNv04e45trGraTqvltyRAGT.jpg","linkurl":"diypage","weburl":"","params":{"id":"17"}}]},"xinpin":{"title":"新品首发","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/tL1i01V2SFnz8R0IgGT00qqG8nGRQz.jpg","linkurl":"diypage","weburl":"","params":{"id":"18"}}]}}
     */

    private ParamsBean params;
    private StyleBean style;
    private String id;
    private DataBeanXXXXX data;

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

    public DataBeanXXXXX getData() {
        return data;
    }

    public void setData(DataBeanXXXXX data) {
        this.data = data;
    }

    public static class ParamsBean {
        /**
         * flashsaletitle : 限时抢购
         * hitstitle : 本月人气榜单
         * groupstitle : 每日必拼
         * foundtitle : 发现好货
         * newproducttitle : 新品首发
         * flashsalelinkurl :
         * hitslinkurl : diypage?id=15
         * groupslinkurl :
         * foundlinkurl : diypage?id=17
         * newproductlinkurl : diypage?id=18
         * flashsaleweburl : http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill
         * hitsweburl :
         * groupsweburl : http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups
         * foundweburl :
         * newproductweburl :
         */

        private String flashsaletitle;
        private String hitstitle;
        private String groupstitle;
        private String foundtitle;
        private String newproducttitle;
        private String flashsalelinkurl;
        private String hitslinkurl;
        private String groupslinkurl;
        private String foundlinkurl;
        private String newproductlinkurl;
        private String flashsaleweburl;
        private String hitsweburl;
        private String groupsweburl;
        private String foundweburl;
        private String newproductweburl;

        public String getFlashsaletitle() {
            return flashsaletitle;
        }

        public void setFlashsaletitle(String flashsaletitle) {
            this.flashsaletitle = flashsaletitle;
        }

        public String getHitstitle() {
            return hitstitle;
        }

        public void setHitstitle(String hitstitle) {
            this.hitstitle = hitstitle;
        }

        public String getGroupstitle() {
            return groupstitle;
        }

        public void setGroupstitle(String groupstitle) {
            this.groupstitle = groupstitle;
        }

        public String getFoundtitle() {
            return foundtitle;
        }

        public void setFoundtitle(String foundtitle) {
            this.foundtitle = foundtitle;
        }

        public String getNewproducttitle() {
            return newproducttitle;
        }

        public void setNewproducttitle(String newproducttitle) {
            this.newproducttitle = newproducttitle;
        }

        public String getFlashsalelinkurl() {
            return flashsalelinkurl;
        }

        public void setFlashsalelinkurl(String flashsalelinkurl) {
            this.flashsalelinkurl = flashsalelinkurl;
        }

        public String getHitslinkurl() {
            return hitslinkurl;
        }

        public void setHitslinkurl(String hitslinkurl) {
            this.hitslinkurl = hitslinkurl;
        }

        public String getGroupslinkurl() {
            return groupslinkurl;
        }

        public void setGroupslinkurl(String groupslinkurl) {
            this.groupslinkurl = groupslinkurl;
        }

        public String getFoundlinkurl() {
            return foundlinkurl;
        }

        public void setFoundlinkurl(String foundlinkurl) {
            this.foundlinkurl = foundlinkurl;
        }

        public String getNewproductlinkurl() {
            return newproductlinkurl;
        }

        public void setNewproductlinkurl(String newproductlinkurl) {
            this.newproductlinkurl = newproductlinkurl;
        }

        public String getFlashsaleweburl() {
            return flashsaleweburl;
        }

        public void setFlashsaleweburl(String flashsaleweburl) {
            this.flashsaleweburl = flashsaleweburl;
        }

        public String getHitsweburl() {
            return hitsweburl;
        }

        public void setHitsweburl(String hitsweburl) {
            this.hitsweburl = hitsweburl;
        }

        public String getGroupsweburl() {
            return groupsweburl;
        }

        public void setGroupsweburl(String groupsweburl) {
            this.groupsweburl = groupsweburl;
        }

        public String getFoundweburl() {
            return foundweburl;
        }

        public void setFoundweburl(String foundweburl) {
            this.foundweburl = foundweburl;
        }

        public String getNewproductweburl() {
            return newproductweburl;
        }

        public void setNewproductweburl(String newproductweburl) {
            this.newproductweburl = newproductweburl;
        }
    }

    public static class StyleBean {
        /**
         * timerbg : #44abf7
         * background : #ffffff
         * color : #666666
         * bg : #f5f7f9
         */

        private String timerbg;
        private String background;
        private String color;
        private String bg;

        public String getTimerbg() {
            return timerbg;
        }

        public void setTimerbg(String timerbg) {
            this.timerbg = timerbg;
        }

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

    public static class DataBeanXXXXX {
        /**
         * seckill : {"title":"限时抢购","starttime":1555117200,"endtime":1555120799,"status":0,"nowtime":1555119500,"data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/xBOwGRazHZvA77ob6rgropXrBROhVb.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/FhaS71222a1c1Ms1xSs38mSqsI3Tts.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}}]}
         * renqibang : {"title":"本月人气榜单","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Zfb24F6OBFz2zFrcOcySVF91jfFS73.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2018/08/YWxRXI58aEzx8WjExX17X5mXW591Re.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}}]}
         * groupbuy : {"title":"每日必拼","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/NKGZ058w0a3Eg3F6DEu86jKW318Urw.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/pp80o0Mb8A2zoRlz8x12KOO2oQo2Po.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}}]}
         * haohuo : {"title":"发现好货","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/lNfTFCQlNv04e45trGraTqvltyRAGT.jpg","linkurl":"diypage","weburl":"","params":{"id":"17"}}]}
         * xinpin : {"title":"新品首发","data":[{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/tL1i01V2SFnz8R0IgGT00qqG8nGRQz.jpg","linkurl":"diypage","weburl":"","params":{"id":"18"}}]}
         */

        private SeckillBean seckill;
        private RenqibangBean renqibang;
        private GroupbuyBean groupbuy;
        private HaohuoBean haohuo;
        private XinpinBean xinpin;

        public SeckillBean getSeckill() {
            return seckill;
        }

        public void setSeckill(SeckillBean seckill) {
            this.seckill = seckill;
        }

        public RenqibangBean getRenqibang() {
            return renqibang;
        }

        public void setRenqibang(RenqibangBean renqibang) {
            this.renqibang = renqibang;
        }

        public GroupbuyBean getGroupbuy() {
            return groupbuy;
        }

        public void setGroupbuy(GroupbuyBean groupbuy) {
            this.groupbuy = groupbuy;
        }

        public HaohuoBean getHaohuo() {
            return haohuo;
        }

        public void setHaohuo(HaohuoBean haohuo) {
            this.haohuo = haohuo;
        }

        public XinpinBean getXinpin() {
            return xinpin;
        }

        public void setXinpin(XinpinBean xinpin) {
            this.xinpin = xinpin;
        }

        public static class SeckillBean {
            /**
             * title : 限时抢购
             * starttime : 1555117200
             * endtime : 1555120799
             * status : 0
             * nowtime : 1555119500
             * data : [{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/xBOwGRazHZvA77ob6rgropXrBROhVb.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/FhaS71222a1c1Ms1xSs38mSqsI3Tts.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill","params":{"id":""}}]
             */

            private String title;
            private int starttime;
            private int endtime;
            private int status;
            private int nowtime;
            private List<DataBean> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getStarttime() {
                return starttime;
            }

            public void setStarttime(int starttime) {
                this.starttime = starttime;
            }

            public int getEndtime() {
                return endtime;
            }

            public void setEndtime(int endtime) {
                this.endtime = endtime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getNowtime() {
                return nowtime;
            }

            public void setNowtime(int nowtime) {
                this.nowtime = nowtime;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * thumb : http://aoquan.maimaitoo.com/attachment/images/1/merch/118/xBOwGRazHZvA77ob6rgropXrBROhVb.jpg
                 * linkurl :
                 * weburl : http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=seckill
                 * params : {"id":""}
                 */

                private String thumb;
                private String linkurl;
                private String weburl;
                private ParamsBeanX params;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
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

                public ParamsBeanX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanX params) {
                    this.params = params;
                }

                public static class ParamsBeanX {
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

        public static class RenqibangBean {
            /**
             * title : 本月人气榜单
             * data : [{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Zfb24F6OBFz2zFrcOcySVF91jfFS73.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2018/08/YWxRXI58aEzx8WjExX17X5mXW591Re.jpg","linkurl":"diypage","weburl":"","params":{"id":"15"}}]
             */

            private String title;
            private List<DataBeanX> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataBeanX> getData() {
                return data;
            }

            public void setData(List<DataBeanX> data) {
                this.data = data;
            }

            public static class DataBeanX {
                /**
                 * thumb : http://aoquan.maimaitoo.com/attachment/images/1/merch/118/Zfb24F6OBFz2zFrcOcySVF91jfFS73.jpg
                 * linkurl : diypage
                 * weburl :
                 * params : {"id":"15"}
                 */

                private String thumb;
                private String linkurl;
                private String weburl;
                private ParamsBeanXX params;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
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

                public ParamsBeanXX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanXX params) {
                    this.params = params;
                }

                public static class ParamsBeanXX {
                    /**
                     * id : 15
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

        public static class GroupbuyBean {
            /**
             * title : 每日必拼
             * data : [{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/NKGZ058w0a3Eg3F6DEu86jKW318Urw.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}},{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/2019/01/pp80o0Mb8A2zoRlz8x12KOO2oQo2Po.jpg","linkurl":"","weburl":"http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups","params":{"id":""}}]
             */

            private String title;
            private List<DataBeanXX> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataBeanXX> getData() {
                return data;
            }

            public void setData(List<DataBeanXX> data) {
                this.data = data;
            }

            public static class DataBeanXX {
                /**
                 * thumb : http://aoquan.maimaitoo.com/attachment/images/1/2019/01/NKGZ058w0a3Eg3F6DEu86jKW318Urw.jpg
                 * linkurl :
                 * weburl : http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=groups
                 * params : {"id":""}
                 */

                private String thumb;
                private String linkurl;
                private String weburl;
                private ParamsBeanXXX params;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
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

                public ParamsBeanXXX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanXXX params) {
                    this.params = params;
                }

                public static class ParamsBeanXXX {
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

        public static class HaohuoBean {
            /**
             * title : 发现好货
             * data : [{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/lNfTFCQlNv04e45trGraTqvltyRAGT.jpg","linkurl":"diypage","weburl":"","params":{"id":"17"}}]
             */

            private String title;
            private List<DataBeanXXX> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataBeanXXX> getData() {
                return data;
            }

            public void setData(List<DataBeanXXX> data) {
                this.data = data;
            }

            public static class DataBeanXXX {
                /**
                 * thumb : http://aoquan.maimaitoo.com/attachment/images/1/merch/118/lNfTFCQlNv04e45trGraTqvltyRAGT.jpg
                 * linkurl : diypage
                 * weburl :
                 * params : {"id":"17"}
                 */

                private String thumb;
                private String linkurl;
                private String weburl;
                private ParamsBeanXXXX params;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
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

                public ParamsBeanXXXX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanXXXX params) {
                    this.params = params;
                }

                public static class ParamsBeanXXXX {
                    /**
                     * id : 17
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

        public static class XinpinBean {
            /**
             * title : 新品首发
             * data : [{"thumb":"http://aoquan.maimaitoo.com/attachment/images/1/merch/118/tL1i01V2SFnz8R0IgGT00qqG8nGRQz.jpg","linkurl":"diypage","weburl":"","params":{"id":"18"}}]
             */

            private String title;
            private List<DataBeanXXXX> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<DataBeanXXXX> getData() {
                return data;
            }

            public void setData(List<DataBeanXXXX> data) {
                this.data = data;
            }

            public static class DataBeanXXXX {
                /**
                 * thumb : http://aoquan.maimaitoo.com/attachment/images/1/merch/118/tL1i01V2SFnz8R0IgGT00qqG8nGRQz.jpg
                 * linkurl : diypage
                 * weburl :
                 * params : {"id":"18"}
                 */

                private String thumb;
                private String linkurl;
                private String weburl;
                private ParamsBeanXXXXX params;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
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

                public ParamsBeanXXXXX getParams() {
                    return params;
                }

                public void setParams(ParamsBeanXXXXX params) {
                    this.params = params;
                }

                public static class ParamsBeanXXXXX {
                    /**
                     * id : 18
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
    }
}
