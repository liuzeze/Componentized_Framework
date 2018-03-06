package gctraveltools.jsj.com.cn.servers1.presenter;


import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.coremodellib.http.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.GetTravels2Response;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.SkyTrainApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.RxPresenter;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class TemPresenter extends RxPresenter<TempContract.View> implements TempContract.Presenter {

    private final Context mContext;
    private final SkyTrainApi mSkyTrainApi;

    @Inject
    public TemPresenter(Application context, SkyTrainApi api) {
        super(context);
        mContext = context;
        mSkyTrainApi = api;

    }

    @Override
    public void getTravelList() {
        CommonSubscriber<GetTravels2Response> subscriber = new CommonSubscriber<GetTravels2Response>(mView) {
            @Override
            public void onNext(GetTravels2Response getTravels2Response) {
                if (getTravels2Response.baseResponse.isSuccess) {
                    if (mView != null) {
                        mView.showImgsContent(getTravels2Response);
                    }
                } else {
                    if (mView != null) {
                        mView.showErrorMsg(getTravels2Response.baseResponse.errorMessage);
                    }
                }

            }
        };
        try {
            addSubscribe("getTravelList", mSkyTrainApi.getTravelList(subscriber));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            if (mView != null) {
                mView.showErrorMsg(e.getMessage()
                );
            }
        }

    }


}
