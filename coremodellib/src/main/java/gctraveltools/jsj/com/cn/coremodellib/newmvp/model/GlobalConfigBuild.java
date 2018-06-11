
package gctraveltools.jsj.com.cn.coremodellib.newmvp.model;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.scope.InterceptorsScope;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

/**
 * 请求框架参数初始化
 */
@Module
public class GlobalConfigBuild {
    private HttpUrl mApiUrl;
    private List<Interceptor> mInterceptors;
    private AppModule.GsonConfiguration mGsonConfiguration;
    private ClientModule.RetrofitConfiguration mRetrofitConfiguration;
    private ClientModule.OkhttpConfiguration mOkhttpConfiguration;
    private List<Interceptor> netInterceptors;

    private GlobalConfigBuild(Builder builder) {
        this.mApiUrl = builder.apiUrl;
        this.mInterceptors = builder.interceptors;
        this.netInterceptors = builder.netInterceptors;
        this.mGsonConfiguration = builder.gsonConfiguration;
        this.mRetrofitConfiguration = builder.retrofitConfiguration;
        this.mOkhttpConfiguration = builder.okhttpConfiguration;


    }

    public static Builder builder() {
        return new Builder();
    }


    @Singleton
    @Provides
    @Nullable
    @InterceptorsScope("Interceptors")
    List<Interceptor> provideInterceptors() {
        return mInterceptors;
    }

    @Singleton
    @Provides
    @Nullable
    @InterceptorsScope("netInterceptors")
    List<Interceptor> provideNetInterceptors() {
        return netInterceptors;
    }

    /**
     * 提供 BaseUrl,默认使用 <"https://api.github.com/">
     *
     * @return
     */
    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return mApiUrl == null ? HttpUrl.parse("http://api.douban.com/") : mApiUrl;
    }

    @Singleton
    @Provides
    @Nullable
    AppModule.GsonConfiguration provideGsonConfiguration() {
        return mGsonConfiguration;
    }

    @Singleton
    @Provides
    @Nullable
    ClientModule.RetrofitConfiguration provideRetrofitConfiguration() {
        return mRetrofitConfiguration;
    }
    @Singleton
    @Provides
    @Nullable
    ClientModule.OkhttpConfiguration provideOkhttpConfiguration() {
        return mOkhttpConfiguration;
    }



    public static final class Builder {
        private HttpUrl apiUrl;
        private List<Interceptor> interceptors;
        private List<Interceptor> netInterceptors;
        private AppModule.GsonConfiguration gsonConfiguration;
        private ClientModule.RetrofitConfiguration retrofitConfiguration;
        private ClientModule.OkhttpConfiguration okhttpConfiguration;

        private Builder() {
        }

        public Builder baseurl(String baseUrl) {//基础url
            if (TextUtils.isEmpty(baseUrl)) {
                throw new NullPointerException("BaseUrl can not be empty");
            }
            this.apiUrl = HttpUrl.parse(baseUrl);
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {//动态添加任意个interceptor
            if (interceptors == null) {
                interceptors = new ArrayList<>();
            }
            this.interceptors.add(interceptor);
            return this;
        }
        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (netInterceptors == null) {
                netInterceptors = new ArrayList<>();
            }
            this.netInterceptors.add(interceptor);
            return this;
        }

        public Builder gsonConfiguration(AppModule.GsonConfiguration gsonConfiguration) {
            this.gsonConfiguration = gsonConfiguration;
            return this;
        }
        public Builder retrofitConfiguration(ClientModule.RetrofitConfiguration retrofitConfiguration) {
            this.retrofitConfiguration = retrofitConfiguration;
            return this;
        }

        public Builder okhttpConfiguration(ClientModule.OkhttpConfiguration okhttpConfiguration) {
            this.okhttpConfiguration = okhttpConfiguration;
            return this;
        }

        public GlobalConfigBuild build() {
            return new GlobalConfigBuild(this);
        }


    }


}
