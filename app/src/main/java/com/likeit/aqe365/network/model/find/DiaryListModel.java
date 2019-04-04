package com.likeit.aqe365.network.model.find;

import java.util.ArrayList;
import java.util.List;

public class DiaryListModel {

    /**
     * list : [{"id":"20","title":"11111","edittime":"2019-03-06","content":"asdasdasdasdasddas","views":"38","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qhHu53s6AsZWzWUu335huhH5uwG8Nu.png","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/S95RbjHJjh8E699avu9z8U49wZLQ8R.png"]},{"id":"1","title":"哈哈","edittime":"2019-03-06","content":"奶瓶龋最初在上颌乳切牙的唇面龈缘处出现白垩色斑点或带状脱矿，而后逐渐向下向旁边蔓延，侵蚀邻近的牙面形成环状龋，呈棕褐色，并最终发生牙冠折断，仅留下残根。\n 需要说明的是孩子牙齿脱矿，就需要使用护牙素，护牙素能够帮助重建牙釉质缺损失，降低牙本质敏感，为高龋齿风险和有特殊需要的人群提供专业牙齿保护，吞咽安全。\n 奶瓶龋的发生不仅使乳牙的切割功能大大降低，而且随着病变加重，会引起牙髓及牙根尖病变，这时孩子会感到剧烈疼痛或牙龈肿胀、流脓，严重的还会影响恒牙的发育。\n 让孩子抱着奶瓶，就去上床睡觉，几周，几个月下来就会这样，妈咪再不重视也不去医院治疗。。。\n 一旦因龋蚀严重无法治疗，而将乳牙过早拔除，就会引起恒牙萌出秩序错乱甚至恒牙不齐，给孩子的牙齿发育带来不良影响。因此，一旦发现孩子有奶瓶龋的迹象，应及早带孩子去医院诊治。\n 为预防龋齿，从宝宝1岁开始，就要逐渐减少使用奶瓶的次数，最晚不超过1岁半。戒断奶瓶时可改用鸭嘴杯代，之后再过渡到水杯。[EM13]","views":"0","images":null}]
     * total : 2
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
         * id : 20
         * title : 11111
         * edittime : 2019-03-06
         * content : asdasdasdasdasddas
         * views : 38
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/qhHu53s6AsZWzWUu335huhH5uwG8Nu.png","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/S95RbjHJjh8E699avu9z8U49wZLQ8R.png"]
         */

        private String id;
        private String title;
        private String edittime;
        private String content;
        private String diaryid;
        private String views;

        public String getDiaryid() {
            return diaryid;
        }

        public void setDiaryid(String diaryid) {
            this.diaryid = diaryid;
        }

        public List<String> images = new ArrayList<>();
        public boolean isShowAll = false;

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

        public String getEdittime() {
            return edittime;
        }

        public void setEdittime(String edittime) {
            this.edittime = edittime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
