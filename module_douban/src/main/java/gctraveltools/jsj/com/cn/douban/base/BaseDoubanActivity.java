package gctraveltools.jsj.com.cn.douban.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.app.App;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BaseView;
import gctraveltools.jsj.com.cn.douban.component.ActivityComponent;
import gctraveltools.jsj.com.cn.douban.component.DaggerActivityComponent;


/**
 * Activity 基类
 * Created by 刘泽 on 2017/4/18 18:50.
 */

public abstract class BaseDoubanActivity<T extends BasePresenter,V extends ViewDataBinding> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected V mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayout());

        initInject();
        onViewCreated();
        initView();
    }


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((App) getApplicationContext()).getAppComponent())
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
