package com.likeit.aqe365.network.model.find;

import java.util.ArrayList;
import java.util.List;

public class DiarydetailsModel {

    /**
     * diary : {"booktitle":"牙科吸管","hospital":"22","subjects":"5","server":"98","addtime":"2019-03-13","city":"中山市","image_text":"","recovery_image":"http://aoquan.maimaitoo.com/attachment/images/1/2019/03/m1p5griRH2vJT2hoqVWeJe8TZKcqe84q.jpg","recovery_num":4,"image_text_num":0,"isuser":"1","replycount":"6","likenum":"5","islike":"0","iscollect":"0","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","memberid":"5184"}
     * journal : [{"id":"121","title":"补补补不不不不不不不不不不不不不不不","content":"哈哈刚回国后哈哈","edittime":"1553482044","type":"0","recoverytime":"1553443200","day":"第12天","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/9ecMZwMU16QSP6xzYN7lhZ7IhYZITJDu.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/JHyTqBRlrqIW4ZwbnldsQQU6lEBWlKQB.jpg"],"num":"第2篇日记","like":3},{"id":"120","title":"1111111111111","content":"就翻江倒海","edittime":"1553482043","type":"0","recoverytime":"1553443200","day":"第12天","images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/m1p5griRH2vJT2hoqVWeJe8TZKcqe84q.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/H1btbC3L66BdnT17HwzvAA5Mmg2nDm68.jpg"],"num":"第1篇日记","like":0}]
     * comment : [{"id":"1","diaryid":"4","nickname":"Mr.zou ","avatar":"http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8MTE29PFDREniaB79P82eXibzqN9thOicW42Ik6UxqHYgXhsicBxWBb6TMzic9BmNJsMhRVpctJ7JhE9tMhqgBOqavl/132","replytime":"2019-03-07","journalcount":"2","images":null,"parent":[{"id":"2","diaryid":"4","rcid":"1","replycontent":"嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-07","mcid":"0","memberid":"2196","reply_use":"","likenum":"0","isgood":"0"},{"id":"6","diaryid":"4","rcid":"1","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","mcid":"2","memberid":"5184","reply_use":"","likenum":"0","isgood":"0"}],"isgood":"0","likenum":"0","memberid":"2189","rcid":"0","mcid":"0","replycontent":"哈哈哈哈哈哈哈哈哈哈哈哈哈哈"},{"id":"2","diaryid":"4","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-07","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"0","memberid":"2196","rcid":"1","mcid":"0","replycontent":"嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓"},{"id":"3","diaryid":"4","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"0","memberid":"5184","rcid":"0","mcid":"0","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"},{"id":"4","diaryid":"4","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"0","memberid":"5184","rcid":"0","mcid":"0","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"},{"id":"5","diaryid":"4","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"0","memberid":"5184","rcid":"0","mcid":"0","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"},{"id":"6","diaryid":"4","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"0","memberid":"5184","rcid":"1","mcid":"2","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"},{"id":"7","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","journalcount":"3","images":null,"parent":[{"id":"8","diaryid":"102","rcid":"7","replycontent":"妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈买","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-15","mcid":"0","memberid":"2196","reply_use":"","likenum":"1","isgood":"0"},{"id":"10","diaryid":"102","rcid":"7","replycontent":"dalksdjfsdknfl,.sdfnlskdfdfsf","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"21小时前","mcid":"0","memberid":"5184","reply_use":"","likenum":"1","isgood":"0"},{"id":"11","diaryid":"102","rcid":"7","replycontent":"hahahahahahhahahahahha","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"21小时前","mcid":"10","memberid":"5184","reply_use":"","likenum":"0","isgood":"0"}],"isgood":"0","likenum":"1","memberid":"5184","rcid":"0","mcid":"0","replycontent":"擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦"},{"id":"8","diaryid":"102","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-15","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"1","memberid":"2196","rcid":"7","mcid":"0","replycontent":"妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈妈买"},{"id":"9","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"21小时前","journalcount":"1","images":null,"parent":[{"id":"12","diaryid":"102","rcid":"9","replycontent":"男男女女女女女女女女女女女女女女女","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"21小时前","mcid":"0","memberid":"5184","reply_use":"","likenum":"0","isgood":"0"}],"isgood":"0","likenum":"1","memberid":"5184","rcid":"0","mcid":"0","replycontent":"asdASJKdZxkJZHxzchznxcbzksdfhfas"},{"id":"10","diaryid":"102","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"21小时前","journalcount":"0","images":null,"parent":null,"isgood":"0","likenum":"1","memberid":"5184","rcid":"7","mcid":"0","replycontent":"dalksdjfsdknfl,.sdfnlskdfdfsf"}]
     * isgoodnum :
     * commentnum : 12
     */

