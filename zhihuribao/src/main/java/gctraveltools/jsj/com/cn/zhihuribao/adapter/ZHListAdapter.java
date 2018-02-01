package gctraveltools.jsj.com.cn.zhihuribao.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.BR;
import gctraveltools.jsj.com.cn.zhihuribao.R;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsBean;
import gctraveltools.jsj.com.cn.zhihuribao.databinding.ItemZhListBinding;
import gctraveltools.jsj.com.cn.zhihuribao.recyclerview.BaseBindingRecycleViewAdapter;
import gctraveltools.jsj.com.cn.zhihuribao.recyclerview.BindingViewHolder;
import gctraveltools.jsj.com.cn.zhihuribao.view.ItemTouchHelperInterFace;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:01	    刘泽			    新增 类
 * 2017/12/28	14:01	    刘泽			    增加yyy属性
 */

public class ZHListAdapter extends BaseBindingRecycleViewAdapter<NewsBean.StoriesEntity, ItemZhListBinding> implements ItemTouchHelperInterFace {
    public ZHListAdapter(@Nullable List<NewsBean.StoriesEntity> data) {
        super(R.layout.item_zh_list, data);
    }

    @Override
    public void onSubBindViewHolder(BindingViewHolder<ItemZhListBinding> holder, NewsBean.StoriesEntity item) {
        ItemZhListBinding binding = holder.getBinding();
        binding.setVariable(BR.title, item.getTitle());
        if (item.getImages().size() > 0) {
            binding.icon.setImageURI(item.getImages().get(0));
        }
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        List<NewsBean.StoriesEntity> data = getData();
        Collections.swap(data, fromPosition, toPosition);//交换数据
        notifyItemMoved(fromPosition, toPosition);//条目移动
    }

    @Override
    public void onItemDissmiss(int position) {
        List<NewsBean.StoriesEntity> data = getData();
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
