package com.example.mvp_module.api;


import com.example.lplibrary.observer.CommonSubscriber;
import com.example.lplibrary.observer.Transformer;
import com.example.lplibrary.scope.ActivityScope;
import com.example.mvp_module.bean.BaseBean;

import java.util.HashMap;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * 网络请求
 */
@ActivityScope
public class RequestApi {
    Retrofit mRetrofit;

    @Inject
    public RequestApi(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    /**
     * d登录
     *
     * @param subscriber
     * @return
     */
    public CommonSubscriber<BaseBean> login(CommonSubscriber<BaseBean> subscriber) {
        HashMap<String, String> pramsMap = new HashMap<>();
        pramsMap.put("loginName", "123niqiu");
        pramsMap.put("passWord", "123niqiu");
        pramsMap.put("version", "3.0.2");
        pramsMap.put("sysTag", "3");
        return mRetrofit.create(ApiService.class)
                .login(pramsMap)
                .compose(Transformer.<BaseBean>switchSchedulers())
                .subscribeWith(subscriber);
    }

    /**
     * d登录
     *
     * @param subscriber
     * @return
     */
    public CommonSubscriber<String> getMemInfor(CommonSubscriber<String> subscriber) {
      /*  FormBody body = new FormBody.Builder()
                .add("employeeDutyLogId", "41096")
                .add("moneyboxCash", "")
                .build()*/;
        UserBean userBean = new UserBean("41096", "");
        return mRetrofit.create(ApiService.class)
              //  .getMemInfor(body)
                .getMemInfor(userBean)
                .compose(Transformer.<String>switchSchedulers())
                .subscribeWith(subscriber);
    }

    public class UserBean {
        private String employeeDutyLogId = "41096";
        private String moneyboxCash = "";

        public UserBean(String employeeDutyLogId, String moneyboxCash) {
            this.employeeDutyLogId = employeeDutyLogId;
            this.moneyboxCash = moneyboxCash;
        }
    }
}
