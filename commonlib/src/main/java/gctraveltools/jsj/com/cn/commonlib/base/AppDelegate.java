/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gctraveltools.jsj.com.cn.commonlib.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;


import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;

import gctraveltools.jsj.com.cn.commonlib.util.Utils;
import gctraveltools.jsj.com.cn.coremodellib.BuildConfig;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.app.App;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.app.ManifestParser;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.ConfigModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.GlobalConfigBuild;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.component.AppComponent;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.component.DaggerAppComponent;


/**
 * application的代理类
 */
public class AppDelegate implements App {

    private List<ConfigModule> mModules;
    private AppComponent mAppComponent;

    public AppDelegate(Context base) {
        mModules = new ManifestParser(base).parse();

    }

    public void init(@NonNull Application application) {
        initComponet(application);
        //可以自己构造适配器默认：AndroidLogAdapter
        Logger.addLogAdapter(new AndroidLogAdapter());

        //路由跳转
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        //屏幕适配方式
        ScreenAdaptation.register(application, 720);
        Utils.init(application);


        //frasco 初始化
        Fresco.initialize(application);
    }

    private void initComponet(@NonNull Application application) {
        mAppComponent = DaggerAppComponent
                .builder()
                //提供application
                .application(application)
                //全局配置
                .globalConfigModule(getGlobalConfigModule(mModules))
                .build();
    }

    /**
     * @param modules
     * @return GlobalConfigBuild
     */
    private static GlobalConfigBuild getGlobalConfigModule(List<ConfigModule> modules) {
        GlobalConfigBuild.Builder builder = GlobalConfigBuild
                .builder();
        for (ConfigModule module : modules) {
            // 给全局配置 GlobalConfigBuild 添加参数
            module.applyOptions(builder);
        }
        return builder.build();
    }


    @NonNull
    @Override
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}

