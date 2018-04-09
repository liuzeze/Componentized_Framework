package gctraveltools.jsj.com.cn.demomodule.fangdajing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/3/30	11:01	    刘泽			    新增 类
 * 2018/3/30	11:01	    刘泽			    增加yyy属性
 */

public class MagnifyingView extends View {
    private Path mPath = new Path();
    private Matrix matrix = new Matrix();
    private Bitmap bitmap;
    //放大镜的半径
    private static final int RADIUS = 80;
    //放大倍数
    private static final int FACTOR = 2;
    private int mCurrentX, mCurrentY;

    public MagnifyingView(Context context) {
        super(context);
        mPath.addCircle(RADIUS, RADIUS, RADIUS, Path.Direction.CW);
        matrix.setScale(FACTOR, FACTOR);

    }

    public MagnifyingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPath.addCircle(RADIUS, RADIUS, RADIUS, Path.Direction.CW);
        matrix.setScale(FACTOR, FACTOR);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = (int) event.getX();
        mCurrentY = (int) event.getY();

        invalidate();
        return true;
    }

    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            //底图
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            canvas.drawBitmap(bitmap, 0, 0, paint);
            //剪切
            canvas.translate(mCurrentX - RADIUS, mCurrentY - RADIUS*4);
            canvas.clipPath(mPath);
            //画放大后的图
            canvas.translate(RADIUS - mCurrentX * FACTOR, RADIUS - mCurrentY * FACTOR);
            paint.setColor(Color.BLACK);
            canvas.drawBitmap(bitmap, matrix, paint);
        }
    }
}
