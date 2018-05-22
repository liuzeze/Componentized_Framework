package gctraveltools.jsj.com.cn.servers1.presenter;


import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BaseView;
import gctraveltools.jsj.com.cn.servers1.bean.nano.GetTravels2Response;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:41	    刘泽			    新增 类
 * 2017/12/26	11:41	    刘泽			    增加yyy属性
 */

public interface TempContract {

    interface View extends BaseView {
        void showImgsContent(GetTravels2Response getTravels2Response);
    }

    interface Presenter extends BasePresenter<View> {
        void getTravelList();
    }
}
