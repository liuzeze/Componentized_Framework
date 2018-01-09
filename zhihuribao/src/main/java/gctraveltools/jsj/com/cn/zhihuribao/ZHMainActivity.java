package gctraveltools.jsj.com.cn.zhihuribao;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.zhihuribao.Base.BaseZHActivity;
import gctraveltools.jsj.com.cn.zhihuribao.adapter.ZHListAdapter;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsBean;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuContract;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuPresenter;
import gctraveltools.jsj.com.cn.zhihuribao.view.RecyclerViewDecoration;

@Route(path = ARouterPath.ZhiHUAty)
public class ZHMainActivity extends BaseZHActivity<ZhiHuPresenter> implements ZhiHuContract.View {

    private RecyclerView mRecyclerview;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private List<NewsBean.StoriesEntity> mStories = new ArrayList<>();
    private ZHListAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

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
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mTextView = (TextView) findViewById(R.id.textview);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(ZHMainActivity.this));
        mAdapter = new ZHListAdapter(mStories);
        RecyclerViewDecoration itemDecoration = new RecyclerViewDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerview.addItemDecoration(itemDecoration);

        mRecyclerview.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mAdapter.isFirstOnly(false);//init firstOnly state
        mPresenter.getZhiHuNews();


        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ZHNewsDetailActivity.class);
                intent.putExtra("ZHIHUNEWSDETAIL", mStories.get(position).getId() + "");
                startActivity(intent);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getZhiHuNews();

            }
        });


        //观察数据变化来刷新UI
        mPresenter.getLiveObservableData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newsData) {
                System.out.println("页面销毁了");

                mProgressBar.setVisibility(View.GONE);
                NewsBean newsBean = new Gson().fromJson(newsData, NewsBean.class);
                mStories.clear();
                mStories.addAll(newsBean.getStories());
                mAdapter.setNewData(mStories);
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false
                    );
                }
            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {
        mProgressBar.setVisibility(View.GONE);
        mTextView.setText(msg);

    }

    @Override
    public void stateError(String message) {
        mProgressBar.setVisibility(View.GONE);
        mTextView.setText(message);

    }

    @Override
    public void showImgsContent(String news) {
        mProgressBar.setVisibility(View.GONE);
        NewsBean newsBean = new Gson().fromJson(news, NewsBean.class);
        mStories.clear();
        mStories.addAll(newsBean.getStories());
        mAdapter.setNewData(mStories);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false
            );
        }
    }
}
