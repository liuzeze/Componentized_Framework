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


import android.content.Context;

import com.google.gson.GsonBuilder;
import com.google.protobuf.nano.android.converter.ProtoNanoConverterFactory;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import gctraveltools.jsj.com.cn.commonlib.BuildConfig;
import gctraveltools.jsj.com.cn.commonlib.interceptor.AddCookiesInterceptor;
import gctraveltools.jsj.com.cn.commonlib.interceptor.ReceivedCookiesInterceptor;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.AppModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.ClientModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.ConfigModule;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.model.GlobalConfigBuild;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 请求框架参数赋值
 */
public class GlobalConfiguration implements ConfigModule {


    @Override
    public void applyOptions(GlobalConfigBuild.Builder builder) {


        if (BuildConfig.DEBUG) { //Release 时,让框架不再打印 Http 请求和响应的信息
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Logger.e(message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        builder
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .baseurl(LPUrl.BASE_URl)
                .gsonConfiguration(new AppModule.GsonConfiguration() {
                    @Override
                    public void configGson(Context context, GsonBuilder builder) {
                        //Gson 信息配置
                        builder.serializeNulls()//支持序列化null的参数
                                .enableComplexMapKeySerialization();//支持将序列化key为object的map,默认只能序列化key为string的map

                    }
                }).
                retrofitConfiguration(new ClientModule.RetrofitConfiguration() {
                    @Override
                    public void configRetrofit(Retrofit.Builder builder) {
                        //retrofit  信息配置
                        builder
                              //  .addConverterFactory(ProtoNanoConverterFactory.create())
                                .addConverterFactory(ScalarsConverterFactory.create());
                        // .addConverterFactory(GsonConverterFactory.create())
                    }
                }).okhttpConfiguration(new ClientModule.OkhttpConfiguration() {
            @Override
            public void configOkhttp(OkHttpClient.Builder builder) {
                //这里可以自己自定义配置Okhttp的参数
                builder.writeTimeout(20, TimeUnit.SECONDS);
                builder.readTimeout(20, TimeUnit.SECONDS);
                builder.connectTimeout(20, TimeUnit.SECONDS);
            }
        });


    }
}
