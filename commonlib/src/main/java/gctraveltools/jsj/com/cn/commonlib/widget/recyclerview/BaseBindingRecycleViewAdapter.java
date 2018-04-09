package gctraveltools.jsj.com.cn.commonlib.widget.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2016/7/17	13:23	    李佳欣			    列表适配器
 * 2016/7/18	13:23	    刘泽			    扩展适用于databinding
 */
public abstract class BaseBindingRecycleViewAdapter<K, T extends ViewDataBinding> extends RecyclerView.Adapter<BindingViewHolder<T>> {


    private final int mResLayoutId;
    private List<K> mData;

    public BaseBindingRecycleViewAdapter(int resLayoutId, List<K> data) {
        mResLayoutId = resLayoutId;
        mData = data;
    }

    @Override
    public BindingViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        //进行判断显示类型，来创建返回不同的View
        return new BindingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mResLayoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<T> holder, int position) {
        // 给ViewHolder跟布局设置tag (position),条目点击事件
        holder.itemView.setTag(position);
        onSubBindViewHolder(holder, mData.get(position));
        holder.getBinding().executePendingBindings();
        registerLisenter(holder, position);
    }

    /**
     * 注册条目监听
     *
     * @param holder
     * @param position
     */
    private void registerLisenter(BindingViewHolder<T> holder, final int position) {
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 定义bindView
     *
     * @param
     * @param holder
     **/
    public abstract void onSubBindViewHolder(BindingViewHolder<T> holder, final K item);

    /**
     * 获取列表数据
     *
     * @return
     */
    public List<K> getData() {
        return mData;
    }

    public void setNewData(List<K> newData) {
        mData = newData == null ? new ArrayList<K>() : newData;
        notifyDataSetChanged();
    }

    /**
     * 我们自己添加的OnItemClickListener
     */
    protected OnItemClickListener mOnItemClickListener;//条目点击监听

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }



/*


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }
*/

}

