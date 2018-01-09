package gctraveltools.jsj.com.cn.coremodellib.mvp.model;

import dagger.Module;
import dagger.Provides;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.DouBanApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.SkyTrainApi;
import gctraveltools.jsj.com.cn.coremodellib.mvp.api.ZhiHUApi;

/**
 * Created by 刘泽
 */
@Module
public class ApiModel {

    @Provides
    protected SkyTrainApi provideTrainService() {
        return SkyTrainApi.getInstance();
    }


    @Provides
    protected ZhiHUApi provideZhiHUService() {
        return ZhiHUApi.getInstance();
    }

    @Provides
    protected DouBanApi provideDouBanApiService() {
        return DouBanApi.getInstance();
    }
}
