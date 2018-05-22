package gctraveltools.jsj.com.cn.demomodule.downfnish;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/1/16	17:00	    刘泽			    新增 类
 * 2018/1/16	17:00	    刘泽			    增加yyy属性
 */

public class TouchViewGroup extends FrameLayout {
    private View mChildView;
    private float mStartY;
    private float mStartX;
    private OnFnishListener mListener;

    public TouchViewGroup(@NonNull Context context) {
        super(context);
    }

    public TouchViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getChildCount() == 0) {
            throw new RuntimeException("please add child view!");
        }
        mChildView = getChildAt(0);
    }

    public TouchViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TouchViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //  return super.onInterceptTouchEvent(ev);//true  拦截自己消费  false  传递

        return false;

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int pointerCount = ev.getPointerCount();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartY = ev.getY();
                mStartX = ev.getX();
                break;

            case MotionEvent.ACTION_MOVE:
                if (pointerCount == 1) {
                    float endY = ev.getY();
                    float endX = ev.getX();
                    if (endY - mStartY > 100 && Math.abs(endX - mStartX) < 100 || mChildView.getTranslationY() > 0) {
                        mChildView.setTranslationY((endY - mStartY - 100) < 0 ? 0 : (endY - mStartY - 100));
                        return true;
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                mStartY = 0;
                mStartX = 0;
                if (mChildView.getTranslationY() > 800) {
                    if (mListener != null) {
                        mListener.onFinish();
                    }
                } else {
                    mChildView.setTranslationY(0);
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setOnFinishListener(OnFnishListener listener) {
        mListener = listener;

    }

    public interface OnFnishListener {
        void onFinish();
    }
}
