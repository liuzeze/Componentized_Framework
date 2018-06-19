package com.printer.module_interception.ui;


import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.printer.module_interception.R;

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-06-12       创建class
 */
public class FloatView implements View.OnTouchListener {

    private String TAG = "FloatView";

    private float mTouchStartX;
    private float mTouchStartY;
    private float x;
    private float y;
    //定义浮动窗口布局
    FrameLayout mFloatLayout;
    WindowManager.LayoutParams wmParams;
    //创建浮动窗口设置布局参数的对象
    WindowManager mWindowManager;
    private Context mContext;
    static FloatView mFloatView = new FloatView();

    private FloatView() {
    }

    public static FloatView getInstance() {
        return mFloatView;
    }

    public void init(Context context) {
        mContext = context;
        onRemoveView();
        createFloatView(context);
    }

    public void onRemoveView() {
        try {
            if (mFloatLayout != null) {
                mWindowManager.removeView(mFloatLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createFloatView(Context context) {
        if (mFloatLayout != null) {
            return;
        }
        wmParams = new WindowManager.LayoutParams();
        mWindowManager = (WindowManager) context.getApplicationContext().getSystemService(context.getApplicationContext().WINDOW_SERVICE);
        wmParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        //设置图片格式，效果为背景透明
        wmParams.format = PixelFormat.RGBA_8888;
        //设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        wmParams.format = PixelFormat.TRANSLUCENT;

        //调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;

        // 以屏幕左上角为原点，设置x、y初始值
        wmParams.x = mWindowManager.getDefaultDisplay().getWidth();
        wmParams.y = 25;

        //设置悬浮窗口长宽数据
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        //获取浮动窗口视图所在布局
        mFloatLayout = (FrameLayout) inflater.inflate(R.layout.float_view, null);
        //添加mFloatLayout
        mWindowManager.addView(mFloatLayout, wmParams);

        //浮动窗口按钮
        mFloatLayout.setOnTouchListener(this);

        mFloatLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        mFloatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("setOnClickListener");
                NetworkFeedActivity.start(mContext);
            }
        });
    }

    private float StartX;
    private float StartY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //获取相对屏幕的坐标，即以屏幕左上角为原点
        x = event.getRawX();
        y = event.getRawY() - 25;
        Log.i("currP", "currX" + x + "====currY" + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //获取相对View的坐标，即以此View左上角为原点
                mTouchStartX = event.getX();
                mTouchStartY = event.getY();
                StartX = x;
                StartY = y;
                Log.i("startP", "startX" + mTouchStartX + "====startY" + mTouchStartY);

                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(x - StartX) > 5 && Math.abs(y - StartY) > 5) {
                    updateViewPosition();
                }
                break;

            case MotionEvent.ACTION_UP:
                if (Math.abs(x - StartX) > 5 && Math.abs(y - StartY) > 5) {
                } else {
                    v.performClick();
                }
                // updateViewPosition();
                // 抬起手指时让floatView紧贴屏幕左右边缘
                wmParams.x = wmParams.x <= (mWindowManager.getDefaultDisplay().getWidth() / 2) ? 0 : mWindowManager.getDefaultDisplay().getWidth();
                wmParams.y = (int) (y - mTouchStartY);
                mWindowManager.updateViewLayout(mFloatLayout, wmParams);

                mTouchStartX = mTouchStartY = 0;

                break;
        }
        return true;
    }

    private void updateViewPosition() {
        //更新浮动窗口位置参数
        wmParams.x = (int) (x - mTouchStartX);
        wmParams.y = (int) (y - mTouchStartY);
        mWindowManager.updateViewLayout(mFloatLayout, wmParams);
    }
}