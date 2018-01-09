package gctraveltools.jsj.com.cn.servers1.Base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.commonlib.base.BaseApplication;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.BaseView;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.ActivityModule;
import gctraveltools.jsj.com.cn.servers1.component.ActivityComponent;
import gctraveltools.jsj.com.cn.servers1.component.DaggerActivityComponent;


/**
 * Activity 基类
 * Created by 刘泽 on 2017/4/18 18:50.
 */

public abstract class BaseServerActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initInject();
        onViewCreated();
        initView();
    }


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }


    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }


    protected abstract int getLayout();

    protected abstract void initInject();

    protected abstract void initView();
}
