package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailSpecItemModel extends HomeMessage {


    /**
     * id : detail_spec
     * data : {"spec":{"id":"595","title":"测试","productprice":"0.00","marketprice":"10.00","total":"3530","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png","skus":[{"id":"840","originPrice":"1.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"841","originPrice":"2.00","stockQuantity":"879","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"id":"842","originPrice":"3.00","stockQuantity":"881","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"843","originPrice":"4.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}]}}
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
         * spec : {"id":"595","title":"测试","productprice":"0.00","marketprice":"10.00","total":"3530","thumb":"http://hidsy.maimaitoo.com/attachment/images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png","skus":[{"id":"840","originPrice":"1.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"841","originPrice":"2.00","stockQuantity":"879","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"id":"842","originPrice":"3.00","stockQuantity":"881","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"843","originPrice":"4.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}]}
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
             * id : 595
             * title : 测试
             * productprice : 0.00
             * marketprice : 10.00
             * total : 3530
             * thumb : http://hidsy.maimaitoo.com/attachment/images/1/2018/03/FT2t2FkKf2A09gKC9Z92kJatelJ5Az.png
             * skus : [{"id":"840","originPrice":"1.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"841","originPrice":"2.00","stockQuantity":"879","attributes":[{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"id":"842","originPrice":"3.00","stockQuantity":"881","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"},{"id":"843","originPrice":"4.00","stockQuantity":"885","attributes":[{"key":"规格01","value":"02","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gYoyY9Y7Ni0IpwoNod927MP7Z0By9h.png"},{"key":"规格02","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}],"image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"}]
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
                 * id : 840
                 * originPrice : 1.00
                 * stockQuantity : 885
                 * attributes : [{"key":"规格01","value":"04","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg"},{"key":"规格02","value":"03","image":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg"}]
                 * image : http://hidsy.maimaitoo.com/attachment/images/1/2018/08/gpsd111sdt5bpDT3aJafZ10QdMt4GQ.jpg
                 */

                private String id;
                private String originPrice;
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
                     * key : 规格01
                     * value : 04
                     * image : http://hidsy.maimaitoo.com/attachment/images/1/2018/08/ga39tInD02dCC4TMCK8vVdp4vXMHV7.jpg
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
