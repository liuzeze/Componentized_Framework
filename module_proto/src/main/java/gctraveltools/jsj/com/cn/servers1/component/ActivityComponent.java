package gctraveltools.jsj.com.cn.servers1.component;


import dagger.Component;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.component.AppComponent;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.scope.CustomizeScope;
import gctraveltools.jsj.com.cn.servers1.Server1Activity;

/**
 * ----- 日期 ---------- 维护人 ---------- 变更内容 ----------
 * 2017/4/26 11:13	    liuze
 */
@CustomizeScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(Server1Activity mainActivity);


}
