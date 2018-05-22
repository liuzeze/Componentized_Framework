package gctraveltools.jsj.com.cn.douban.presenter;


import gctraveltools.jsj.com.cn.douban.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BasePresenter;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BaseView;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/26	11:41	    刘泽			    新增 类
 * 2017/12/26	11:41	    刘泽			    增加yyy属性
 */

public interface DouBanDetailContract {

    interface View extends BaseView {
        void showImgsContent(MovieDetailBean movieListBean);
    }

    interface Presenter extends BasePresenter<View> {
        void getMovieDetailReq(String movieId);
    }
}
