package gctraveltools.jsj.com.cn.coremodellib.model.proto;

import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.BaseRequest;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.LanguageVersion;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.nano.SourceWay;

/**
 * protoc nano 基础请求的基类
 */

public class BaseProtoNanoFactory {

    /**
     * 获取通用的BaseRequest.Builder
     *
     * @return 通用的网络请求的数据基础
     */
    public static BaseRequest getBaseReq() {
        //构建请求基类
        BaseRequest baseBuilder = new BaseRequest();

        baseBuilder.appVersion = "";

        baseBuilder.sourceCompanyID = 1;


        baseBuilder.token = "This user is not token";


        baseBuilder.sourceWay = SourceWay.Android;

        baseBuilder.languageVersion = LanguageVersion.CN;


        baseBuilder.terminalExt = "This_device_does_not_support";



        baseBuilder.registrationId = "jsj.com.cn.all";


        baseBuilder.iMEI = "This_device_does_not_support";


        baseBuilder.jSJID = "123456789";


        return baseBuilder;
    }


}
