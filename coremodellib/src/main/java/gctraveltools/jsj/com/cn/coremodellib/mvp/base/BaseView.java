package gctraveltools.jsj.com.cn.coremodellib.mvp.base;


public interface BaseView {

    void showErrorMsg(String msg);

    //=======  State  =======
    void stateError(String message);
}
