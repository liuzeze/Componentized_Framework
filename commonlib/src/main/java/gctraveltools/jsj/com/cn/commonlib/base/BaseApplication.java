package gctraveltools.jsj.com.cn.commonlib.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import gctraveltools.jsj.com.cn.coremodellib.newmvp.app.App;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.component.AppComponent;


/**
 * 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:Utils.getContext()，不允许其他写法；
 *
 * @name BaseApplication
 */
public class BaseApplication extends Application implements App{

    private  BaseApplication instance;



    /**
     * 获取应用程序组件
     */
    public AppDelegate mAppDelegate;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null) {
            mAppDelegate = new AppDelegate(base);
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (mAppDelegate != null) {
            mAppDelegate.init(instance);
        }

    }

    @NonNull
    @Override
    public AppComponent getAppComponent() {
        return mAppDelegate.getAppComponent();
    }
}
