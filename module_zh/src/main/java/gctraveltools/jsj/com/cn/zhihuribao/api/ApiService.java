package gctraveltools.jsj.com.cn.zhihuribao.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API 管理器服务
 */
public interface ApiService {
    /**
     * 知乎列表
     */
    @GET("news/latest")
    Flowable<String> fetchNetworkData();

    /**
     * 知乎新闻详情
     */
    @GET("news/{newsId}")
    Flowable<String> fetchNetworkData(@Path("newsId") String newsId);

    /**
     * 知乎评论列表
     * 8997528/long-comments
     */
    @GET("story/{newsId}/long-comments")
    Flowable<String> getCommentList(@Path("newsId") String newsId);

}
