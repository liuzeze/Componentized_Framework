package gctraveltools.jsj.com.cn.zhihuribao.presenter;


import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BaseView;
/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:41	    刘泽			    新增 类
 * 2017/12/26	11:41	    刘泽			    增加yyy属性
 */

public interface ZhiHuContract {

    interface View extends BaseView {
        void showImgsContent(String getTravels2Response);
    }

    interface Presenter extends BasePresenter<View> {
        void getZhiHuNews();
    }
}
