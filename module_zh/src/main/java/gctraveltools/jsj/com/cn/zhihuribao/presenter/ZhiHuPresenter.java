package gctraveltools.jsj.com.cn.zhihuribao.presenter;


import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;

import javax.inject.Inject;


import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.RxPresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.zhihuribao.api.ZhiHUApi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:40	    刘泽			    新增 类
 * 2017/12/26	11:40	    刘泽			    增加yyy属性
 */

public class ZhiHuPresenter extends RxPresenter<ZhiHuContract.View> implements ZhiHuContract.Presenter {

    private final ZhiHUApi mZhiHUApi;
    private final Application mApplication;

    @Inject
    public ZhiHuPresenter(Application application, ZhiHUApi api) {
        mApplication = application;
        mZhiHUApi = api;
    }

    private static final MutableLiveData ABSENT = new MutableLiveData();

    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    //生命周期观察的数据
    private LiveData<String> mLiveObservableData;

    @Override
    public void getZhiHuNews() {
        //这里的trigger为网络检测，也可以换成缓存数据是否存在检测
        mLiveObservableData = Transformations.switchMap(netConnected(mApplication), new Function<Boolean, LiveData<String>>() {
            @Override
            public LiveData<String> apply(Boolean isNetConnected) {
                Log.i("danxx", "apply------>");
                if (!isNetConnected) {
                    return ABSENT; //网络未连接返回空
                }
                final MutableLiveData<String> applyData = new MutableLiveData<>();

                CommonSubscriber<String> subscriber = new CommonSubscriber<String>(mView) {
                    @Override
                    public void onNext(final String getTravels2Response) {
                       /* if (mView != null) {
                            mView.showImgsContent(getTravels2Response);
                        }*/

                        Observable.create(new ObservableOnSubscribe<Object>() {
                            @Override
                            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                                SystemClock.sleep(2000);
                                e.onNext("");
                            }
                        }).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Object>() {
                                    @Override
                                    public void accept(Object o) throws Exception {
                                        applyData.setValue(getTravels2Response);

                                    }
                                });

                    }
                };
                addSubscribe("getZhiHuNews", mZhiHUApi.getNewLists(subscriber));
                return applyData;
            }
        });

    }

    /**
     * LiveData支持了lifecycle生命周期检测
     *
     * @return
     */
    public LiveData<String> getLiveObservableData() {
        return mLiveObservableData;
    }

    /**
     * 当前网络是否已连接
     */
    public static LiveData<Boolean> netConnected(Context context) {
        MutableLiveData<Boolean> isNetConnect = new MutableLiveData<>();
        if (context == null) {
            isNetConnect.setValue(false);
            return isNetConnect;
        }

        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo[] infos = connectivity.getAllNetworkInfo();
                if (infos != null) {
                    for (NetworkInfo info : infos) {
                        if (info != null && info.isConnected()) {
                            // 判断当前网络是否已经连接
                            if (info.getState() == NetworkInfo.State.CONNECTED) {
                                isNetConnect.setValue(true);
                                return isNetConnect;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        isNetConnect.setValue(false);
        return isNetConnect;
    }
   /* @Override
    public void getZhiHuNews() {
        CommonSubscriber<String> subscriber = new CommonSubscriber<String>(mView) {
            @Override
            public void onNext(String getTravels2Response) {
                if (mView != null) {
                    mView.showImgsContent(getTravels2Response);
                }


            }
        };
        addSubscribe("getZhiHuNews", mZhiHUApi.getNewLists(subscriber));

    }*/


}
