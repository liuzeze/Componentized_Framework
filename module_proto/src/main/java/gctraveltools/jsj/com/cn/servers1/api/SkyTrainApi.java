package gctraveltools.jsj.com.cn.servers1.api;

import com.google.protobuf.nano.MessageNano;

import java.io.IOException;

import javax.inject.Inject;

import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.observer.Transformer;
import gctraveltools.jsj.com.cn.servers1.bean.nano.GetTravels2Request;
import gctraveltools.jsj.com.cn.servers1.bean.nano.GetTravels2Response;
import gctraveltools.jsj.com.cn.servers1.bean.nano.ZRequest;
import gctraveltools.jsj.com.cn.servers1.bean.nano.ZResponse;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */

public class SkyTrainApi {

    private final Retrofit mRetrofit;

    @Inject
    public SkyTrainApi(Retrofit retrofit) {
        mRetrofit = retrofit;
    }


    public CommonSubscriber<GetTravels2Response> getTravelList(CommonSubscriber<GetTravels2Response> subscriber) {
        //创建请求实体对象
        GetTravels2Request request = new GetTravels2Request();
        //实体数据赋值
        ZRequest zRequest = new ZRequest();
        //设置请求方法
        zRequest.methodName = "GetTravels";
        //将数据压缩到ZReq中
        zRequest.zPack = MessageNano.toByteArray(request);
        //由于接口返回的数据都是使用ZRes进行压缩的，所以我们需要处理一下变成我们需要的数据
        return
                mRetrofit.create(ApiService.class)
                        .fetchNetworkData(zRequest)
                        .compose(Transformer.<ZResponse>switchSchedulers())
                        .map(new Function<ZResponse, GetTravels2Response>() {
                            @Override
                            public GetTravels2Response apply(ZResponse zResponse) throws Exception {
                                //建立我们需要的返回数据Builder
                                GetTravels2Response result = null;
                                try {
                                    //使用Proto内部的转换器将数据流提取并转换成我们需要的数据
                                    result = GetTravels2Response.parseFrom(zResponse.zPack);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return result;
                            }
                        })
                        .subscribeWith(subscriber);


    }
}
