package com.likeit.aqe365.network.model.find;

import java.util.List;

public class MoodDetailsModel {

    /**
     * post : {"id":"58","bid":"0","pid":"0","rpid":"0","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","nickname":"136xxxx0576","createtime":null,"images":["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/0S0cxU9c992bXsAQmISra2AIagLMB6X6.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/VTkx938cOcyjAGVANhNBsC9k9N4vgch1.jpg"],"title":"","content":"","lat":"","lng":"","views":"78","isuser":"0","iscollect":"0","memberid":"5184","city":"","replycount":"0","likenum":"2","islike":"0"}
     * postComment : [{"id":"65","bid":"0","rpid":"0","pid":"58","createtime":"2019-04-02","content":"资产重组洗发水法撒旦大叔大婶多","nickname":"永恒","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","parent":[{"id":"67","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"65","pid":"58","mpid":"66","nickname":"永恒","createtime":"2019-04-02","views":"0","content":"资产重组洗发水法撒旦大叔大婶多1","isgood":"0","reply_use":"永恒","likenum":"0"},{"id":"66","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"65","pid":"58","mpid":"0","nickname":"永恒","createtime":"2019-04-02","views":"0","content":"资产重组洗发水法撒旦大叔大婶多1","isgood":"0","reply_use":"永恒","likenum":"0"}],"isgood":"0","likenum":"0","goodcount":"0"},{"id":"62","bid":"0","rpid":"0","pid":"58","createtime":"2019-04-02","content":"asdadasdasdasd","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","parent":[{"id":"64","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"62","pid":"58","mpid":"63","nickname":"永恒","createtime":"2019-04-02","views":"0","content":"空间的哈萨克的哈速度","isgood":"0","reply_use":"136xxxx0576","likenum":"0"},{"id":"63","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","bid":"0","rpid":"62","pid":"58","mpid":"0","nickname":"136xxxx0576","createtime":"2019-04-02","views":"0","content":"sadfsadfasdfafds","isgood":"0","reply_use":"136xxxx0576","likenum":"0"}],"isgood":"0","likenum":"0","goodcount":"0"},{"id":"59","bid":"0","rpid":"0","pid":"58","createtime":"2019-04-01","content":"111111111","nickname":"136xxxx0576","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","parent":[{"id":"60","avatar":"http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png","bid":"0","rpid":"59","pid":"58","mpid":"0","nickname":"136xxxx0576","createtime":"2019-04-01","views":"0","content":"222222222","isgood":"1","reply_use":"136xxxx0576","likenum":"2"},{"id":"61","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"59","pid":"58","mpid":"60","nickname":"永恒","createtime":"2019-04-01","views":"0","content":"3333333333333333","isgood":"0","reply_use":"136xxxx0576","likenum":"1"}],"isgood":"1","likenum":"2","goodcount":"2"}]
     */

