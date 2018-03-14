package gctraveltools.jsj.com.cn.zhihuribao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/3/14	12:08	    刘泽			    新增 类
 * 2018/3/14	12:08	    刘泽			    增加yyy属性
 */

public class PictureView extends View {

    private Paint mPicturePaint;
    private int mHeightSize;
    private int mWidthSize;
    private OnSelectListener mListener;
    private Paint mTextPaint;
    private int mSelectPosition = -1;

    public PictureView(Context context) {
        this(context, null);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPicturePaint = new Paint();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(15);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        mHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(mWidthSize, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(mHeightSize + 100, MeasureSpec.EXACTLY));
    }


    //柱状图数量
    private ArrayList<PrictureBean> items = new ArrayList<>();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (items.size() == 0) {
            return;
        }
        int width = (mWidthSize - getPaddingRight() - getPaddingLeft()) / items.size();
        for (int i = 0; i < items.size(); i++) {
            PrictureBean prictureBean = items.get(i);
            float priceTextHeight = mPicturePaint.measureText(prictureBean.PriceDes) / 2;
            float timeTextHeight = mPicturePaint.measureText(prictureBean.time) / 2;
            float left = width * i + getPaddingLeft();
            float top = mHeightSize * (1 - prictureBean.Percentage);
            top = top == 0 ? top + priceTextHeight * 4 : top;
            float right = left + width;
            float bottom = mHeightSize;

            mTextPaint.setColor(Color.BLACK);
            if (prictureBean.isLowProce) {
                mTextPaint.setColor(Color.RED);
            }
            if (mSelectPosition == i) {
                mTextPaint.setColor(Color.BLUE);
            }

            canvas.drawText(prictureBean.PriceDes + i, left + width / 2 - priceTextHeight, top - priceTextHeight, mTextPaint);

            mPicturePaint.setColor(Color.BLUE);
            if (mSelectPosition == i) {
                mPicturePaint.setColor(Color.GREEN);
            }
            canvas.drawRect(left + 5, top, right, bottom - timeTextHeight * 3, mPicturePaint);


            mTextPaint.setColor(Color.BLACK);
            if (i == 0) {
                canvas.drawText(prictureBean.time + i, left, bottom, mTextPaint);
                canvas.drawText(prictureBean.time + i, right - timeTextHeight, bottom, mTextPaint);
            }
            if (i == items.size() - 1) {
                canvas.drawText(prictureBean.time + i, right - timeTextHeight * 2, bottom, mTextPaint);
            } else {
                canvas.drawText(prictureBean.time + i, right - timeTextHeight, bottom, mTextPaint);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (items.size() == 0) {
            return false;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX();
            float y = event.getY();
            int width = (mWidthSize - getPaddingRight() - getPaddingLeft()) / items.size();
            for (int i = 0; i < items.size(); i++) {
                PrictureBean prictureBean = items.get(i);
                float priceTextHeight = mPicturePaint.measureText(prictureBean.PriceDes) / 2;
                float left = width * i + getPaddingLeft();
                float top = mHeightSize * (1 - prictureBean.Percentage);
                top = top == 0 ? top + priceTextHeight * 4 : top;
                float right = left + width;
                float bottom = mHeightSize;
                if (x > left && x < right && y > top && y < bottom && mSelectPosition != i) {
                    if (mListener != null) {
                        mSelectPosition = i;
                        mListener.select(mSelectPosition);
                        invalidate();
                    }
                    break;
                }
            }
        }

        return true;
    }


    public void setItems(ArrayList<PrictureBean> items, int selectPosition) {
        this.items = items;
        this.mSelectPosition = selectPosition;
        if (mListener != null) {
            mListener.select(selectPosition);
        } else {
            throw new IllegalStateException("必须先注册选中监听.");
        }
        invalidate();
    }

    public void setOnSelectListener(OnSelectListener listener) {
        mListener = listener;
    }

    public interface OnSelectListener {
        void select(int position);
    }
}
