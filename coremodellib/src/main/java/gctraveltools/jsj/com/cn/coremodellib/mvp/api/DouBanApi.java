package gctraveltools.jsj.com.cn.coremodellib.mvp.api;

import gctraveltools.jsj.com.cn.coremodellib.http.RxHttp;
import gctraveltools.jsj.com.cn.coremodellib.http.api.ApiService;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.Transformer;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieListBean;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */

public class DouBanApi {


    private static DouBanApi instance;

    /**
     * 供外界使用当前实例
     *
     * @return 当前API实例
     */
    public static DouBanApi getInstance() {
        if (instance == null) {
            instance = new DouBanApi();
        }
        return instance;
    }

    public CommonSubscriber<MovieListBean> getMovieList(CommonSubscriber<MovieListBean> subscriber,String path) {
        return RxHttp.getInstance()
                .baseUrl("http://api.douban.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .createApi(ApiService.class)
                .getMoviewList(path)
                .compose(Transformer.<MovieListBean>switchSchedulers())
                .subscribeWith(subscriber);
    }

    public CommonSubscriber<MovieDetailBean> getMovieDetail(CommonSubscriber<MovieDetailBean> subscriber,String movieId) {
        return RxHttp.getInstance()
                .baseUrl("http://api.douban.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .createApi(ApiService.class)
                .getMoviewDetail(movieId)
                .compose(Transformer.<MovieDetailBean>switchSchedulers())
                .subscribeWith(subscriber);
    }
}
