package com.likeit.aqe365.network.model.find;

import java.util.List;

public class JournalDetailsModel {

    /**
     * journal : {"id":"132","diaryid":"101","title":"阿斯达四大","edittime":"2天前","content":"asdasdzasdzasdzxasdzxcasdzxczasdzxczx阿斯顿自行车自行","views":"35","nickname":"永恒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","memberid":"http://aoquan.maimaitoo.com/attachment/2239","iscollect":"1","likenum":"2","replycount":"7","islike":"1","city":"","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/46qE7ODh99Vr9zx8YptaUqvQPAkCPggx.jpg"],"isgoodnum":""}
     * journalComment : [{"id":"133","diaryid":"101","cid":"132","replycontent":"asdajlskdjalkjdlkasdjsdlnsldlaksd","replytime":"1天前","rcid":"0","journalcount":"0","images":null,"parent":[{"id":"139","cid":"132","diaryid":"101","mcid":"0","rcid":"133","replycontent":"爱神的箭阿卡丽圣诞节爱丽丝打开","replytime":"1天前","nickname":"永恒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","memberid":"2239","reply_use":"136xxxx0576","likenum":"0","isgood":"0"}],"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","memberid":"5184","isgood":"0","likenum":"0"},{"id":"134","diaryid":"101","cid":"132","replycontent":"asdasdasdasdsa","replytime":"1天前","rcid":"0","journalcount":"0","images":null,"parent":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","memberid":"5184","isgood":"0","likenum":"0"},{"id":"135","diaryid":"101","cid":"132","replycontent":"asdasdasdasd","replytime":"1天前","rcid":"0","journalcount":"0","images":null,"parent":null,"nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","memberid":"5184","isgood":"0","likenum":"0"}]
     */

    private JournalBean journal;
    private List<JournalCommentBean> journalComment;

    public JournalBean getJournal() {
        return journal;
    }

    public void setJournal(JournalBean journal) {
        this.journal = journal;
    }

    public List<JournalCommentBean> getJournalComment() {
        return journalComment;
    }

    public void setJournalComment(List<JournalCommentBean> journalComment) {
        this.journalComment = journalComment;
    }

    public static class JournalBean {
        /**
         * id : 132
         * diaryid : 101
         * title : 阿斯达四大
         * edittime : 2天前
         * content : asdasdzasdzasdzxasdzxcasdzxczasdzxczx阿斯顿自行车自行
         * views : 35
         * nickname : 永恒
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
         * memberid : http://aoquan.maimaitoo.com/attachment/2239
         * iscollect : 1
         * likenum : 2
         * replycount : 7
         * islike : 1
         * city :
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/46qE7ODh99Vr9zx8YptaUqvQPAkCPggx.jpg"]
         * isgoodnum :
         */

        private String id;
        private String diaryid;
        private String title;
        private String edittime;
        private String content;
        private String views;
        private String nickname;
        private String avatar;
        private String memberid;
        private String iscollect;
        private String likenum;
        private String replycount;
        private String islike;
        private String city;
        private String isgoodnum;
        private String isuser;
        private List<String> images;

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }

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

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
        }

        public String getIscollect() {
            return iscollect;
        }

        public void setIscollect(String iscollect) {
            this.iscollect = iscollect;
        }

        public String getLikenum() {
            return likenum;
        }

        public void setLikenum(String likenum) {
            this.likenum = likenum;
        }

        public String getReplycount() {
            return replycount;
        }

        public void setReplycount(String replycount) {
            this.replycount = replycount;
        }

        public String getIslike() {
            return islike;
        }

        public void setIslike(String islike) {
            this.islike = islike;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getIsgoodnum() {
            return isgoodnum;
        }

        public void setIsgoodnum(String isgoodnum) {
            this.isgoodnum = isgoodnum;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class JournalCommentBean {
        /**
         * id : 133
         * diaryid : 101
         * cid : 132
         * replycontent : asdajlskdjalkjdlkasdjsdlnsldlaksd
         * replytime : 1天前
         * rcid : 0
         * journalcount : 0
         * images : null
         * parent : [{"id":"139","cid":"132","diaryid":"101","mcid":"0","rcid":"133","replycontent":"爱神的箭阿卡丽圣诞节爱丽丝打开","replytime":"1天前","nickname":"永恒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","memberid":"2239","reply_use":"136xxxx0576","likenum":"0","isgood":"0"}]
         * nickname : 136xxxx0576
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * memberid : 5184
         * isgood : 0
         * likenum : 0
         */

        private String id;
        private String diaryid;
        private String cid;
        private String replycontent;
        private String replytime;
        private String rcid;
        private String journalcount;
        private Object images;
        private String nickname;
        private String avatar;
        private String memberid;
        private String isgood;
        private String likenum;
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

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getReplycontent() {
            return replycontent;
        }

        public void setReplycontent(String replycontent) {
            this.replycontent = replycontent;
        }

        public String getReplytime() {
            return replytime;
        }

        public void setReplytime(String replytime) {
            this.replytime = replytime;
        }

        public String getRcid() {
            return rcid;
        }

        public void setRcid(String rcid) {
            this.rcid = rcid;
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

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
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

        public List<ParentBean> getParent() {
            return parent;
        }

        public void setParent(List<ParentBean> parent) {
            this.parent = parent;
        }

        public static class ParentBean {
            /**
             * id : 139
             * cid : 132
             * diaryid : 101
             * mcid : 0
             * rcid : 133
             * replycontent : 爱神的箭阿卡丽圣诞节爱丽丝打开
             * replytime : 1天前
             * nickname : 永恒
             * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
             * memberid : 2239
             * reply_use : 136xxxx0576
             * likenum : 0
             * isgood : 0
             */

            private String id;
            private String cid;
            private String diaryid;
            private String mcid;
            private String rcid;
            private String replycontent;
            private String replytime;
            private String nickname;
            private String avatar;
            private String memberid;
            private String reply_use;
            private String likenum;
            private String isgood;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getDiaryid() {
                return diaryid;
            }

            public void setDiaryid(String diaryid) {
                this.diaryid = diaryid;
            }

            public String getMcid() {
                return mcid;
            }

            public void setMcid(String mcid) {
                this.mcid = mcid;
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

            public String getReplytime() {
                return replytime;
            }

            public void setReplytime(String replytime) {
                this.replytime = replytime;
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
        }
    }
}
