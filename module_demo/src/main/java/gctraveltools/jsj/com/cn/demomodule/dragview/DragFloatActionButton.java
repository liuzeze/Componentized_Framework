package gctraveltools.jsj.com.cn.demomodule.dragview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

import java.util.Calendar;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/4/8	10:14	    刘泽			    新增 类
 * 2018/4/8	10:14	    刘泽			    增加yyy属性
 */
public class DragFloatActionButton extends ImageView {


    private long mDowmTime;
    private float mX;
    private float mY;
    private int parentHeight;
    private int parentWidth;

    public DragFloatActionButton(Context context) {
        super(context);
        init();
    }

    public DragFloatActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragFloatActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    private int lastX;
    private int lastY;

    private boolean isDrag;

    @Override
    public void setOnLongClickListener(@Nullable OnLongClickListener l) {
        l.onLongClick(this);
        isDrag = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                isDrag = false;
                getParent().requestDisallowInterceptTouchEvent(true);
                lastX = rawX;
                lastY = rawY;
                mX = event.getX();
                mY = event.getY();
                mDowmTime = getCurrentTime();
                ViewGroup parent;
                if (getParent() != null) {
                    parent = (ViewGroup) getParent();
                    parentHeight = parent.getHeight();
                    parentWidth = parent.getWidth();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                //检测是否长按,在非长按时检测
                if (!isDrag) {
                    isDrag = isLongPressed(mX, mY, event.getX(), event.getY(), mDowmTime, getCurrentTime(), 500);
                }
                //计算手指移动了多少
                int dx = rawX - lastX;
                int dy = rawY - lastY;
                //这里修复一些华为手机无法触发点击事件的问题
                int distance = (int) Math.sqrt(dx * dx + dy * dy);
                if (distance == 0) {
                    isDrag = false;
                    break;
                }
                if (isDrag) {
                    float x = getX() + dx;
                    float y = getY() + dy;
                    //检测是否到达边缘 左上右下
                    x = x < 0 ? 0 : x > parentWidth - getWidth() ? parentWidth - getWidth() : x;
                    y = getY() < 0 ? 0 : getY() + getHeight() > parentHeight ? parentHeight - getHeight() : y;
                    Logger.e("x距离" + dy);
                    y = y < 0 ? 0 : y;
                    y = y > parentHeight - getHeight() ? parentHeight - getHeight() : y;


                    setX(x);
                    setY(y);
                    lastX = rawX;
                    lastY = rawY;
                }

                //Log.i("getX="+getX()+";getY="+getY()+";screenHeight="+screenHeight);
                break;
            case MotionEvent.ACTION_UP:
                if (isDrag) {
                    isDrag = false;
                    //恢复按压效果
                    setPressed(false);
                    if (rawX >= parentWidth / 2) {
                        animate().setInterpolator(new DecelerateInterpolator())
                                .setDuration(500)
                                .xBy(parentWidth - getWidth() - getX())
                                .start();
                    } else {
                        ObjectAnimator oa = ObjectAnimator.ofFloat(this, "x", getX(), 0);
                        oa.setInterpolator(new DecelerateInterpolator());
                        oa.setDuration(500);
                        oa.start();
                    }
                }
                mX = 0;
                mY = 0;
                lastX = 0;
                lastY = 0;
                break;

            default:
                break;
        }
        //如果是拖拽则消耗事件，否则正常传递即可。
        return isDrag || super.onTouchEvent(event);
    }

    /**
     * * 判断是否有长按动作发生 * @param lastX 按下时X坐标 * @param lastY 按下时Y坐标 *
     *
     * @param thisX         移动时X坐标 *
     * @param thisY         移动时Y坐标 *
     * @param lastDownTime  按下时间 *
     * @param thisEventTime 移动时间 *
     * @param longPressTime 判断长按时间的阀值
     */
    static boolean isLongPressed(float lastX, float lastY, float thisX,
                                 float thisY, long lastDownTime, long thisEventTime,
                                 long longPressTime) {
        float offsetX = Math.abs(thisX - lastX);
        float offsetY = Math.abs(thisY - lastY);
        long intervalTime = thisEventTime - lastDownTime;
        Logger.e("offsetX" + offsetX + "offsetY" + offsetY + "intervalTime" + intervalTime);
        if (offsetX >= 10 && offsetY >= 10 /*&& intervalTime >= longPressTime*/) {
            return true;
        }
        return false;
    }

    public static long getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
//        Logger.d("获取当前时间戳-->" + timeInMillis);
        return timeInMillis;
    }

}