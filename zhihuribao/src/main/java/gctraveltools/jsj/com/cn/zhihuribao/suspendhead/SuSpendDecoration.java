package gctraveltools.jsj.com.cn.zhihuribao.suspendhead;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

import java.util.ArrayList;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/2/12	10:28	    刘泽			    新增 类
 * 2018/2/12	10:28	    刘泽			    增加yyy属性
 */
public class SuSpendDecoration extends ItemDecoration {

    private ArrayList<SuspendBean> data;

    public SuSpendDecoration(ArrayList<SuspendBean> datas) {
        data = datas;
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (data.size() == 0) {
            return;
        }
        Paint paint = new Paint();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            SuspendBean groupinfo = data.get(index);
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            //屏幕上第一个可见的 ItemView 时，i == 0;
            if (i != 0) {
                //只组内的第一个ItemView之上才绘制
                if (index - 1 >= 0) {
                    SuspendBean suspendBean = data.get(index - 1);
                    if (!groupinfo.letter.equals(suspendBean.letter)) {
                        int top = view.getTop() - 50;
                        int bottom = view.getTop(); //绘制Header
                        paint.setColor(Color.parseColor("#ffffff"));
                        c.drawRect(left, top, right, bottom, paint);
                        paint.setColor(Color.BLACK);
                        Rect rectOver = new Rect();
                        paint.setTextSize(30);

                        paint.getTextBounds(groupinfo.letter, 0, groupinfo.letter.length(), rectOver);
                        c.drawText(groupinfo.letter, 30 + left, bottom - (50 - rectOver.height()) / 2, paint);
                    }
                }
            } else {
                //当 ItemView 是屏幕上第一个可见的View 时，不管它是不是组内第一个View
                //它都需要绘制它对应的 StickyHeader。
                // 还要判断当前的 ItemView 是不是它组内的最后一个 View
                int top = parent.getPaddingTop();
                if (index + 1 < data.size()) {
                    SuspendBean suspendBean = data.get(index + 1);
                    if (!groupinfo.letter.equals(suspendBean.letter)) {
                        int suggestTop = view.getBottom() - 50;
                        // 当 ItemView 与 Header 底部平齐的时候，判断 Header 的顶部是否小于
                        // parent 顶部内容开始的位置，如果小于则对 Header.top 进行位置更新，
                        //否则将继续保持吸附在 parent 的顶部
                        System.out.println("bottom   " + suggestTop + "  top " + top);
                      if (suggestTop < top) {
                            top = suggestTop;
                        }
                    }
                }
                int bottom = top + 50;
                paint.setColor(Color.parseColor("#ffffff"));
                c.drawRect(left, top , right, bottom , paint);
                paint.setColor(Color.BLACK);
                Rect rectOver = new Rect();
                paint.setTextSize(30);
                paint.getTextBounds(groupinfo.letter, 0, groupinfo.letter.length(), rectOver);
                c.drawText(groupinfo.letter, 30 + left, bottom - (50 - rectOver.height()) / 2, paint);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (data == null || data.size() == 0) {
            return;
        }
        int adapterPosition = parent.getChildAdapterPosition(view);
        SuspendBean beanByPosition = data.get(adapterPosition);
        if (beanByPosition == null) {
            return;
        }
        String preTage = "";
        String tage = beanByPosition.letter;
        //一定要记住这个 >= 0
        if (adapterPosition - 1 >= 0) {
            SuspendBean nextBean = data.get(adapterPosition - 1);
            if (nextBean == null) {
                return;
            }
            preTage = nextBean.letter;
        }
        if (!preTage.equals(tage)) {
            outRect.top = 50;
        } else {
            //这个目的是留出分割线
            outRect.top = 2;
        }
    }
}