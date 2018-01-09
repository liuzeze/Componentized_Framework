package gctraveltools.jsj.com.cn.douban.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.commonlib.base.BaseApplication;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.mvp.base.BaseView;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.ActivityModule;
import gctraveltools.jsj.com.cn.douban.component.ActivityComponent;
import gctraveltools.jsj.com.cn.douban.component.DaggerActivityComponent;


/**
 * Activity 基类
 * Created by 刘泽 on 2017/4/18 18:50.
 */

public abstract class BaseDoubanActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

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
