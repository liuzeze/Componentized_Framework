package gctraveltools.jsj.com.cn.coremodellib.mvp.api;

import java.io.IOException;

import gctraveltools.jsj.com.cn.coremodellib.http.RxHttp;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.CommonSubscriber;
import gctraveltools.jsj.com.cn.coremodellib.http.observer.Transformer;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.ZResponse;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.GetTravels2Request;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.GetTravels2Response;
import io.reactivex.functions.Function;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	16:45	    刘泽			    新增 类
 * 2017/12/27	16:45	    刘泽			    增加yyy属性
 */

public class SkyTrainApi {


    private static SkyTrainApi instance;

    /**
     * 供外界使用当前实例
     *
     * @return 当前API实例
     */
    public static SkyTrainApi getInstance() {
        if (instance == null) {
            instance = new SkyTrainApi();
        }
        return instance;
    }

    public CommonSubscriber<GetTravels2Response> getTravelList(CommonSubscriber<GetTravels2Response> subscriber) {
        //创建请求实体对象
        GetTravels2Request requestData = new GetTravels2Request();

        //由于接口返回的数据都是使用ZRes进行压缩的，所以我们需要处理一下变成我们需要的数据
        return RxHttp.getInstance()
                .baseUrl("请求地址出错")
                .connectTimeout(60)
                .readTimeout(60)
                .writeTimeout(60)
                .fetchNetworkData(requestData)
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
