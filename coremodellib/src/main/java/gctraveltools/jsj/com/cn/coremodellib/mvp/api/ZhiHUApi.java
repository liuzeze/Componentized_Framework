package gctraveltools.jsj.com.cn.coremodellib.mvp.api;

import gctraveltools.jsj.com.cn.coremodellib.http.RxHttp;
import gctraveltools.jsj.com.cn.coremodellib.http.api.ApiService;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.Transformer;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */

public class ZhiHUApi {


    private static ZhiHUApi instance;

    /**
     * 供外界使用当前实例
     *
     * @return 当前API实例
     */
    public static ZhiHUApi getInstance() {
        if (instance == null) {
            instance = new ZhiHUApi();
        }
        return instance;
    }

    public CommonSubscriber<String> getNewLists(CommonSubscriber<String> subscriber) {
        return RxHttp.getInstance()
                .baseUrl("https://news-at.zhihu.com/api/4/news/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .createApi(ApiService.class)
                .fetchNetworkData()
                .compose(Transformer.<String>switchSchedulers())
                .subscribeWith(subscriber);
    }

    public CommonSubscriber<String> getNewDetailLists(CommonSubscriber<String> subscriber, String id) {
        return RxHttp.getInstance()
                .baseUrl("https://news-at.zhihu.com/api/4/news/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .createApi(ApiService.class)
                .fetchNetworkData(id)
                .compose(Transformer.<String>switchSchedulers())
                .subscribeWith(subscriber);
    }

    public CommonSubscriber<String> getZhiHuNewsComment(CommonSubscriber<String> subscriber, String id) {
        return RxHttp.getInstance()
                .baseUrl("https://news-at.zhihu.com/api/4/story/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .createApi(ApiService.class)
                .getCommentList(id)
                .compose(Transformer.<String>switchSchedulers())
                .subscribeWith(subscriber);
    }
}
