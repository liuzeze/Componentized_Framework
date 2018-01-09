package gctraveltools.jsj.com.cn.coremodellib.http.api;


import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieListBean;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.ZRequest;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.ZResponse;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * API 管理器服务
 */
public interface ApiService {
    /**
     * @param input
     */
    @POST(" ")
    @Headers({"Accept: application/x-protobuf",
            "Content-Type: application/x-protobuf",
            "Cache-Control: no-cache"})
    Flowable<ZResponse> fetchNetworkData(@Body ZRequest input);

    /**
     * 知乎列表
     */
    @GET("latest")
    Flowable<String> fetchNetworkData();

    /**
     * 知乎新闻详情
     */
    @GET("{newsId}")
    Flowable<String> fetchNetworkData(@Path("newsId") String newsId);

    /**
     * 知乎评论列表
     * 8997528/long-comments
     */
    @GET("{newsId}/long-comments")
    Flowable<String> getCommentList(@Path("newsId") String newsId);

    /**
     * 电影热映电影列表
     * 8997528/long-comments
     *
     * @param path
     */
    @GET("v2/movie/{pathtype}")
    Flowable<MovieListBean> getMoviewList(@Path("pathtype") String path);

    /**
     * 电影热映电影详情
     * 8997528/long-comments
     */
    @GET("v2/movie/subject/{newsId}")
    Flowable<MovieDetailBean> getMoviewDetail(@Path("newsId") String newsId);

}
