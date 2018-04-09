package gctraveltools.jsj.com.cn.demomodule.suspendhead;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gctraveltools.jsj.com.cn.demomodule.R;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/2/12	9:41	    刘泽			    新增 类
 * 2018/2/12	9:41	    刘泽			    增加yyy属性
 */

class SuspendHeadAdapter extends BaseQuickAdapter<SuspendBean, BaseViewHolder> {

    public SuspendHeadAdapter(@Nullable List<SuspendBean> data) {
        super(R.layout.item_suspend_head, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SuspendBean item) {
        helper.setText(R.id.tv_name, item.name);

    }
}