    private PostBean post;
    private List<PostCommentBean> postComment;

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }

    public List<PostCommentBean> getPostComment() {
        return postComment;
    }

    public void setPostComment(List<PostCommentBean> postComment) {
        this.postComment = postComment;
    }

    public static class PostBean {
        /**
         * id : 58
         * bid : 0
         * pid : 0
         * rpid : 0
         * avatar : http://wx.aqe365.com/attachment/images/1/2019/01/cthuo4Rtx5BH5z4G3TYhrGFhtBU4Xr.png
         * nickname : 136xxxx0576
         * createtime : null
         * images : ["http://aoquan.maimaitoo.com/attachment/images/1/2019/04/0S0cxU9c992bXsAQmISra2AIagLMB6X6.jpg","http://aoquan.maimaitoo.com/attachment/images/1/2019/04/VTkx938cOcyjAGVANhNBsC9k9N4vgch1.jpg"]
         * title :
         * content :
         * lat :
         * lng :
         * views : 78
         * isuser : 0
         * iscollect : 0
         * memberid : 5184
         * city :
         * replycount : 0
         * likenum : 2
         * islike : 0
         */

        private String id;
        private String bid;
        private String pid;
        private String rpid;
        private String avatar;
        private String nickname;
        private Object createtime;
        private String title;
        private String content;
        private String lat;
        private String lng;
        private String views;
        private String isuser;
        private String iscollect;
        private String memberid;
        private String city;
        private String replycount;
        private String likenum;
        private String islike;
        private String type;
        private String video;
        private String videoimage;
        private List<String> images;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVideoimage() {
            return videoimage;
        }

        public void setVideoimage(String videoimage) {
            this.videoimage = videoimage;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getRpid() {
            return rpid;
        }

        public void setRpid(String rpid) {
            this.rpid = rpid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
            this.createtime = createtime;
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

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getIsuser() {
            return isuser;
        }

        public void setIsuser(String isuser) {
            this.isuser = isuser;
        }

        public String getIscollect() {
            return iscollect;
        }

        public void setIscollect(String iscollect) {
            this.iscollect = iscollect;
        }

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
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

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class PostCommentBean {
        /**
         * id : 65
         * bid : 0
         * rpid : 0
         * pid : 58
         * createtime : 2019-04-02
         * content : 资产重组洗发水法撒旦大叔大婶多
         * nickname : 永恒
         * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
         * parent : [{"id":"67","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"65","pid":"58","mpid":"66","nickname":"永恒","createtime":"2019-04-02","views":"0","content":"资产重组洗发水法撒旦大叔大婶多1","isgood":"0","reply_use":"永恒","likenum":"0"},{"id":"66","avatar":"http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132","bid":"0","rpid":"65","pid":"58","mpid":"0","nickname":"永恒","createtime":"2019-04-02","views":"0","content":"资产重组洗发水法撒旦大叔大婶多1","isgood":"0","reply_use":"永恒","likenum":"0"}]
         * isgood : 0
         * likenum : 0
         * goodcount : 0
         */

        private String id;
        private String bid;
        private String rpid;
        private String pid;
        private String createtime;
        private String content;
        private String nickname;
        private String avatar;
        private String isgood;
        private String likenum;
        private String goodcount;
        private List<ParentBean> parent;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getRpid() {
            return rpid;
        }

        public void setRpid(String rpid) {
            this.rpid = rpid;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getGoodcount() {
            return goodcount;
        }

        public void setGoodcount(String goodcount) {
            this.goodcount = goodcount;
        }

        public List<ParentBean> getParent() {
            return parent;
        }

        public void setParent(List<ParentBean> parent) {
            this.parent = parent;
        }

        public static class ParentBean {
            /**
             * id : 67
             * avatar : http://thirdwx.qlogo.cn/mmopen/vi_32/r2qkcpIpK5pSmR03f6rV6bOeARJCvAKIrxhvVhEjtCMs6ygSlLUSx8SIThsGmg8Wg9fpOMzyOm4WzxdgHVKibeg/132
             * bid : 0
             * rpid : 65
             * pid : 58
             * mpid : 66
             * nickname : 永恒
             * createtime : 2019-04-02
             * views : 0
             * content : 资产重组洗发水法撒旦大叔大婶多1
             * isgood : 0
             * reply_use : 永恒
             * likenum : 0
             */

            private String id;
            private String avatar;
            private String bid;
            private String rpid;
            private String pid;
            private String mpid;
            private String nickname;
            private String createtime;
            private String views;
            private String content;
            private String isgood;
            private String reply_use;
            private String likenum;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getRpid() {
                return rpid;
            }

            public void setRpid(String rpid) {
                this.rpid = rpid;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getMpid() {
                return mpid;
            }

            public void setMpid(String mpid) {
                this.mpid = mpid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getIsgood() {
                return isgood;
            }

            public void setIsgood(String isgood) {
                this.isgood = isgood;
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
        }
    }
}
