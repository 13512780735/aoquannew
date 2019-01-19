package com.likeits.simple.network.model.home;

import java.util.List;

public class MainHomeGoodModel extends HomeMessage{

    /**
     * params : {"showtitle":"1","showprice":"1","goodsdata":"7","cateid":"","catename":"","groupid":"2","groupname":"12.12","goodssort":"0","goodsscroll":"0","goodsnum":"9","showicon":"1","iconposition":"left top","productprice":"1","showproductprice":"0","showsales":"1","productpricetext":"原价","salestext":"销量","productpriceline":"0","saleout":"0"}
     * style : {"background":"#ffffff","liststyle":"block three","buystyle":"buybtn-2","buytext":"购买","goodsicon":"推荐","iconstyle":"triangle","pricecolor":"#ff0000","productpricecolor":"#ff0080","iconpaddingtop":"0","iconpaddingleft":"0","buybtncolor":"#ff424d","iconzoom":"100","titlecolor":"#000000","tagbackground":"#fe5455","salescolor":"#80ffff"}
     * data : [{"gid":"632","title":"星海雅信（Starrysea）家用负氧离子HEPA空气净化器 办公室除PM2.5空气净化器 白色","subtitle":"","price":"2699.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/06/FOV69wvTM9dgWVjbVmvVrVnvVnDV89.jpg","total":"500","productprice":"0.00","ctype":"1","seecommission":"","cansee":"","seetitle":"","sales":"26","video":"","bargain":"0"},{"gid":"769","title":"德克特斯榨汁机","subtitle":"","price":"198.00","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/09/aNdPjIJkdPPJaTmAYlp0gvLl0Pp6gT.jpg","total":"500","productprice":"0.00","ctype":"1","seecommission":"0","cansee":"","seetitle":"","sales":"124","video":"","bargain":"0"}]
     * id : goods
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
         * showtitle : 1
         * showprice : 1
         * goodsdata : 7
         * cateid :
         * catename :
         * groupid : 2
         * groupname : 12.12
         * goodssort : 0
         * goodsscroll : 0
         * goodsnum : 9
         * showicon : 1
         * iconposition : left top
         * productprice : 1
         * showproductprice : 0
         * showsales : 1
         * productpricetext : 原价
         * salestext : 销量
         * productpriceline : 0
         * saleout : 0
         */

        private String showtitle;
        private String showprice;
        private String goodsdata;
        private String cateid;
        private String catename;
        private String groupid;
        private String groupname;
        private String goodssort;
        private String goodsscroll;
        private String goodsnum;
        private String showicon;
        private String iconposition;
        private String productprice;
        private String showproductprice;
        private String showsales;
        private String productpricetext;
        private String salestext;
        private String productpriceline;
        private String saleout;

        public String getShowtitle() {
            return showtitle;
        }

        public void setShowtitle(String showtitle) {
            this.showtitle = showtitle;
        }

        public String getShowprice() {
            return showprice;
        }

        public void setShowprice(String showprice) {
            this.showprice = showprice;
        }

        public String getGoodsdata() {
            return goodsdata;
        }

        public void setGoodsdata(String goodsdata) {
            this.goodsdata = goodsdata;
        }

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getGoodssort() {
            return goodssort;
        }

        public void setGoodssort(String goodssort) {
            this.goodssort = goodssort;
        }

        public String getGoodsscroll() {
            return goodsscroll;
        }

        public void setGoodsscroll(String goodsscroll) {
            this.goodsscroll = goodsscroll;
        }

        public String getGoodsnum() {
            return goodsnum;
        }

        public void setGoodsnum(String goodsnum) {
            this.goodsnum = goodsnum;
        }

        public String getShowicon() {
            return showicon;
        }

        public void setShowicon(String showicon) {
            this.showicon = showicon;
        }

        public String getIconposition() {
            return iconposition;
        }

        public void setIconposition(String iconposition) {
            this.iconposition = iconposition;
        }

        public String getProductprice() {
            return productprice;
        }

        public void setProductprice(String productprice) {
            this.productprice = productprice;
        }

        public String getShowproductprice() {
            return showproductprice;
        }

        public void setShowproductprice(String showproductprice) {
            this.showproductprice = showproductprice;
        }

        public String getShowsales() {
            return showsales;
        }

        public void setShowsales(String showsales) {
            this.showsales = showsales;
        }

        public String getProductpricetext() {
            return productpricetext;
        }

        public void setProductpricetext(String productpricetext) {
            this.productpricetext = productpricetext;
        }

        public String getSalestext() {
            return salestext;
        }

        public void setSalestext(String salestext) {
            this.salestext = salestext;
        }

        public String getProductpriceline() {
            return productpriceline;
        }

        public void setProductpriceline(String productpriceline) {
            this.productpriceline = productpriceline;
        }

        public String getSaleout() {
            return saleout;
        }

