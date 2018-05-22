
package gctraveltools.jsj.com.cn.coremodellib.newmvp.model;


import android.support.annotation.Nullable;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gctraveltools.jsj.com.cn.coremodellib.convert.FastJsonConverterFactory;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 网络相关对象获取
 * 提供okhttp  和 retrofit相关实例
 */
@Module
public abstract class ClientModule {
    private static final int TIME_OUT = 15;

    @Singleton
    @Provides
    static Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    /**
     * 提供 {@link Retrofit}
     *
     * @param
     * @return {@link Retrofit}
     */
    @Singleton
    @Provides
    static Retrofit provideRetrofit(Retrofit.Builder builder, @Nullable RetrofitConfiguration configuration, OkHttpClient client, HttpUrl url) {

        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //   .addConverterFactory(ScalarsConverterFactory.create())
                // .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .baseUrl(url)
                .client(client);
        if (configuration != null) {
            configuration.configRetrofit(builder);
        }
        return builder.build();
    }

    @Singleton
    @Provides
    static OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }


    /**
     * 提供 {@link OkHttpClient}
     *
     * @return {@link OkHttpClient}
     */
    @Singleton
    @Provides
    static OkHttpClient provideClient(OkHttpClient.Builder builder, @Nullable OkhttpConfiguration configuration, @Nullable List<Interceptor> interceptors) {

        //如果外部提供了interceptor的集合则遍历添加
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        builder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);

        if (configuration != null) {
            configuration.configOkhttp(builder);
        }
        return builder.build();
    }

    public interface RetrofitConfiguration {
        void configRetrofit(Retrofit.Builder builder);
    }

    public interface OkhttpConfiguration {
        void configOkhttp(OkHttpClient.Builder builder);
    }

}
