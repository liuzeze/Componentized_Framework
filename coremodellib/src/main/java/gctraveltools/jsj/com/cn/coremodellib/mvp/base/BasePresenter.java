package gctraveltools.jsj.com.cn.coremodellib.mvp.base;

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
