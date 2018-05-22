package gctraveltools.jsj.com.cn.zhihuribao.component;



import dagger.Component;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.component.AppComponent;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.scope.CustomizeScope;
import gctraveltools.jsj.com.cn.zhihuribao.ZHMainActivity;
import gctraveltools.jsj.com.cn.zhihuribao.ZHNewsDetailActivity;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:13	    liuze
 */
@CustomizeScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(ZHMainActivity mainActivity);

    void inject(ZHNewsDetailActivity mainActivity);


}
