package gctraveltools.jsj.com.cn.commonlib.widget.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/29	12:06	    刘泽			    新增 类
 * 2017/12/29	12:06	    刘泽			    recycleview 侧滑 拖拽接口
 */

public interface ItemTouchHelperInterFace {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //数据删除
    void onItemDissmiss(int position);

    //重置view
    void clearView(RecyclerView.ViewHolder viewHolder);

    //滑动时第二个布局的效果
    void onChildDraw(RecyclerView.ViewHolder viewHolder, double diff);
}
