package gctraveltools.jsj.com.cn.douban.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import gctraveltools.jsj.com.cn.douban.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.douban.R;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class DouBanMoviepeopleAdapter extends BaseQuickAdapter<MovieDetailBean.CastsEntity, BaseViewHolder> {
    public DouBanMoviepeopleAdapter(@Nullable List<MovieDetailBean.CastsEntity> data) {
        super(R.layout.item_douban_movie_people, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieDetailBean.CastsEntity item) {
        helper.setText(R.id.textView1, item.getName());
        try {
            ((SimpleDraweeView) helper.getView(R.id.simpledraweeview)).setImageURI(item.getAvatars().getSmall());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
