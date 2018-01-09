package gctraveltools.jsj.com.cn.douban.adapter;

import android.support.annotation.Nullable;
import android.widget.RatingBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieListBean;
import gctraveltools.jsj.com.cn.douban.R;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class DouBanMovieListAdapter extends BaseQuickAdapter<MovieListBean.SubjectsEntity, BaseViewHolder> {
    public DouBanMovieListAdapter(@Nullable List<MovieListBean.SubjectsEntity> data) {
        super(R.layout.item_douban_movie_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieListBean.SubjectsEntity item) {
        helper.setText(R.id.textView2, item.getTitle());
        helper.setText(R.id.textView3, item.getRating().getAverage() + "");
        helper.setText(R.id.textView4, "导演:" + (item.getDirectors().size() > 0 ? item.getDirectors().get(0).getName() : ""));
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < item.getCasts().size(); i++) {
            if (i == item.getCasts().size() - 1) {
                name.append(item.getCasts().get(i).getName());
            } else {
                name.append(item.getCasts().get(i).getName() + "/");
            }
        }
        helper.setText(R.id.textView5, "主演:" + name);
        helper.setText(R.id.textView6, item.getCollectCount() + "人看过");
        ((RatingBar) helper.getView(R.id.ratingBar)).setRating((float) (item.getRating().getAverage()/2));
        ((SimpleDraweeView) helper.getView(R.id.simpledraweeview)).setImageURI(item.getImages().getSmall());

    }

}
