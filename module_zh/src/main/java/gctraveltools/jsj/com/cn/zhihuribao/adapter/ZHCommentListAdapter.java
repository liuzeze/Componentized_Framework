package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsCommentBean;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class ZHCommentListAdapter extends BaseQuickAdapter<NewsCommentBean.CommentsEntity, BaseViewHolder> {
    public ZHCommentListAdapter(@Nullable List<NewsCommentBean.CommentsEntity> data) {
        super(R.layout.item_zh_comment_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsCommentBean.CommentsEntity item) {
        helper.setText(R.id.title, item.getAuthor());
        helper.setText(R.id.des, item.getContent());

        ((SimpleDraweeView) helper.getView(R.id.icon)).setImageURI(item.getAvatar());

    }

}
