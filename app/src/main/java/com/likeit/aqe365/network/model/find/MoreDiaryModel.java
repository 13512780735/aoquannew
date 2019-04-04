package com.likeit.aqe365.network.model.find;

import java.util.List;

public class MoreDiaryModel {

    /**
     * list : [{"id":"7","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"3","images":null,"parent":[{"id":"8","diaryid":"102","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-15","mdid":"0","memberid":"2196","reply_use":"","likenum":"1","isgood":"0","rcid":"7","replycontent":"妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈买"},{"id":"10","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","mdid":"0","memberid":"5184","reply_use":"","likenum":"1","isgood":"0","rcid":"7","replycontent":"dalksdjfsdknfl,.sdfnlskdfdfsf"},{"id":"11","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","mdid":"10","memberid":"5184","reply_use":"136xxxx0576","likenum":"0","isgood":"0","rcid":"7","replycontent":"hahahahahahhahahahahha"}],"isgood":"0","likenum":"1","memberid":"5184","rcid":"0","replycontent":"擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦","mcid":"0"},{"id":"9","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","journalcount":"1","images":null,"parent":[{"id":"12","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","mdid":"0","memberid":"5184","reply_use":"","likenum":"0","isgood":"0","rcid":"9","replycontent":"男男女女女女女女女女女女女女女女女"}],"isgood":"0","likenum":"1","memberid":"5184","rcid":"0","replycontent":"asdASJKdZxkJZHxzchznxcbzksdfhfas","mcid":"0"}]
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
         * id : 7
         * diaryid : 102
         * nickname : 136xxxx0576
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * replytime : 2019-03-15
         * journalcount : 3
         * images : null
         * parent : [{"id":"8","diaryid":"102","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-15","mdid":"0","memberid":"2196","reply_use":"","likenum":"1","isgood":"0","rcid":"7","replycontent":"妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈买"},{"id":"10","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","mdid":"0","memberid":"5184","reply_use":"","likenum":"1","isgood":"0","rcid":"7","replycontent":"dalksdjfsdknfl,.sdfnlskdfdfsf"},{"id":"11","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"1天前","mdid":"10","memberid":"5184","reply_use":"136xxxx0576","likenum":"0","isgood":"0","rcid":"7","replycontent":"hahahahahahhahahahahha"}]
         * isgood : 0
         * likenum : 1
         * memberid : 5184
         * rcid : 0
         * replycontent : 擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦
         * mcid : 0
         */

        private String id;
        private String diaryid;
        private String nickname;
        private String avatar;
        private String replytime;
        private String journalcount;
        private Object images;
        private String isgood;
        private String likenum;
        private String memberid;
        private String rcid;
        private String replycontent;
        private String mcid;
        private List<ParentBean> parent;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDiaryid() {
            return diaryid;
        }

        public void setDiaryid(String diaryid) {
            this.diaryid = diaryid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getReplytime() {
            return replytime;
        }

        public void setReplytime(String replytime) {
            this.replytime = replytime;
        }

        public String getJournalcount() {
            return journalcount;
        }

        public void setJournalcount(String journalcount) {
            this.journalcount = journalcount;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getIsgood() {
            return isgood;
        }

        public void setIsgood(String isgood) {
            this.isgood = isgood;
        }

        public String getLikenum() {
            return likenum;
        }

        public void setLikenum(String likenum) {
            this.likenum = likenum;
        }

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
        }

        public String getRcid() {
            return rcid;
        }

        public void setRcid(String rcid) {
            this.rcid = rcid;
        }

        public String getReplycontent() {
            return replycontent;
        }

        public void setReplycontent(String replycontent) {
            this.replycontent = replycontent;
        }

        public String getMcid() {
            return mcid;
        }

        public void setMcid(String mcid) {
            this.mcid = mcid;
        }

        public List<ParentBean> getParent() {
            return parent;
        }

        public void setParent(List<ParentBean> parent) {
            this.parent = parent;
        }

        public static class ParentBean {
            /**
             * id : 8
             * diaryid : 102
             * nickname : 震生
             * avatar : http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132
             * replytime : 2019-03-15
             * mdid : 0
             * memberid : 2196
             * reply_use :
             * likenum : 1
             * isgood : 0
             * rcid : 7
             * replycontent : 妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈买
             */

            private String id;
            private String diaryid;
            private String nickname;
            private String avatar;
            private String replytime;
            private String mdid;
            private String memberid;
            private String reply_use;
            private String likenum;
            private String isgood;
            private String rcid;
            private String replycontent;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDiaryid() {
                return diaryid;
            }

            public void setDiaryid(String diaryid) {
                this.diaryid = diaryid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getReplytime() {
                return replytime;
            }

            public void setReplytime(String replytime) {
                this.replytime = replytime;
            }

            public String getMdid() {
                return mdid;
            }

            public void setMdid(String mdid) {
                this.mdid = mdid;
            }

            public String getMemberid() {
                return memberid;
            }

            public void setMemberid(String memberid) {
                this.memberid = memberid;
            }

            public String getReply_use() {
                return reply_use;
            }

            public void setReply_use(String reply_use) {
                this.reply_use = reply_use;
            }

            public String getLikenum() {
                return likenum;
            }

            public void setLikenum(String likenum) {
                this.likenum = likenum;
            }

            public String getIsgood() {
                return isgood;
            }

            public void setIsgood(String isgood) {
                this.isgood = isgood;
            }

            public String getRcid() {
                return rcid;
            }

            public void setRcid(String rcid) {
                this.rcid = rcid;
            }

            public String getReplycontent() {
                return replycontent;
            }

            public void setReplycontent(String replycontent) {
                this.replycontent = replycontent;
            }
        }
    }
}
