package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collections;
import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsCommentBean;
import gctraveltools.jsj.com.cn.zhihuribao.view.ItemTouchHelperInterFace;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class ZHCommentListAdapter extends BaseQuickAdapter<NewsCommentBean.CommentsEntity, BaseViewHolder>implements ItemTouchHelperInterFace {
    public ZHCommentListAdapter(@Nullable List<NewsCommentBean.CommentsEntity> data) {
        super(R.layout.item_zh_comment_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsCommentBean.CommentsEntity item) {
        helper.setText(R.id.title, item.getAuthor());
        helper.setText(R.id.des, item.getContent());

        ((SimpleDraweeView) helper.getView(R.id.icon)).setImageURI(item.getAvatar());

    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        List<NewsCommentBean.CommentsEntity> data = getData();
        Collections.swap(data, fromPosition, toPosition);//交换数据
        notifyItemMoved(fromPosition, toPosition);//条目移动
    }

    @Override
    public void onItemDissmiss(int position) {
        List<NewsCommentBean.CommentsEntity> data = getData();
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void clearView(RecyclerView.ViewHolder viewHolder) {
        ((TextView) viewHolder.itemView.findViewById(R.id.tv_text)).setText("左滑删除");
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.iv_img);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        params.width = 150;
        params.height = 150;
        imageView.setLayoutParams(params);
        imageView.setVisibility(View.INVISIBLE);
    }


    //ImageView的初始长宽
    private int fixedWidth = 150;
    @Override
    public void onChildDraw(RecyclerView.ViewHolder viewHolder, double diff) {

        TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.tv_text);
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.iv_img);
        textView.setText("");   //把文字去掉
        textView.setVisibility(View.VISIBLE);  //显示眼睛
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        params.width = (int) (fixedWidth + diff);
        params.height = (int) (fixedWidth + diff);
        imageView.setLayoutParams(params);
    }

}
