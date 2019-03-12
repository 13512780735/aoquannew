package com.likeit.aqe365.network.model.gooddetails;

import com.likeit.aqe365.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailBannerItemModel extends HomeMessage{

    /**
     * params : {"isclick":"1"}
     * style : {"background":"#ff7b26"}
     * id : detail_swipe
     * data : [{"big_img":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/UkTkjGkS1KKtBCGpZR344li1lqNC1R.jpg"},{"big_img":"http://hidsy.maimaitoo.com/attachment/images/1/2018/08/aJZUbNbrM30cra8f00R8GUnt0ccUZb.png"}]
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
         * isclick : 1
         */

        private String isclick;

        public String getIsclick() {
            return isclick;
        }

        public void setIsclick(String isclick) {
            this.isclick = isclick;
        }
    }

    public static class StyleBean {
        /**
         * background : #ff7b26
         */

        private String background;

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }

    public static class DataBean {
        /**
         * big_img : http://hidsy.maimaitoo.com/attachment/images/1/2018/08/UkTkjGkS1KKtBCGpZR344li1lqNC1R.jpg
         */

        private String big_img;

        public String getBig_img() {
            return big_img;
        }

        public void setBig_img(String big_img) {
            this.big_img = big_img;
        }
    }
}
