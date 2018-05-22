package gctraveltools.jsj.com.cn.servers1.api;


import gctraveltools.jsj.com.cn.servers1.bean.nano.ZRequest;
import gctraveltools.jsj.com.cn.servers1.bean.nano.ZResponse;
import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;


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


}
