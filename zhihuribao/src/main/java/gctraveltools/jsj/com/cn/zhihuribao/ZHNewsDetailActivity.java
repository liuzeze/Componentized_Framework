package gctraveltools.jsj.com.cn.zhihuribao;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import gctraveltools.jsj.com.cn.zhihuribao.Base.BaseZHActivity;
import gctraveltools.jsj.com.cn.zhihuribao.adapter.ZHCommentListAdapter;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsCommentBean;
import gctraveltools.jsj.com.cn.zhihuribao.bean.NewsDetailBean;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuDetailContract;
import gctraveltools.jsj.com.cn.zhihuribao.presenter.ZhiHuDetailPresenter;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/28	14:32	    刘泽			    新增 类
 * 2017/12/28	14:32	    刘泽			    增加yyy属性
 */

public class ZHNewsDetailActivity extends BaseZHActivity<ZhiHuDetailPresenter> implements ZhiHuDetailContract.View {

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private RecyclerView mRecyclerview;
    private ZHCommentListAdapter mAdapter;
    private List<NewsCommentBean.CommentsEntity> mComments = new ArrayList<>();

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
        NewsDetailBean newsDetailBean = new Gson().fromJson(news, NewsDetailBean.class);

        mTextView.setText(Html.fromHtml(newsDetailBean.getBody()));

    }


    @Override
    public void showComment(String news) {
        NewsCommentBean newsCommentBean = new Gson().fromJson(news, NewsCommentBean.class);
        mComments.clear();
        mComments.addAll(newsCommentBean.getComments());
        mAdapter.setNewData(mComments);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTextView = (TextView) findViewById(R.id.textview);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new ZHCommentListAdapter(mComments);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerview.addItemDecoration(itemDecoration);

        mRecyclerview.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mAdapter.isFirstOnly(false);//init firstOnly state
        mPresenter.getZhiHuNewsDetail(getIntent().getStringExtra("ZHIHUNEWSDETAIL"));
        mPresenter.getZhiHuNewsComment(getIntent().getStringExtra("ZHIHUNEWSDETAIL"));
    }
}
