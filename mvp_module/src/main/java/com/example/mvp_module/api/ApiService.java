package com.example.mvp_module.api;


import com.example.mvp_module.bean.BaseBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.FormBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * API 管理器服务
 */
public interface ApiService {

    /**
     * @param input
     *//*

    @POST(" ")
    @Headers({"Accept: application/x-protobuf",
            "Content-Type: application/x-protobuf",
            "Cache-Control: no-cache"})
   @Path：所有在网址中的参数（URL的问号前面），如：
    http://102.10.10.132/api/Accounts/{accountId}
    @Query：URL问号后面的参数，如：
    http://102.10.10.132/api/Comments?access_token={access_token}
    @QueryMap：相当于多个@Query
    @Field：用于POST请求，提交单个数据
    @Body：相当于多个@Field，以对象的形式提交

    Tips1
    使用@Field时记得添加@FormUrlEncoded
    Tips2
    若需要重新定义接口地址，可以使用@Url，将地址以参数的形式传入即可。如

*/


    @FormUrlEncoded
    @POST("usercentre/userLogin.do")
    Flowable<BaseBean> login(@FieldMap Map<String, String> pramsMap);

    @POST("posappmc/member/getMerchantMemberAllList.do")
    Flowable<String> getMemInfor(@Body FormBody body);

    @POST("posappmc/member/getMerchantMemberAllList.do")
    Flowable<String> getMemInfor(@Body RequestApi.UserBean bean);


}
