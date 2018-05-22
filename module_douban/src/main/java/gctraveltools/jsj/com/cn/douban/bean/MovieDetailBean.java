package gctraveltools.jsj.com.cn.douban.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/1/3	14:39	    刘泽			    新增 类
 * 2018/1/3	14:39	    刘泽			    增加yyy属性
 */

public class MovieDetailBean implements Serializable {


    /**
     * aka : ["前任3","前任攻略3","前任3：颜值大作战","The Ex-File: The Return of the Exes"]
     * alt : https://movie.douban.com/subject/26662193/
     * casts : [{"alt":"https://movie.douban.com/celebrity/1275667/","avatars":{"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg"},"id":"1275667","name":"韩庚"},{"alt":"https://movie.douban.com/celebrity/1275564/","avatars":{"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1366015827.84.jpg"},"id":"1275564","name":"郑恺"},{"alt":"https://movie.douban.com/celebrity/1342252/","avatars":{"large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg","small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1408089064.98.jpg"},"id":"1342252","name":"于文文"},{"alt":"https://movie.douban.com/celebrity/1376370/","avatars":{"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501850512.53.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501850512.53.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1501850512.53.jpg"},"id":"1376370","name":"曾梦雪"}]
     * collect_count : 29148
     * comments_count : 14873
     * countries : ["中国大陆"]
     * directors : [{"alt":"https://movie.douban.com/celebrity/1332171/","avatars":{"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg"},"id":"1332171","name":"田羽生"}]
     * douban_site :
     * genres : ["喜剧","爱情"]
     * id : 26662193
     * images : {"large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg","small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg"}
     * mobile_url : https://movie.douban.com/subject/26662193/mobile
     * original_title : 前任3：再见前任
     * rating : {"average":6.2,"max":10,"min":0,"stars":"30"}
     * ratings_count : 28039
     * reviews_count : 1015
     * schedule_url : https://movie.douban.com/subject/26662193/cinema/
     * share_url : http://m.douban.com/movie/subject/26662193
     * subtype : movie
     * summary : 一对好基友孟云（韩庚 饰）和余飞（郑恺 饰）跟女友都因为一点小事宣告分手，并且“拒绝挽回，死不认错”。两人在夜店、派对与交友软件上放飞人生第二春，大肆庆祝“黄金单身期”，从而引发了一系列好笑的故事。孟云与女友同甘共苦却难逃“五年之痒”，余飞与女友则棋逢敌手相爱相杀无绝期。然而现实的“打脸”却来得猝不及防：一对推拉纠结零往来，一对纠缠互怼全交代。两对恋人都将面对最终的选择：是再次相见？还是再也不见？
     * title : 前任3：再见前任
     * wish_count : 9550
     * year : 2017
     */

    @SerializedName("alt")
    private String alt;
    @SerializedName("collect_count")
    private int collectCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("douban_site")
    private String doubanSite;
    @SerializedName("id")
    private String id;
    @SerializedName("images")
    private ImagesEntity images;
    @SerializedName("mobile_url")
    private String mobileUrl;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("rating")
    private RatingEntity rating;
    @SerializedName("ratings_count")
    private int ratingsCount;
    @SerializedName("reviews_count")
    private int reviewsCount;
    @SerializedName("schedule_url")
    private String scheduleUrl;
    @SerializedName("share_url")
    private String shareUrl;  @SerializedName("pubdates ")
    private String pubdates ;
    @SerializedName("subtype")
    private String subtype;
    @SerializedName("summary")
    private String summary;
    @SerializedName("title")
    private String title;
    @SerializedName("wish_count")
    private int wishCount;
    @SerializedName("year")
    private String year;
    @SerializedName("aka")
    private List<String> aka;
    @SerializedName("casts")
    private List<CastsEntity> casts;
    @SerializedName("countries")
    private List<String> countries;
    @SerializedName("directors")
    private List<DirectorsEntity> directors;
    @SerializedName("genres")
    private List<String> genres;
    @SerializedName("durations")
    private List<String> durations;

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public String getPubdates() {
        return pubdates;
    }

    public void setPubdates(String pubdates) {
        this.pubdates = pubdates;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public void setDoubanSite(String doubanSite) {
        this.doubanSite = doubanSite;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImages(ImagesEntity images) {
        this.images = images;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWishCount(int wishCount) {
        this.wishCount = wishCount;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public void setCasts(List<CastsEntity> casts) {
        this.casts = casts;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void setDirectors(List<DirectorsEntity> directors) {
        this.directors = directors;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getAlt() {
        return alt;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public String getDoubanSite() {
        return doubanSite;
    }

    public String getId() {
        return id;
    }

    public ImagesEntity getImages() {
        return images;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public RatingEntity getRating() {
        return rating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public int getWishCount() {
        return wishCount;
    }

    public String getYear() {
        return year;
    }

    public List<String> getAka() {
        return aka;
    }

    public List<CastsEntity> getCasts() {
        return casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<DirectorsEntity> getDirectors() {
        return directors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static class ImagesEntity {
        /**
         * large : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
         * medium : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
         * small : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2508926717.jpg
         */

        @SerializedName("large")
        private String large;
        @SerializedName("medium")
        private String medium;
        @SerializedName("small")
        private String small;

        public void setLarge(String large) {
            this.large = large;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public String getMedium() {
            return medium;
        }

        public String getSmall() {
            return small;
        }
    }

    public static class RatingEntity {
        /**
         * average : 6.2
         * max : 10
         * min : 0
         * stars : 30
         */

        @SerializedName("average")
        private double average;
        @SerializedName("max")
        private int max;
        @SerializedName("min")
        private int min;
        @SerializedName("stars")
        private String stars;

        public void setAverage(double average) {
            this.average = average;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public double getAverage() {
            return average;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }

        public String getStars() {
            return stars;
        }
    }

    public static class CastsEntity {
        /**
         * alt : https://movie.douban.com/celebrity/1275667/
         * avatars : {"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg"}
         * id : 1275667
         * name : 韩庚
         */

        @SerializedName("alt")
        private String alt;
        @SerializedName("avatars")
        private AvatarsEntity avatars;
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setAvatars(AvatarsEntity avatars) {
            this.avatars = avatars;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public AvatarsEntity getAvatars() {
            return avatars;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static class AvatarsEntity {
            /**
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p14025.jpg
             */

            @SerializedName("large")
            private String large;
            @SerializedName("medium")
            private String medium;
            @SerializedName("small")
            private String small;

            public void setLarge(String large) {
                this.large = large;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }

            public String getSmall() {
                return small;
            }
        }
    }

    public static class DirectorsEntity {
        /**
         * alt : https://movie.douban.com/celebrity/1332171/
         * avatars : {"large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg","small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg"}
         * id : 1332171
         * name : 田羽生
         */

        @SerializedName("alt")
        private String alt;
        @SerializedName("avatars")
        private AvatarsEntity avatars;
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public void setAvatars(AvatarsEntity avatars) {
            this.avatars = avatars;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlt() {
            return alt;
        }

        public AvatarsEntity getAvatars() {
            return avatars;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static class AvatarsEntity {
            /**
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391439365.41.jpg
             */

            @SerializedName("large")
            private String large;
            @SerializedName("medium")
            private String medium;
            @SerializedName("small")
            private String small;

            public void setLarge(String large) {
                this.large = large;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public String getMedium() {
                return medium;
            }

            public String getSmall() {
                return small;
            }
        }
    }
}
