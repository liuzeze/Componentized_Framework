package gctraveltools.jsj.com.cn.coremodellib.newmvp.base;

/**
 * 绑定accitvty的基类presenter
 * @param <T>
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
