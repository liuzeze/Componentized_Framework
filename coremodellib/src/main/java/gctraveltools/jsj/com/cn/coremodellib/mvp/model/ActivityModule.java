package gctraveltools.jsj.com.cn.coremodellib.mvp.model;



import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Activity 模块
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:14	    liuze
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

}