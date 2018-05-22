package gctraveltools.jsj.com.cn.zhihuribao.presenter;


import android.app.Application;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.RxPresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.zhihuribao.api.ZhiHUApi;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class ZhiHuDetailPresenter extends RxPresenter<ZhiHuDetailContract.View> implements ZhiHuDetailContract.Presenter {

    private final ZhiHUApi mZhiHUApi;

    @Inject
    public ZhiHuDetailPresenter(Application application, ZhiHUApi api) {
        mZhiHUApi = api;
    }

    @Override
    public void getZhiHuNewsDetail(String id) {
        CommonSubscriber<String> subscriber = new CommonSubscriber<String>(mView) {
            @Override
            public void onNext(String getTravels2Response) {
                if (mView != null) {
                    mView.showImgsContent(getTravels2Response);
                }


            }
        };
        addSubscribe("getZhiHuNewsDetail", mZhiHUApi.getNewDetailLists(subscriber, id));

    }

    @Override
    public void getZhiHuNewsComment(String id) {
        CommonSubscriber<String> subscriber = new CommonSubscriber<String>(mView) {
            @Override
            public void onNext(String getTravels2Response) {
                if (mView != null) {
                    mView.showComment(getTravels2Response);
                }


            }
        };
        addSubscribe("getZhiHuNewsComment", mZhiHUApi.getZhiHuNewsComment(subscriber, id));
    }


}
