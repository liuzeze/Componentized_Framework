package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.view.CalendarBean;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class CalendarAdapter extends BaseQuickAdapter<CalendarBean, BaseViewHolder> {
    public CalendarAdapter(@Nullable List<CalendarBean> data) {
        super(R.layout.item_calendar, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CalendarBean item) {
        helper.setText(R.id.week,  item.week);
        helper.setText(R.id.title, item.month + "月" + item.day + "日" );
        helper.setText(R.id.des, item.des );
    }

}
