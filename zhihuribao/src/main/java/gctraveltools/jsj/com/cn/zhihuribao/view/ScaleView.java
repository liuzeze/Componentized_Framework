package gctraveltools.jsj.com.cn.zhihuribao.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/1/17	10:25	    刘泽			    新增 类
 * 2018/1/17	10:25	    刘泽			    增加yyy属性
 */

public class ScaleView extends FrameLayout {
    private float mScale = 1;
    private double mSqrt;
    private double mStartSqrt;
    private View mChildView;
    private ScaleGestureDetector mScaleGestureDetector;

    public ScaleView(@NonNull Context context) {
        super(context);
    }

    public ScaleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return false;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getChildCount() == 0) {
            throw new RuntimeException("please add child view!");
        }
        mChildView = getChildAt(0);

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mScaleGestureDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev);
    }

}
