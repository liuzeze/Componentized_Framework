package gctraveltools.jsj.com.cn.zhihuribao.api;


import javax.inject.Inject;

import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.Transformer;
import okhttp3.Interceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */

public class ZhiHUApi {

    private final Retrofit mRetrofit;

    @Inject
    public ZhiHUApi(Retrofit retrofit) {
        //  mRetrofit = retrofit.newBuilder().baseUrl("https://news-at.zhihu.com/api/4/").build();
        mRetrofit = retrofit/*.newBuilder().baseUrl("https://news-at.zhihu.com/api/4/").build()*/;
    }


    public CommonSubscriber<String> getNewLists(CommonSubscriber<String> subscriber) {
        return
                mRetrofit.create(ApiService.class)
                        .getNewLists()
                        .compose(Transformer.<String>switchSchedulers())
                        .subscribeWith(subscriber);

    }

    public CommonSubscriber<String> getNewDetailLists(CommonSubscriber<String> subscriber, String id) {
        return
                mRetrofit.create(ApiService.class)
                        .fetchNetworkData(id)
                        .compose(Transformer.<String>switchSchedulers())
                        .subscribeWith(subscriber);
    }

    public CommonSubscriber<String> getZhiHuNewsComment(CommonSubscriber<String> subscriber, String id) {
        return
                mRetrofit.create(ApiService.class)
                        .getCommentList(id)
                        .compose(Transformer.<String>switchSchedulers())
                        .subscribeWith(subscriber);
    }
}
