package gctraveltools.jsj.com.cn.commonlib.interceptor;


import java.io.IOException;

import gctraveltools.jsj.com.cn.commonlib.util.SPUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-05-16       创建class
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        Observable.just(SPUtils.getInstance().getString("cookie", ""))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) throws Exception {
                        //添加cookie
                        builder.addHeader("Cookie", cookie);
                    }
                });
        return chain.proceed(builder.build());
    }
}