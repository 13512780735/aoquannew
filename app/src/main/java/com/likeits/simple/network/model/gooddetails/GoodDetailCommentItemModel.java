package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailCommentItemModel extends HomeMessage{


    /**
     * params : {"num":"2"}
     * id : detail_comment
     * data : {"comment":{"count":"3","percent":66,"list":[{"nickname":"1**3","level":"5","content":"花样百出苛","images":null,"createtime":"2018-12-18 11:45"},{"nickname":"花**出","level":"5","content":"asd花样百出","images":null,"createtime":"2018-12-18 11:41"}]}}
     */

    private ParamsBean params;
    private String id;
    private DataBean data;

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

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

    public static class ParamsBean {
        /**
         * num : 2
         */

        private String num;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }

    public static class DataBean {
        /**
         * comment : {"count":"3","percent":66,"list":[{"nickname":"1**3","level":"5","content":"花样百出苛","images":null,"createtime":"2018-12-18 11:45"},{"nickname":"花**出","level":"5","content":"asd花样百出","images":null,"createtime":"2018-12-18 11:41"}]}
         */

        private CommentBean comment;

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public static class CommentBean {
            /**
             * count : 3
             * percent : 66
             * list : [{"nickname":"1**3","level":"5","content":"花样百出苛","images":null,"createtime":"2018-12-18 11:45"},{"nickname":"花**出","level":"5","content":"asd花样百出","images":null,"createtime":"2018-12-18 11:41"}]
             */

            private String count;
            private int percent;
            private List<ListBean> list;

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public int getPercent() {
                return percent;
            }

            public void setPercent(int percent) {
                this.percent = percent;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * nickname : 1**3
                 * level : 5
                 * content : 花样百出苛
                 * images : null
                 * createtime : 2018-12-18 11:45
                 */

                private String nickname;
                private String level;
                private String content;
                private Object images;
                private String createtime;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public Object getImages() {
                    return images;
                }

                public void setImages(Object images) {
                    this.images = images;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }
            }
        }
    }
}
