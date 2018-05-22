package gctraveltools.jsj.com.cn.douban.presenter;


import javax.inject.Inject;

import gctraveltools.jsj.com.cn.douban.api.DouBanApi;
import gctraveltools.jsj.com.cn.douban.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.RxPresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class DouBanDetailPresenter extends RxPresenter<DouBanDetailContract.View> implements DouBanDetailContract.Presenter {

    private final DouBanApi mSkyTrainApi;

    @Inject
    public DouBanDetailPresenter( DouBanApi api) {
        mSkyTrainApi = api;
    }

    @Override
    public void getMovieDetailReq(String movieId) {
        CommonSubscriber<MovieDetailBean> subscriber = new CommonSubscriber<MovieDetailBean>(mView) {
            @Override
            public void onNext(MovieDetailBean movieListBean) {
                if (mView != null) {
                    mView.showImgsContent(movieListBean);
                }
            }
        };
        addSubscribe("getMovieDetailReq", mSkyTrainApi.getMovieDetail(subscriber, movieId));

    }


}
