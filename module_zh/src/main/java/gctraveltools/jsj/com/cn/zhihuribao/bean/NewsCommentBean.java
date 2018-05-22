package gctraveltools.jsj.com.cn.zhihuribao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	15:44	    刘泽			    新增 类
 * 2017/12/28	15:44	    刘泽			    增加yyy属性
 */

public class NewsCommentBean {


    /**
     * comments : [{"author":"巨型黑娃儿","content":"也不算逻辑问题。其实小时候刚刚听说这个玩意的时候我也奇...","avatar":"http://pic3.zhimg.com/4131a3385c748c9e2d02ab80e29a0c52_im.jpg","time":1479706360,"reply_to":{"content":"第二个机灵抖的还是有逻辑问题，不该说忘了，应该说没喝过啊我也不知道","status":0,"id":27275308,"author":"2233155495"},"id":27276057,"likes":2},"..."]
     */

    @SerializedName("comments")
    private List<CommentsEntity> comments;

    public void setComments(List<CommentsEntity> comments) {
        this.comments = comments;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public static class CommentsEntity {
        /**
         * author : 巨型黑娃儿
         * content : 也不算逻辑问题。其实小时候刚刚听说这个玩意的时候我也奇...
         * avatar : http://pic3.zhimg.com/4131a3385c748c9e2d02ab80e29a0c52_im.jpg
         * time : 1479706360
         * reply_to : {"content":"第二个机灵抖的还是有逻辑问题，不该说忘了，应该说没喝过啊我也不知道","status":0,"id":27275308,"author":"2233155495"}
         * id : 27276057
         * likes : 2
         */

        @SerializedName("author")
        private String author;
        @SerializedName("content")
        private String content;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("time")
        private int time;
        @SerializedName("reply_to")
        private ReplyToEntity replyTo;
        @SerializedName("id")
        private int id;
        @SerializedName("likes")
        private int likes;

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setReplyTo(ReplyToEntity replyTo) {
            this.replyTo = replyTo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public String getAvatar() {
            return avatar;
        }

        public int getTime() {
            return time;
        }

        public ReplyToEntity getReplyTo() {
            return replyTo;
        }

        public int getId() {
            return id;
        }

        public int getLikes() {
            return likes;
        }

        public static class ReplyToEntity {
            /**
             * content : 第二个机灵抖的还是有逻辑问题，不该说忘了，应该说没喝过啊我也不知道
             * status : 0
             * id : 27275308
             * author : 2233155495
             */

            @SerializedName("content")
            private String content;
            @SerializedName("status")
            private int status;
            @SerializedName("id")
            private int id;
            @SerializedName("author")
            private String author;

            public void setContent(String content) {
                this.content = content;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public int getStatus() {
                return status;
            }

            public int getId() {
                return id;
            }

            public String getAuthor() {
                return author;
            }
        }
    }
}
