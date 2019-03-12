package com.likeit.aqe365.network.model.GoodCategory;

import java.util.List;

public class CategoryListItemsModel {

    /**
     * list : [{"id":"775","title":"金百丽MD707-6浪漫时光智能吊灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/156/RKA0kuzDEGJg4uFYw8pZdWpY8ezAPz.jpg","marketprice":"1138.00","productprice":"0.00","showsales":"1"},{"id":"788","title":"新中式全铜如意系列SHT8807-8+4吊灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/hAbJTzBD6mHtAM58JJaqJHhaq9jdra.jpg","marketprice":"4640.00","productprice":"0.00","showsales":"0"},{"id":"787","title":"新中式全铜如意系列SHT8807-8吊灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/yPShSE0EO1vhi1PZg0EP12NzsgEoWE.png","marketprice":"3380.00","productprice":"0.00","showsales":"0"},{"id":"632","title":"星海雅信（Starrysea）家用负氧离子HEPA空气净化器 办公室除PM2.5空气净化器 白色","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/06/FOV69wvTM9dgWVjbVmvVrVnvVnDV89.jpg","marketprice":"2699.00","productprice":"0.00","showsales":"1"},{"id":"501","title":"流光溢彩TCH3185-10吊灯欧式灯客厅灯书房灯餐厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/N0DAI9OOz1AbV1bDgrB2RV2ZriGR2C.jpg","marketprice":"3200.00","productprice":"0.00","showsales":"1"},{"id":"592","title":"天空之城58055-8艺术级高端全铜吊灯古典奢丽大厅灯餐厅灯书房灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/DoB4zpCPYzvCCvg94Nq2yVv4TSvDYg.jpg","marketprice":"3560.00","productprice":"0.00","showsales":"1"},{"id":"526","title":"美妙人生11189-10美式黄铜玻璃吊灯餐厅灯客厅灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/CK9x9YUFXeUf2eTO4KT48b4C5zaLt4.jpg","marketprice":"3780.00","productprice":"5000.00","showsales":"1"},{"id":"389","title":"骑士之光SJ-6367D-10L吊灯美式全铜灯客厅灯餐厅灯书房灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/P3E2H47ECCeccOOi2HY5YFptcOeIPy.jpg","marketprice":"4720.00","productprice":"0.00","showsales":"1"},{"id":"238","title":"玉观音69818-L8吊灯美式灯客厅灯餐厅灯书房灯卧室灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/oDAQPceCC1Z3SjRcC1CYc1333jJJUR.jpg","marketprice":"2520.00","productprice":"0.00","showsales":"1"},{"id":"790","title":"新中式全铜如意系列SHT8807-1壁灯","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/merch/155/A8BVIvhY1p83uvavB8z22Rzzv7B88T.jpg","marketprice":"450.00","productprice":"0.00","showsales":"0"}]
     * total : 284
     */

    private String total;
    private List<ListBean> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 775
         * title : 金百丽MD707-6浪漫时光智能吊灯
         * thumb : http://hidsy.maimaitoo.com/attachment/images/1/merch/156/RKA0kuzDEGJg4uFYw8pZdWpY8ezAPz.jpg
         * marketprice : 1138.00
         * productprice : 0.00
         * showsales : 1
         */

        private String id;
        private String title;
        private String thumb;
        private String marketprice;
        private String productprice;
        private String showsales;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }

        public String getProductprice() {
            return productprice;
        }

        public void setProductprice(String productprice) {
            this.productprice = productprice;
        }

        public String getShowsales() {
            return showsales;
        }

        public void setShowsales(String showsales) {
            this.showsales = showsales;
        }
    }
}
