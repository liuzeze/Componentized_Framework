package com.example.mvp_module.base;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lplibrary.app.App;
import com.example.lplibrary.base.BasePresenter;
import com.example.lplibrary.base.BaseView;
import com.example.mvp_module.component.ActivityComponent;
import com.example.mvp_module.component.DaggerActivityComponent;

import javax.inject.Inject;

/**
 * Activity 基类
 * Created by 刘泽 on 2017/4/18 18:50.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {

    @Inject
    protected T mPresenter;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initInject();
        onViewCreated();
        initView();
    }


    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(((App) mContext.getApplicationContext()).getAppComponent())
                .build();
    }


    protected void onViewCreated() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    protected abstract int getLayout();

    protected abstract void initInject();

    protected abstract void initView();
}
