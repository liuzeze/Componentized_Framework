package gctraveltools.jsj.com.cn.douban.presenter;


import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.coremodellib.http.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieListBean;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.DouBanApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.RxPresenter;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class DouBanListPresenter extends RxPresenter<DouBanListContract.View> implements DouBanListContract.Presenter {

    private final Context mContext;
    private final DouBanApi mSkyTrainApi;

    @Inject
    public DouBanListPresenter(Application context, DouBanApi api) {
        super(context);
        mContext = context;
        mSkyTrainApi = api;
    }

    @Override
    public void getMovieListReq(String  path) {
        CommonSubscriber<MovieListBean> subscriber = new CommonSubscriber<MovieListBean>(mView) {
            @Override
            public void onNext(MovieListBean movieListBean) {
                if (mView != null) {
                    mView.showImgsContent(movieListBean);
                }
            }
        };
        addSubscribe("getMovieDetailReq", mSkyTrainApi.getMovieList(subscriber,path));

    }


}
