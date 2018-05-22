package gctraveltools.jsj.com.cn.douban;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.List;

import gctraveltools.jsj.com.cn.douban.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.douban.adapter.DouBanMoviepeopleAdapter;
import gctraveltools.jsj.com.cn.douban.base.BaseDoubanActivity;
import gctraveltools.jsj.com.cn.douban.databinding.ActivityDoubanDetailBinding;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanDetailContract;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanDetailPresenter;

public class DoubanDetailActivity extends BaseDoubanActivity<DouBanDetailPresenter,ActivityDoubanDetailBinding> implements DouBanDetailContract.View {


    SimpleDraweeView mSimpledraweeview;
    TextView mMovieDetailHotTalk;
    CollapsingToolbarLayout mMovieDetailCollLayout;
    AppBarLayout mMovieDetailAppbar;
    TextView mMovieDetailInfoGenres;
    TextView mMovieDetailInfoOriginalTitle;
    TextView mMovieDetailInfoPubdata;
    TextView mMovieDetailInfoDurations;
    TextView mMovieDetailRatingTv;
    RatingBar mMovieDetailRatingRating;
    TextView mMovieDetailRatingCount;
    LinearLayout mMovieDetailRatingLayout;
    Button mMovieDetailBtnWatch;
    Button mMovieDetailBtnWatched;
    TextView mMovieDetailTicket;
    TextView mExpandableText;
    ImageButton mExpandCollapse;
    ExpandableTextView mMovieDetailSummary;
    RecyclerView mMovieDetailActorList;
    NestedScrollView mMovieDetailScrollview;
    private String mId;
    private String mImgurl;
    private List<MovieDetailBean.CastsEntity> mCasts = new ArrayList<>();
    private DouBanMoviepeopleAdapter mAdapter;
    private MovieDetailBean mMovieListBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_douban_detail;
    }

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        mSimpledraweeview=mBinding.simpledraweeview;
       mMovieDetailHotTalk=mBinding.movieDetailHotTalk;
        mMovieDetailCollLayout=mBinding.movieDetailCollLayout;
       mMovieDetailAppbar=mBinding.movieDetailAppbar;
      mMovieDetailInfoGenres=mBinding.content.movieDetailInfoGenres;
       mMovieDetailInfoOriginalTitle=mBinding.content.movieDetailInfoOriginalTitle;
        mMovieDetailInfoPubdata=mBinding.content.movieDetailInfoPubdata;
       mMovieDetailInfoDurations=mBinding.content.movieDetailInfoDurations;
        mMovieDetailRatingTv=mBinding.content.movieDetailRatingTv;
        mMovieDetailRatingRating=mBinding.content.movieDetailRatingRating;
       mMovieDetailRatingCount=mBinding.content.movieDetailRatingCount;
         mMovieDetailRatingLayout=mBinding.content.movieDetailRatingLayout;
       mMovieDetailBtnWatch=mBinding.content.movieDetailBtnWatch;
        mMovieDetailBtnWatched=mBinding.content.movieDetailBtnWatched;
        mMovieDetailTicket=mBinding.content.movieDetailTicket;
        mExpandableText=mBinding.content.expandableText;
        mExpandCollapse=mBinding.content.expandCollapse;
        mMovieDetailSummary=mBinding.content.movieDetailSummary;
         mMovieDetailActorList=mBinding.content.movieDetailActorList;
         mMovieDetailScrollview=mBinding.movieDetailScrollview;


        mId = getIntent().getStringExtra("id");
        mImgurl = getIntent().getStringExtra("imgurl");
        mSimpledraweeview.setImageURI(mImgurl);
        mPresenter.getMovieDetailReq(mId);

        LinearLayoutManager layout = new LinearLayoutManager(mActivity);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        mMovieDetailActorList.setLayoutManager(layout);
        mAdapter = new DouBanMoviepeopleAdapter(mCasts);
        mMovieDetailActorList.setAdapter(mAdapter);
        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MovieDetailBean.CastsEntity castsEntity = mCasts.get(position);
            }
        });
        mMovieDetailTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMovieListBean != null) {
                    Intent intent = new Intent(mActivity, DouBanWebDetailActivity.class);
                    intent.putExtra("url", mMovieListBean.getScheduleUrl());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {

    }



    @Override
    public void showImgsContent(MovieDetailBean movieListBean) {
        mMovieListBean = movieListBean;
        mMovieDetailHotTalk.setText(movieListBean.getReviewsCount() + "人正在热议");

        mMovieDetailInfoGenres.setText(movieListBean.getTitle());
        mMovieDetailInfoOriginalTitle.setText(movieListBean.getYear() + "/");
        for (String s : movieListBean.getGenres()) {
            mMovieDetailInfoOriginalTitle.append(s + "/");
        }

        mMovieDetailInfoPubdata.setText("上映时间:" + movieListBean.getYear() + "(" + (movieListBean.getCountries().size() > 0 ? movieListBean.getCountries().get(0) : "") + ")");

        mMovieDetailInfoDurations.setText("片长:  ");
        if (movieListBean.getDurations() != null) {
            for (String s : movieListBean.getDurations()) {
                mMovieDetailInfoDurations.append(s);
            }
        }
        mMovieDetailRatingTv.setText(movieListBean.getRating().getAverage() + "");

        mMovieDetailRatingRating.setRating((float) (movieListBean.getRating().getAverage() / 2));
        mMovieDetailRatingCount.setText(movieListBean.getCollectCount() + "人");
        mMovieDetailSummary.setText(movieListBean.getSummary());
        // mExpandableText.setText();

        mCasts.clear();
        mCasts.addAll(movieListBean.getCasts());
        mAdapter.setNewData(mCasts);


    }


}
