package gctraveltools.jsj.com.cn.commonlib.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/1/2	10:53	    刘泽			    新增 类
 * 2018/1/2	10:53	    刘泽			    增加yyy属性
 */

public class RecyclerViewDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;

    private int mOrientation;

    private final Rect mBounds = new Rect();

    public RecyclerViewDecoration(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        mOrientation = orientation;

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        c.save();
        int left =100;

        int right = parent.getWidth() ;
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            //获得itemView的范围，这个范围包括了margin和offset，它们被保存在mBounds当中
            parent.getDecoratedBoundsWithMargins(child, mBounds);
            //需要考虑translationY和translationY
            final int bottom = mBounds.bottom + Math.round(child.getTranslationY());
            //由于是垂直排列的，因此上边界等于下边界减去分割线的高度.
            final int top = bottom - mDivider.getIntrinsicHeight();
            //设置divider和范围
           // mDivider.setBounds(left, child.getBottom(), right, child.getBottom()-mDivider.getIntrinsicHeight());
            mDivider.setBounds(left, top, right, bottom);
            //绘制.
            mDivider.draw(c);

        }
        c.restore();
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
    }
}
