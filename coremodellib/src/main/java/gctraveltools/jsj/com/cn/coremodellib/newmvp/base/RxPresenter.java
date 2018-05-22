package gctraveltools.jsj.com.cn.coremodellib.newmvp.base;

import android.support.v4.util.ArrayMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	9:24	    刘泽			   presenter基类用于管理订阅监听以及注册view
 * 2017/12/26	9:24	    刘泽			    增加yyy属性
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;
    private ArrayMap<Object, Disposable> mapDisposable;


    /**
     * 添加带有标记的订阅，方便手动注销，以免重复的订阅响应
     *
     * @param tag          订阅标记
     * @param subscription 订阅者
     */
    protected void addSubscribe(String tag, Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (mapDisposable == null) {
            mapDisposable = new ArrayMap<>();
        }
        //添加前先移除
        removeSubscribe(tag);

        //添加到队列
        mCompositeDisposable.add(subscription);

        //加入到管理
        mapDisposable.put(tag, subscription);
    }

    /**
     * @param subscription 订阅者
     */
    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (mapDisposable == null) {
            mapDisposable = new ArrayMap<>();
        }
        //添加到队列
        mCompositeDisposable.add(subscription);

        //加入到管理
        mapDisposable.put("", subscription);
    }

    /**
     * 为了防止重复请求，这里我们进行移除指定的订阅者
     *
     * @param tag 订阅者标记
     */
    private void removeSubscribe(String tag) {
        if (mapDisposable != null) {
            //取出队列中订阅者进行主动消费掉
            Disposable disposable = mapDisposable.get(tag);

            if (disposable != null) {
                //主动的进行消费
                disposable.dispose();
                //从管理集合中移除
                mapDisposable.remove(tag);
            }
        }
    }


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable = null;
        }
    }
}
