package gctraveltools.jsj.com.cn.douban.api;

import javax.inject.Inject;


import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.Transformer;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.scope.CustomizeScope;
import gctraveltools.jsj.com.cn.douban.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.douban.bean.MovieListBean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */
@CustomizeScope
public class DouBanApi {

    private final Retrofit mRetrofit;

    @Inject
    public DouBanApi(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    public CommonSubscriber<MovieListBean> getMovieList(CommonSubscriber<MovieListBean> subscriber, String path) {
        return mRetrofit.create(ApiService.class)
                .getMoviewList( path)
                .compose(Transformer.<MovieListBean>switchSchedulers())
                .subscribeWith(subscriber);

    }

    public CommonSubscriber<MovieDetailBean> getMovieDetail(CommonSubscriber<MovieDetailBean> subscriber, String movieId) {
        return
                mRetrofit.create(ApiService.class)
                        .getMoviewDetail(movieId)
                        .compose(Transformer.<MovieDetailBean>switchSchedulers())
                        .subscribeWith(subscriber);

    }
}