        public void setSaleout(String saleout) {
            this.saleout = saleout;
        }
    }

    public static class StyleBean {
        /**
         * background : #ffffff
         * liststyle : block three
         * buystyle : buybtn-2
         * buytext : 购买
         * goodsicon : 推荐
         * iconstyle : triangle
         * pricecolor : #ff0000
         * productpricecolor : #ff0080
         * iconpaddingtop : 0
         * iconpaddingleft : 0
         * buybtncolor : #ff424d
         * iconzoom : 100
         * titlecolor : #000000
         * tagbackground : #fe5455
         * salescolor : #80ffff
         */

        private String background;
        private String liststyle;
        private String buystyle;
        private String buytext;
        private String goodsicon;
        private String iconstyle;
        private String pricecolor;
        private String productpricecolor;
        private String iconpaddingtop;
        private String iconpaddingleft;
        private String buybtncolor;
        private String iconzoom;
        private String titlecolor;
        private String tagbackground;
        private String salescolor;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getListstyle() {
            return liststyle;
        }

        public void setListstyle(String liststyle) {
            this.liststyle = liststyle;
        }

        public String getBuystyle() {
            return buystyle;
        }

        public void setBuystyle(String buystyle) {
            this.buystyle = buystyle;
        }

        public String getBuytext() {
            return buytext;
        }

        public void setBuytext(String buytext) {
            this.buytext = buytext;
        }

        public String getGoodsicon() {
            return goodsicon;
        }

        public void setGoodsicon(String goodsicon) {
            this.goodsicon = goodsicon;
        }

        public String getIconstyle() {
            return iconstyle;
        }

        public void setIconstyle(String iconstyle) {
            this.iconstyle = iconstyle;
        }

        public String getPricecolor() {
            return pricecolor;
        }

        public void setPricecolor(String pricecolor) {
            this.pricecolor = pricecolor;
        }

        public String getProductpricecolor() {
            return productpricecolor;
        }

        public void setProductpricecolor(String productpricecolor) {
            this.productpricecolor = productpricecolor;
        }

        public String getIconpaddingtop() {
            return iconpaddingtop;
        }

        public void setIconpaddingtop(String iconpaddingtop) {
            this.iconpaddingtop = iconpaddingtop;
        }

        public String getIconpaddingleft() {
            return iconpaddingleft;
        }

        public void setIconpaddingleft(String iconpaddingleft) {
            this.iconpaddingleft = iconpaddingleft;
        }

        public String getBuybtncolor() {
            return buybtncolor;
        }

        public void setBuybtncolor(String buybtncolor) {
            this.buybtncolor = buybtncolor;
        }

        public String getIconzoom() {
            return iconzoom;
        }

        public void setIconzoom(String iconzoom) {
            this.iconzoom = iconzoom;
        }

        public String getTitlecolor() {
            return titlecolor;
        }

        public void setTitlecolor(String titlecolor) {
            this.titlecolor = titlecolor;
        }

        public String getTagbackground() {
            return tagbackground;
        }

        public void setTagbackground(String tagbackground) {
            this.tagbackground = tagbackground;
        }

        public String getSalescolor() {
            return salescolor;
        }

        public void setSalescolor(String salescolor) {
            this.salescolor = salescolor;
        }
    }

    public static class DataBean {
        /**
         * gid : 632
         * title : 星海雅信（Starrysea）家用负氧离子HEPA空气净化器 办公室除PM2.5空气净化器 白色
         * subtitle :
         * price : 2699.00
         * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/06/FOV69wvTM9dgWVjbVmvVrVnvVnDV89.jpg
         * total : 500
         * productprice : 0.00
         * ctype : 1
         * seecommission :
         * cansee :
         * seetitle :
         * sales : 26
         * video :
         * bargain : 0
         */

        private String gid;
        private String title;
        private String subtitle;
        private String price;
        private String thumb;
        private String total;
        private String productprice;
        private String ctype;
        private String seecommission;
        private String cansee;
        private String seetitle;
        private String sales;
        private String video;
        private String bargain;

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getProductprice() {
            return productprice;
        }

        public void setProductprice(String productprice) {
            this.productprice = productprice;
        }

        public String getCtype() {
            return ctype;
        }

        public void setCtype(String ctype) {
            this.ctype = ctype;
        }

        public String getSeecommission() {
            return seecommission;
        }

        public void setSeecommission(String seecommission) {
            this.seecommission = seecommission;
        }

        public String getCansee() {
            return cansee;
        }

        public void setCansee(String cansee) {
            this.cansee = cansee;
        }

        public String getSeetitle() {
            return seetitle;
        }

        public void setSeetitle(String seetitle) {
            this.seetitle = seetitle;
        }

        public String getSales() {
            return sales;
        }

        public void setSales(String sales) {
            this.sales = sales;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getBargain() {
            return bargain;
        }

        public void setBargain(String bargain) {
            this.bargain = bargain;
        }
    }
}
