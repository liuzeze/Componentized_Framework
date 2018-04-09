package gctraveltools.jsj.com.cn.commonlib.widget.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2016/7/18	13:23	    刘泽			    新增 类
 * 2016/7/18	13:23	    刘泽			    recycleView 的基类holder
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    protected T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getBinding() {
        return this.mBinding;
    }
}
