package com.example.mvp_module;

import com.example.lplibrary.base.LPDialog;
import com.example.lplibrary.base.RxPresenter;
import com.example.lplibrary.observer.CommonSubscriber;
import com.example.mvp_module.api.RequestApi;
import com.example.mvp_module.bean.BaseBean;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class MainPresenter extends RxPresenter<TempContract.View> {
    // @Inject
    RequestApi mApiNewLists;
    @Inject
    LPDialog mLPDialog;

    @Inject
    public MainPresenter(RequestApi requestApi) {
        this.mApiNewLists = requestApi;
    }

    /**
     * 登录
     */
    public void login() {
        mApiNewLists.login(new CommonSubscriber<BaseBean>(mView, mLPDialog) {
            @Override
            public void onNext(BaseBean s) {
                mView.showImgsContent(s);
            }
        });
    }

    /**
     * 请求新闻列表
     */
    public void getMemInfor() {
        mApiNewLists.getMemInfor(new CommonSubscriber<String>(mView, mLPDialog) {
            @Override
            public void onNext(String s) {
                mView.showMemInfor(s);
            }
        });
    }
}
