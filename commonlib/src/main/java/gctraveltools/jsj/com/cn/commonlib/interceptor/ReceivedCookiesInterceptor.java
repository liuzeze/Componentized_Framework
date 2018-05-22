package gctraveltools.jsj.com.cn.commonlib.interceptor;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import gctraveltools.jsj.com.cn.commonlib.util.SPUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-05-16       创建class
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable
                    .fromIterable(originalResponse.headers("Set-Cookie"))
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(String s) throws Exception {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }
                    })
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            cookieBuffer.append(s).append(";");
                        }
                    });
            Logger.e(chain.request().url().toString());
            if (chain.request().url().toString().equals("http://123.57.172.16:8080/usercentre/userLogin.do")) {
                SPUtils.getInstance().put("cookie", cookieBuffer.toString());
            }
        }

        return originalResponse;
    }
}
