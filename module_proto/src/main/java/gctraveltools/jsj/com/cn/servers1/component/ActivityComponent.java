package gctraveltools.jsj.com.cn.servers1.component;


import android.app.Activity;

import dagger.Component;
import gctraveltools.jsj.com.cn.commonlib.base.AppComponent;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.ActivityModule;
import gctraveltools.jsj.com.cn.servers1.Server1Activity;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:13	    liuze
 */
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(Server1Activity mainActivity);


}
