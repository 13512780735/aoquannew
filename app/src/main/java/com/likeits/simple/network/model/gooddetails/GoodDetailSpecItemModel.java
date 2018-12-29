package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailSpecItemModel extends HomeMessage {

    /**
     * id : detail_spec
     * data : {"spec":{"id":"716","title":"骑士MD96136/8美式全铜玻璃客厅灯餐厅灯卧室灯","productprice":"2000.00","marketprice":"1554.00","total":"5295","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/cEAIUpSWfZlgESMJseEmjesNgGegUG.jpg","skus":[{"id":"880","originPrice":"100.00","sellingPrice":null,"stockQuantity":"880","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"881","originPrice":"200.00","sellingPrice":null,"stockQuantity":"881","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"882","originPrice":"300.00","sellingPrice":null,"stockQuantity":"882","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"},{"id":"883","originPrice":"150.00","sellingPrice":null,"stockQuantity":"883","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"884","originPrice":"250.00","sellingPrice":null,"stockQuantity":"884","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"885","originPrice":"350.00","sellingPrice":null,"stockQuantity":"885","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}]}}
     */

    private String id;
    private DataBean data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * spec : {"id":"716","title":"骑士MD96136/8美式全铜玻璃客厅灯餐厅灯卧室灯","productprice":"2000.00","marketprice":"1554.00","total":"5295","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/cEAIUpSWfZlgESMJseEmjesNgGegUG.jpg","skus":[{"id":"880","originPrice":"100.00","sellingPrice":null,"stockQuantity":"880","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"881","originPrice":"200.00","sellingPrice":null,"stockQuantity":"881","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"882","originPrice":"300.00","sellingPrice":null,"stockQuantity":"882","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"},{"id":"883","originPrice":"150.00","sellingPrice":null,"stockQuantity":"883","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"884","originPrice":"250.00","sellingPrice":null,"stockQuantity":"884","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"885","originPrice":"350.00","sellingPrice":null,"stockQuantity":"885","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}]}
         */

        private SpecBean spec;

        public SpecBean getSpec() {
            return spec;
        }

        public void setSpec(SpecBean spec) {
            this.spec = spec;
        }

        public static class SpecBean {
            /**
             * id : 716
             * title : 骑士MD96136/8美式全铜玻璃客厅灯餐厅灯卧室灯
             * productprice : 2000.00
             * marketprice : 1554.00
             * total : 5295
             * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/08/cEAIUpSWfZlgESMJseEmjesNgGegUG.jpg
             * skus : [{"id":"880","originPrice":"100.00","sellingPrice":null,"stockQuantity":"880","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"881","originPrice":"200.00","sellingPrice":null,"stockQuantity":"881","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"882","originPrice":"300.00","sellingPrice":null,"stockQuantity":"882","attributes":[{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"},{"id":"883","originPrice":"150.00","sellingPrice":null,"stockQuantity":"883","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"},{"id":"884","originPrice":"250.00","sellingPrice":null,"stockQuantity":"884","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"中尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/OBZWLxJ22z2lwg7NBn3W79vgnWic3g.png"},{"id":"885","originPrice":"350.00","sellingPrice":null,"stockQuantity":"885","attributes":[{"key":"颜色","value":"黑色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ol24NC30nczRdPD0h2H9z99SJ9R3Cp.png"},{"key":"尺寸","value":"小尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/qMhkWAbbRdiiirKrAYIebdr5HgerWI.png"}]
             */

            private String id;
            private String title;
            private String productprice;
            private String marketprice;
            private String total;
            private String thumb;
            private List<SkusBean> skus;

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

            public String getProductprice() {
                return productprice;
            }

            public void setProductprice(String productprice) {
                this.productprice = productprice;
            }

            public String getMarketprice() {
                return marketprice;
            }

            public void setMarketprice(String marketprice) {
                this.marketprice = marketprice;
            }

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public List<SkusBean> getSkus() {
                return skus;
            }

            public void setSkus(List<SkusBean> skus) {
                this.skus = skus;
            }

            public static class SkusBean {
                /**
                 * id : 880
                 * originPrice : 100.00
                 * sellingPrice : null
                 * stockQuantity : 880
                 * attributes : [{"key":"颜色","value":"红色","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg"},{"key":"尺寸","value":"大尺寸","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png"}]
                 * image : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/tcP4iYZSSiJaAJHVa3aMazfpiG0aiY.png
                 */

                private String id;
                private String originPrice;
                private Object sellingPrice;
                private String stockQuantity;
                private String image;
                private List<AttributesBean> attributes;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOriginPrice() {
                    return originPrice;
                }

                public void setOriginPrice(String originPrice) {
                    this.originPrice = originPrice;
                }

                public Object getSellingPrice() {
                    return sellingPrice;
                }

                public void setSellingPrice(Object sellingPrice) {
                    this.sellingPrice = sellingPrice;
                }

                public String getStockQuantity() {
                    return stockQuantity;
                }

                public void setStockQuantity(String stockQuantity) {
                    this.stockQuantity = stockQuantity;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public List<AttributesBean> getAttributes() {
                    return attributes;
                }

                public void setAttributes(List<AttributesBean> attributes) {
                    this.attributes = attributes;
                }

                public static class AttributesBean {
                    /**
                     * key : 颜色
                     * value : 红色
                     * image : http://hidsy.maimaitoo.com/attachment/images/1/2018/12/FkZfff1CKzHr3C0577PKP79H5GFk0U.jpg
                     */

                    private String key;
                    private String value;
                    private String image;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }
            }
        }
    }
}
