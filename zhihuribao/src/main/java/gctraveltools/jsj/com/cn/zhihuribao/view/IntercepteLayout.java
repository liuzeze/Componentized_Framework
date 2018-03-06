package gctraveltools.jsj.com.cn.zhihuribao.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/2/1	17:24	    刘泽			    新增 类
 * 2018/2/1	17:24	    刘泽			    增加yyy属性
 */

public class IntercepteLayout extends LinearLayout {
    public IntercepteLayout(Context context) {
        super(context);
    }

    public IntercepteLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IntercepteLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
