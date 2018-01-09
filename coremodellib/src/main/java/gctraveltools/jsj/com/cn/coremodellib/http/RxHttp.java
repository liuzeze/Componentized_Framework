package gctraveltools.jsj.com.cn.coremodellib.http;


import android.util.Log;

import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.android.ParcelableMessageNano;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import gctraveltools.jsj.com.cn.coremodellib.http.api.ApiService;
import gctraveltools.jsj.com.cn.coremodellib.http.client.RetrofitClient;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.ZRequest;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.ZResponse;
import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by liuze on 2017/12/25.
 * 网络请求-----可以对每个请求单独配置参数
 */

public class RxHttp {

    private static RxHttp instance;

    private String baseUrl;

    private boolean isShowLog = true;


    private long readTimeout;
    private long writeTimeout;
    private long connectTimeout;


    private OkHttpClient okClient;

    private List<Converter.Factory> converterFactories = new ArrayList<>();
    private List<CallAdapter.Factory> adapterFactories = new ArrayList<>();

    /**
     * 不使用单利模式是因为单个请求的参数配置是单次有效的
     *
     * @return RxHttp
     */
    public static RxHttp getInstance() {
        instance = new RxHttp();
        return instance;
    }

    public RxHttp baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * 局部设置Converter.Factory,默认GsonConverterFactory.create()
     */
    public RxHttp addConverterFactory(Converter.Factory factory) {
        if (factory != null) {
            converterFactories.add(factory);
        }
        return this;
    }

    /**
     * 局部设置CallAdapter.Factory,默认RxJavaCallAdapterFactory.create()
     */
    public RxHttp addCallAdapterFactory(CallAdapter.Factory factory) {
        if (factory != null) {
            adapterFactories.add(factory);
        }
        return this;
    }


    public RxHttp log(boolean isShowLog) {
        this.isShowLog = isShowLog;
        return this;
    }

    public RxHttp readTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public RxHttp writeTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public RxHttp connectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public RxHttp client(OkHttpClient okClient) {
        this.okClient = okClient;
        return this;
    }


    /**
     * 单个RetrofitBuilder
     *
     * @return
     */
    public Retrofit getSingleRetrofitBuilder() {

        Retrofit.Builder singleRetrofitBuilder = RetrofitClient.getInstance().getRetrofit();


        singleRetrofitBuilder.baseUrl(baseUrl);


        for (Converter.Factory converterFactory : converterFactories) {
            singleRetrofitBuilder.addConverterFactory(converterFactory);
        }


        for (CallAdapter.Factory adapterFactory : adapterFactories) {
            singleRetrofitBuilder.addCallAdapterFactory(adapterFactory);
        }


        singleRetrofitBuilder.client(okClient == null ? getSingleOkHttpBuilder().build() : okClient);

        return singleRetrofitBuilder.build();
    }

    /**
     * 获取单个 OkHttpClient.Builder
     *
     * @return
     */
    private OkHttpClient.Builder getSingleOkHttpBuilder() {

        OkHttpClient.Builder singleOkHttpBuilder = new OkHttpClient.Builder();

        singleOkHttpBuilder.retryOnConnectionFailure(true);//断网重连


        if (isShowLog) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("RxHttpUtils", message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            singleOkHttpBuilder.addInterceptor(loggingInterceptor);
        }


        singleOkHttpBuilder.readTimeout(readTimeout > 0 ? readTimeout : 15, TimeUnit.SECONDS);

        singleOkHttpBuilder.writeTimeout(writeTimeout > 0 ? writeTimeout : 15, TimeUnit.SECONDS);

        singleOkHttpBuilder.connectTimeout(connectTimeout > 0 ? connectTimeout : 15, TimeUnit.SECONDS);

        return singleOkHttpBuilder;
    }

    public Flowable<ZResponse> fetchNetworkData(ParcelableMessageNano requestData) {
        ZRequest request = new ZRequest();

        //设置请求方法
        request.methodName = "GetTravels";

        //将数据压缩到ZReq中
        request.zPack = MessageNano.toByteArray(requestData);
        return getSingleRetrofitBuilder().create(ApiService.class).fetchNetworkData(request);

    }

    public ApiService createApi(Class<ApiService> apiServiceClass) {

        return getSingleRetrofitBuilder().create(apiServiceClass);

    }
}
