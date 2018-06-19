package gctraveltools.jsj.com.cn.zhihuribao.api;


import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import static gctraveltools.jsj.com.cn.commonlib.constant.GlobalConstants.DOMAIN_NAME_HEADER;
import static gctraveltools.jsj.com.cn.commonlib.constant.GlobalConstants.DOUBAN_DOMAIN_NAME;

/**
 * API 管理器服务
 */
public interface ApiService {
    /**
     * 知乎列表
     */
    @Headers({DOMAIN_NAME_HEADER + DOUBAN_DOMAIN_NAME})
    @GET("news/latest")
    Flowable<String> getNewLists();

    /**
     * 知乎新闻详情
     */
    @Headers({DOMAIN_NAME_HEADER + DOUBAN_DOMAIN_NAME})
    @GET("news/{newsId}")
    Flowable<String> fetchNetworkData(@Path("newsId") String newsId);

    /**
     * 知乎评论列表
     * 8997528/long-comments
     */
    @Headers({DOMAIN_NAME_HEADER + DOUBAN_DOMAIN_NAME})
    @GET("story/{newsId}/long-comments")
    Flowable<String> getCommentList(@Path("newsId") String newsId);

}
