package gctraveltools.jsj.com.cn.zhihuribao.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	11:32	    刘泽			    新增 类
 * 2017/12/28	11:32	    刘泽			    增加yyy属性
 */

public class NewsBean implements Serializable {


    /**
     * date : 20140523
     * stories : [{"title":"中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）","ga_prefix":"052321","images":["http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"],"type":0,"id":3930445},"..."]
     * top_stories : [{"title":"商场和很多人家里，竹制家具越来越多（多图）","image":"http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg","ga_prefix":"052315","type":0,"id":3930883},"..."]
     */

    @SerializedName("date")
    private String date;
    @SerializedName("stories")
    private List<StoriesEntity> stories;
    @SerializedName("top_stories")
    private List<TopStoriesEntity> topStories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setTopStories(List<TopStoriesEntity> topStories) {
        this.topStories = topStories;
    }

    public String getDate() {
        return date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public List<TopStoriesEntity> getTopStories() {
        return topStories;
    }

    public static class StoriesEntity {
        /**
         * title : 中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）
         * ga_prefix : 052321
         * images : ["http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"]
         * type : 0
         * id : 3930445
         */

        @SerializedName("title")
        private String title;
        @SerializedName("ga_prefix")
        private String gaPrefix;
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;
        @SerializedName("images")
        private List<String> images;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGaPrefix(String gaPrefix) {
            this.gaPrefix = gaPrefix;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public String getGaPrefix() {
            return gaPrefix;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public List<String> getImages() {
            return images;
        }


        @Override
        public String toString() {
            return "StoriesEntity{" +
                    "title='" + title + '\'' +
                    ", gaPrefix='" + gaPrefix + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", images=" + images +
                    '}';
        }
    }

    public static class TopStoriesEntity {
        /**
         * title : 商场和很多人家里，竹制家具越来越多（多图）
         * image : http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg
         * ga_prefix : 052315
         * type : 0
         * id : 3930883
         */

        @SerializedName("title")
        private String title;
        @SerializedName("image")
        private String image;
        @SerializedName("ga_prefix")
        private String gaPrefix;
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setGaPrefix(String gaPrefix) {
            this.gaPrefix = gaPrefix;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getGaPrefix() {
            return gaPrefix;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "TopStoriesEntity{" +
                    "title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    ", gaPrefix='" + gaPrefix + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", topStories=" + topStories +
                '}';
    }
}
