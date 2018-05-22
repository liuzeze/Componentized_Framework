package com.example.mvp_module;


import com.example.lplibrary.base.BasePresenter;
import com.example.lplibrary.base.BaseView;
import com.example.mvp_module.bean.BaseBean;


public interface TempContract {

    interface View extends BaseView {
        void showImgsContent(BaseBean s);

        void showMemInfor(String s);
    }
    interface Presenter extends BasePresenter<View> {
        void getZhiHuNews();
    }
}
