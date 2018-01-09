package gctraveltools.jsj.com.cn.commonlib.base;


import android.app.Application;

import dagger.Component;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.DouBanApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.SkyTrainApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.ZhiHUApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.ApiModel;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.AppModule;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:13	    刘泽
 */

@Component(modules = {AppModule.class, ApiModel.class})
public interface AppComponent {

    Application getApplication();  // 提供App的Context

    SkyTrainApi getTrainApiApi();

    DouBanApi getDouBanApi();

    ZhiHUApi getZhiHUApi();

}
