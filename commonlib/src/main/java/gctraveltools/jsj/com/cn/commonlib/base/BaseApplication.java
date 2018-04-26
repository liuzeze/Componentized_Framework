package gctraveltools.jsj.com.cn.commonlib.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

import gctraveltools.jsj.com.cn.commonlib.util.Utils;
import gctraveltools.jsj.com.cn.coremodellib.BuildConfig;
import gctraveltools.jsj.com.cn.coremodellib.mvp.model.AppModule;
import okhttp3.internal.Util;

/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 *
 * @name BaseApplication
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static synchronized BaseApplication getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //路由跳转
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(getInstance()); // 尽可能早，推荐在Application中初始化
        //屏幕适配方式
        ScreenAdaptation.register(this, 720);
        Utils.init(this);


        //frasco 初始化
        Fresco.initialize(this);

    }

    /**
     * 获取应用程序组件
     */
    public static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }


}
