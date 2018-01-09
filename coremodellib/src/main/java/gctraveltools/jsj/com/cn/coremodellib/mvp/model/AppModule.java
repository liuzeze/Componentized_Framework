package gctraveltools.jsj.com.cn.coremodellib.mvp.model;


import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:14	    刘泽
 */

@Module
public class AppModule {
    private Application context;

    public AppModule(Application context) {
        this.context = context;
    }

    @Provides
    public Application provideContext() {
        return context;
    }


}
