package gctraveltools.jsj.com.cn.servers1.component;


import android.app.Activity;

import dagger.Component;
import gctraveltools.jsj.com.cn.commonlib.base.AppComponent;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.FragmentModule;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:13	    liuze
 */
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
