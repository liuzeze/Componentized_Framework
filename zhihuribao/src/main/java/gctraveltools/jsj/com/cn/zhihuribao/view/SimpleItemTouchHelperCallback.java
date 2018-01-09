package gctraveltools.jsj.com.cn.zhihuribao.view;

import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.ViewGroup;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/29	12:13	    刘泽			    新增 类
 * 2017/12/29	12:13	    刘泽			    recycleview 辅助回调  可以做侧滑或者拖拽
 */

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private final ItemTouchHelperInterFace mTouchHelperInterFace;

    public SimpleItemTouchHelperCallback(ItemTouchHelperInterFace touchHelperInterFace) {
        mTouchHelperInterFace = touchHelperInterFace;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 这里可以根据layoutmanage的 不同来做操作   指定移动的方向
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            final int swipeFlags = ItemTouchHelper.LEFT;
            return makeMovementFlags(dragFlags, swipeFlags);
        } else {
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            final int swipeFlags = 0;
            return makeMovementFlags(dragFlags, swipeFlags);
        }
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (mTouchHelperInterFace != null) {
            mTouchHelperInterFace.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());

        }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (mTouchHelperInterFace != null) {
            mTouchHelperInterFace.onItemDissmiss(viewHolder.getAdapterPosition());

        }
    }

  /*  @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }*/

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        //重置改变，防止由于复用而导致的显示问题
        viewHolder.itemView.setScrollX(0);
        if (mTouchHelperInterFace != null) {
            mTouchHelperInterFace.clearView(viewHolder);

        }
    }

    //限制ImageView长度所能增加的最大值
    private double ICON_MAX_SIZE = 550;

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //仅对侧滑状态下的效果做出改变
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            //如果dX小于等于删除方块的宽度，那么我们把该方块滑出来
            if (Math.abs(dX) <= getSlideLimitation(viewHolder)) {
                viewHolder.itemView.scrollTo(-(int) dX, 0);
            }
            //如果dX还未达到能删除的距离，此时慢慢增加“眼睛”的大小，增加的最大值为ICON_MAX_SIZE
            else if (Math.abs(dX) <= recyclerView.getWidth() / 2) {
                double distance = (recyclerView.getWidth() / 2 - getSlideLimitation(viewHolder));
                double factor = ICON_MAX_SIZE / distance;
                double diff = (Math.abs(dX) - getSlideLimitation(viewHolder)) * factor;
                if (diff >= ICON_MAX_SIZE) {
                    diff = ICON_MAX_SIZE;
                }
                if (mTouchHelperInterFace != null) {
                    mTouchHelperInterFace.onChildDraw(viewHolder, diff);

                }
            }
        } else {
            //拖拽状态下不做改变，需要调用父类的方法
           // super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    }


    /**
     * 获取删除方块的宽度
     */
    public int getSlideLimitation(RecyclerView.ViewHolder viewHolder) {
        ViewGroup viewGroup = (ViewGroup) viewHolder.itemView;
        return viewGroup.getChildAt(1).getLayoutParams().width;
    }

}
