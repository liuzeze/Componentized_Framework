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
package gctraveltools.jsj.com.cn.coremodellib.newmvp.component;


import android.app.Application;


import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import dagger.BindsInstance;

import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.LPDialog;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.AppModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.ClientModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.GlobalConfigBuild;
import retrofit2.Retrofit;

/**
 * 提供全局参数
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, GlobalConfigBuild.class})
public interface AppComponent {
    Application application();

    LPDialog getLPDialog();

    Retrofit getRetrofit();

    //gson
    Gson gson();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        Builder globalConfigModule(GlobalConfigBuild globalConfigModule);

        AppComponent build();
    }
}
