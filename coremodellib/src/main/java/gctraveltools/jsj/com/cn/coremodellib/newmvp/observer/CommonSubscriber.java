package gctraveltools.jsj.com.cn.coremodellib.newmvp.observer;



import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.BaseView;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.base.LPDialog;
import gctraveltools.jsj.com.cn.coremodellib.newmvp.exception.ApiException;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * 公用的订阅处理
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private LPDialog mDialog;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, final LPDialog dialog) {
        this.mView = view;
        mDialog = dialog;
    }


    @Override
    protected void onStart() {
        super.onStart();
        //这个方法只能是subscriber的线程一致,不可指定线程有可能是子线程
        try {
            if (mDialog != null) {
                mDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String message = ApiException.handleException(e).getLocalizedMessage();
        if (mView == null) {
            return;
        }
        mView.showErrorMsg(message);
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}