package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsBean;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class ZHListAdapter extends BaseQuickAdapter<NewsBean.StoriesEntity, BaseViewHolder> {
    public ZHListAdapter(@Nullable List<NewsBean.StoriesEntity> data) {
        super(R.layout.item_zh_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean.StoriesEntity item) {
        helper.setText(R.id.title, item.getTitle());
        if (item.getImages().size() > 0) {
            ((SimpleDraweeView) helper.getView(R.id.icon)).setImageURI(item.getImages().get(0));
        }
    }

}
