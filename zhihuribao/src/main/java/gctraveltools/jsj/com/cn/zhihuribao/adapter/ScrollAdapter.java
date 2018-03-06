package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.view.SynScrollerview;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/2/1	16:55	    刘泽			    新增 类
 * 2018/2/1	16:55	    刘泽			    增加yyy属性
 */

public class ScrollAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private final SynScrollerview mSynScrollerview;

    public ScrollAdapter(@Nullable List<String> data, SynScrollerview synScrollerview) {
        super(R.layout.item_scroll_layout, data);
        mSynScrollerview = synScrollerview;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
        final SynScrollerview synScrollerview = helper.getView(R.id.synscrollerview);
        mSynScrollerview.setOnScrollListener(new SynScrollerview.OnscrollViewPosition() {
            @Override
            public void OnScroll(int l, int t, int oldl, int oldt) {
                synScrollerview.smoothScrollTo(l, 0);
            }
        });
    }
}
