package gctraveltools.jsj.com.cn.zhihuribao;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.commonlib.util.ToastUtils;
import gctraveltools.jsj.com.cn.zhihuribao.Base.BaseZHActivity;
import gctraveltools.jsj.com.cn.zhihuribao.adapter.ZHListAdapter;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsBean;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuContract;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuPresenter;
import gctraveltools.jsj.com.cn.commonlib.widget.recyclerview.BaseBindingRecycleViewAdapter;
import gctraveltools.jsj.com.cn.commonlib.widget.recyclerview.RecyclerViewDecoration;
import gctraveltools.jsj.com.cn.commonlib.widget.recyclerview.SimpleItemTouchHelperCallback;

@Route(path = ARouterPath.ZhiHUAty)
public class ZHMainActivity extends BaseZHActivity<ZhiHuPresenter> implements ZhiHuContract.View {

    private RecyclerView mRecyclerview;
    private ProgressBar mProgressBar;
    private List<NewsBean.StoriesEntity> mStories = new ArrayList<>();
    private ZHListAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_zhmain;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(ZHMainActivity.this));
        mAdapter = new ZHListAdapter(mStories);
        RecyclerViewDecoration itemDecoration = new RecyclerViewDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerview.addItemDecoration(itemDecoration);
        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mRecyclerview);

        mRecyclerview.setAdapter(mAdapter);
        // mAdapter.openLoadAnimation(new ScaleInAnimation());
        // mAdapter.isFirstOnly(false);//init firstOnly state
        mPresenter.getZhiHuNews();

        mAdapter.setOnItemClickListener(new BaseBindingRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(mActivity, ZHNewsDetailActivity.class);
                intent.putExtra("ZHIHUNEWSDETAIL", mStories.get(position).getId() + "");
                startActivity(intent);
            }
        });

        //观察数据变化来刷新UI
        mPresenter.getLiveObservableData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newsData) {

                mProgressBar.setVisibility(View.GONE);
                NewsBean newsBean = new Gson().fromJson(newsData, NewsBean.class);
                mStories.clear();
                mStories.addAll(newsBean.getStories());
                mAdapter.setNewData(mStories);

            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {
        mProgressBar.setVisibility(View.GONE);
        ToastUtils.showShort(msg);

    }



    @Override
    public void showImgsContent(String news) {
        mProgressBar.setVisibility(View.GONE);
        NewsBean newsBean = new Gson().fromJson(news, NewsBean.class);
        mStories.clear();
        mStories.addAll(newsBean.getStories());
        mAdapter.setNewData(mStories);

    }
}
