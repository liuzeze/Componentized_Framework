package com.example.mvp_module.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lplibrary.app.App;
import com.example.lplibrary.base.BasePresenter;
import com.example.lplibrary.base.BaseView;
import com.example.mvp_module.component.ActivityComponent;
import com.example.mvp_module.component.DaggerActivityComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Activity 基类
 * Created by 刘泽 on 2017/4/18 18:50.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initConfig();
        initInject();
        onViewCreated();
        initData();
    }

    /**
     * 初始化公用的参数
     */
    private void initConfig() {
        mActivity = this;
        ButterKnife.bind(this);
    }

    /**
     * 关联appCompomponet
     *
     * @return
     */
    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((App) getApplicationContext()).getAppComponent())
                .build();
    }

    /**
     * 为presenter 注册毁掉
     */
    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 销毁毁掉
     */
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 获取资源文件
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 注解当前activity
     */
    protected abstract void initInject();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
