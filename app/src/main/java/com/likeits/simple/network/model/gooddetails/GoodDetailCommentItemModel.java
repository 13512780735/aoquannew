package com.likeits.simple.network.model.gooddetails;

import com.likeits.simple.network.model.home.HomeMessage;

import java.util.List;

public class GoodDetailCommentItemModel extends HomeMessage{


    /**
     * params : {"num":"3"}
     * id : detail_comment
     * data : {"comment":{"count":"2","percent":50,"list":[{"nickname":"测**户","level":"3","content":"测试不错","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/jA3MSSdEEm18E81vmmU8mAD1aa73JM.png"],"createtime":"2019-01-05 14:32"},{"nickname":"用**6","level":"5","content":"测试评价内容&图片","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ZKUDvkaM3mzRkzr8nv3BBveB2v8uAV.png","http://hidsy.maimaitoo.com/attachment/images/1/2019/01/Qad5bE1k1DsSLw4eBDLSlBKSCSL55d.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png"],"createtime":"2019-01-05 13:56"}]}}
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
         * num : 3
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
         * comment : {"count":"2","percent":50,"list":[{"nickname":"测**户","level":"3","content":"测试不错","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/jA3MSSdEEm18E81vmmU8mAD1aa73JM.png"],"createtime":"2019-01-05 14:32"},{"nickname":"用**6","level":"5","content":"测试评价内容&图片","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ZKUDvkaM3mzRkzr8nv3BBveB2v8uAV.png","http://hidsy.maimaitoo.com/attachment/images/1/2019/01/Qad5bE1k1DsSLw4eBDLSlBKSCSL55d.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png"],"createtime":"2019-01-05 13:56"}]}
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
             * count : 2
             * percent : 50
             * list : [{"nickname":"测**户","level":"3","content":"测试不错","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/jA3MSSdEEm18E81vmmU8mAD1aa73JM.png"],"createtime":"2019-01-05 14:32"},{"nickname":"用**6","level":"5","content":"测试评价内容&图片","images":["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/ZKUDvkaM3mzRkzr8nv3BBveB2v8uAV.png","http://hidsy.maimaitoo.com/attachment/images/1/2019/01/Qad5bE1k1DsSLw4eBDLSlBKSCSL55d.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png"],"createtime":"2019-01-05 13:56"}]
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
                 * nickname : 测**户
                 * level : 3
                 * content : 测试不错
                 * images : ["http://hidsy.maimaitoo.com/attachment/images/1/2018/12/VLKrlcjCHn4zzk2lf7nxCkNnCbN2b7.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/WG0kY6l98l980GM88UyL8k88lIIT8Y.png","http://hidsy.maimaitoo.com/attachment/images/1/2018/12/jA3MSSdEEm18E81vmmU8mAD1aa73JM.png"]
                 * createtime : 2019-01-05 14:32
                 */

                private String nickname;
                private String level;
                private String content;
                private String createtime;
                private List<String> images;

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

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public List<String> getImages() {
                    return images;
                }

                public void setImages(List<String> images) {
                    this.images = images;
                }
            }
        }
    }
}
