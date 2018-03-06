package gctraveltools.jsj.com.cn.zhihuribao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/2/1	17:08	    刘泽			    新增 类
 * 2018/2/1	17:08	    刘泽			    增加yyy属性
 */

public class SynScrollerview extends HorizontalScrollView {
    private Observerable sObserverable = new Observerable();

    public SynScrollerview(Context context) {
        super(context);
    }

    public SynScrollerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SynScrollerview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (sObserverable != null) {
            sObserverable.notifiItemView(l, t, oldl, oldt);
        }

    }


    public void setOnScrollListener(OnscrollViewPosition listener) {
        if (sObserverable != null) {
            sObserverable.setListener(listener);
        }
    }

    public interface OnscrollViewPosition {
        void OnScroll(int l, int t, int oldl, int oldt);
    }

    class Observerable {

        private final ArrayList<OnscrollViewPosition> mOnscrollViewPositions;

        public Observerable() {
            mOnscrollViewPositions = new ArrayList<>();
        }

        private void setListener(OnscrollViewPosition listener) {
            mOnscrollViewPositions.add(listener);
        }


        private void notifiItemView(int l, int t, int oldl, int oldt) {
            if (mOnscrollViewPositions != null) {
                for (OnscrollViewPosition viewlistener : mOnscrollViewPositions) {
                    viewlistener.OnScroll(l, t, oldl, oldt);
                }
            }
        }
    }
}
