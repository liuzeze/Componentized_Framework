package gctraveltools.jsj.com.cn.coremodellib.http.observer;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//                                                                //
////////////////////////////////////////////////////////////////////


import gctraveltools.jsj.com.cn.coremodellib.mvp.base.BaseView;
import gctraveltools.jsj.com.cn.coremodellib.http.exception.ApiException;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * 公用的订阅处理
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private boolean isShowErrorState = true;

    protected CommonSubscriber() {
    }

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }


    protected CommonSubscriber(BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        String message = ApiException.handleException(e).getLocalizedMessage();
        if (mView == null) {
            return;
        }
        if (isShowErrorState) {
            mView.stateError(message);
        }
    }
}