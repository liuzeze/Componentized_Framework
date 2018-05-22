package gctraveltools.jsj.com.cn.douban.presenter;


import javax.inject.Inject;

import gctraveltools.jsj.com.cn.douban.api.DouBanApi;
import gctraveltools.jsj.com.cn.douban.bean.MovieListBean;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.LPDialog;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.RxPresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class DouBanListPresenter extends RxPresenter<DouBanListContract.View> implements DouBanListContract.Presenter {

    private final DouBanApi mSkyTrainApi;
    private final LPDialog mDialog;

    @Inject
    public DouBanListPresenter( DouBanApi api, LPDialog dialog) {
        mSkyTrainApi = api;
        mDialog = dialog;
    }

    @Override
    public void getMovieListReq(String  path) {
        CommonSubscriber<MovieListBean> subscriber = new CommonSubscriber<MovieListBean>(mView,mDialog) {
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