    private DiaryBean diary;
    private String isgoodnum;
    private String commentnum;
    private String journaltotal;
    private List<JournalBean> journal;
    private List<CommentBean> comment;
    private Hospital hospital;

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getJournaltotal() {
        return journaltotal;
    }

    public void setJournaltotal(String journaltotal) {
        this.journaltotal = journaltotal;
    }

    public DiaryBean getDiary() {
        return diary;
    }

    public void setDiary(DiaryBean diary) {
        this.diary = diary;
    }

    public String getIsgoodnum() {
        return isgoodnum;
    }

    public void setIsgoodnum(String isgoodnum) {
        this.isgoodnum = isgoodnum;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public List<JournalBean> getJournal() {
        return journal;
    }

    public void setJournal(List<JournalBean> journal) {
        this.journal = journal;
    }

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }
    public static class Hospital{
        private String id;
        private String name;
        private String logo;
        private String title;
        private String linkurl;
        private String weburl;
        private String marketprice;

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }
    }

    public static class DiaryBean {
        /**
         * booktitle : 牙科吸管
         * hospital : 22
         * subjects : 5
         * server : 98
         * addtime : 2019-03-13
         * city : 中山市
         * image_text :
         * recovery_image : http://aoquan.maimaitoo.com/attachment/images/1/2019/03/m1p5griRH2vJT2hoqVWeJe8TZKcqe84q.jpg
         * recovery_num : 4
         * image_text_num : 0
         * isuser : 1
         * replycount : 6
         * likenum : 5
         * islike : 0
         * iscollect : 0
         * nickname : 136xxxx0576
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * memberid : 5184
         */
        private String id;
        private String type;
        private String booktitle;
        private String hospital;
        private String subjects;
        private String server;
        private String addtime;
        private String city;
        private String image_text;
        private String recovery_image;
        private int recovery_num;
        private int image_text_num;
        private String isuser;
        private String replycount;
        private String likenum;
        private String islike;
        private String iscollect;
        private String nickname;
        private String avatar;
        private String memberid;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBooktitle() {
            return booktitle;
        }

        public void setBooktitle(String booktitle) {
            this.booktitle = booktitle;
        }

        public String getHospital() {
            return hospital;
        }

        public void setHospital(String hospital) {
            this.hospital = hospital;
        }

        public String getSubjects() {
            return subjects;
        }

        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getImage_text() {
            return image_text;
        }

        public void setImage_text(String image_text) {
            this.image_text = image_text;
        }

        public String getRecovery_image() {
            return recovery_image;
        }

        public void setRecovery_image(String recovery_image) {
            this.recovery_image = recovery_image;
        }

        public int getRecovery_num() {
            return recovery_num;
        }

        public void setRecovery_num(int recovery_num) {
            this.recovery_num = recovery_num;
        }

        public int getImage_text_num() {
            return image_text_num;
        }

        public void setImage_text_num(int image_text_num) {
            this.image_text_num = image_text_num;
        }

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }

        public String getReplycount() {
            return replycount;
        }

        public void setReplycount(String replycount) {
            this.replycount = replycount;
        }

        public String getLikenum() {
            return likenum;
        }

        public void setLikenum(String likenum) {
            this.likenum = likenum;
        }

        public String getIslike() {
            return islike;
        }

        public void setIslike(String islike) {
            this.islike = islike;
        }

        public String getIscollect() {
            return iscollect;
        }

        public void setIscollect(String iscollect) {
            this.iscollect = iscollect;
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
    }

    public static class JournalBean {
        /**
         * id : 121
         * title : 补补补不不不不不不不不不不不不不不不
         * content : 哈哈刚回国后哈哈
         * edittime : 1553482044
         * type : 0
         * recoverytime : 1553443200
         * day : 第12天
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/03/9ecMZwMU16QSP6xzYN7lhZ7IhYZITJDu.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/03/JHyTqBRlrqIW4ZwbnldsQQU6lEBWlKQB.jpg"]
         * num : 第2篇日记
         * like : 3
         */

        private String id;
        private String title;
        private String content;
        private String edittime;
        private String type;
        private String recoverytime;
        private String day;
        private String num;
        private int likenum;
        private String islike;
        public List<String> images = new ArrayList<>();
        public boolean isShowAll = false;
        public String getIslike() {
            return islike;
        }

        public void setIslike(String islike) {
            this.islike = islike;
        }


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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEdittime() {
            return edittime;
        }

        public void setEdittime(String edittime) {
            this.edittime = edittime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRecoverytime() {
            return recoverytime;
        }

        public void setRecoverytime(String recoverytime) {
            this.recoverytime = recoverytime;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public int getLikenum() {
            return likenum;
        }

        public void setLikenum(int like) {
            this.likenum = likenum;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class CommentBean {
        /**
         * id : 1
         * diaryid : 4
         * nickname : Mr.zou
         * avatar : http://thirdwx.qlogo.cn/mmopen/gWicbXPiajJn8MTE29PFDREniaB79P82eXibzqN9thOicW42Ik6UxqHYgXhsicBxWBb6TMzic9BmNJsMhRVpctJ7JhE9tMhqgBOqavl/132
         * replytime : 2019-03-07
         * journalcount : 2
         * images : null
         * parent : [{"id":"2","diaryid":"4","rcid":"1","replycontent":"嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓","nickname":"震生","avatar":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132","replytime":"2019-03-07","mcid":"0","memberid":"2196","reply_use":"","likenum":"0","isgood":"0"},{"id":"6","diaryid":"4","rcid":"1","replycontent":"你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","replytime":"2019-03-15","mcid":"2","memberid":"5184","reply_use":"","likenum":"0","isgood":"0"}]
         * isgood : 0
         * likenum : 0
         * memberid : 2189
         * rcid : 0
         * mcid : 0
         * replycontent : 哈哈哈哈哈哈哈哈哈哈哈哈哈哈
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
        private String mcid;
        private String replycontent;
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

        public String getMcid() {
            return mcid;
        }

        public void setMcid(String mcid) {
            this.mcid = mcid;
        }

        public String getReplycontent() {
            return replycontent;
        }

        public void setReplycontent(String replycontent) {
            this.replycontent = replycontent;
        }

        public List<ParentBean> getParent() {
            return parent;
        }

        public void setParent(List<ParentBean> parent) {
            this.parent = parent;
        }

        public static class ParentBean {
            /**
             * id : 2
             * diaryid : 4
             * rcid : 1
             * replycontent : 嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓嚓
             * nickname : 震生
             * avatar : http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCkztOeJSJZkaP1gRfpiaIUzoOctriayHG39ibnibA7FCA6EYzTzBL9houHL2OK65n8EwwRlkzeoAUWricKcVVHCVgqHhu32rgXOuHg/132
             * replytime : 2019-03-07
             * mcid : 0
             * memberid : 2196
             * reply_use :
             * likenum : 0
             * isgood : 0
             */

            private String id;
            private String diaryid;
            private String rcid;
            private String replycontent;
            private String nickname;
            private String avatar;
            private String replytime;
            private String mcid;
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

            public String getDiaryid() {
                return diaryid;
            }

            public void setDiaryid(String diaryid) {
                this.diaryid = diaryid;
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

            public String getMcid() {
                return mcid;
            }

            public void setMcid(String mcid) {
                this.mcid = mcid;
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
