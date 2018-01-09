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

import butterknife.BindView;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieDetailBean;
import gctraveltools.jsj.com.cn.douban.adapter.DouBanMoviepeopleAdapter;
import gctraveltools.jsj.com.cn.douban.base.BaseDoubanActivity;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanDetailContract;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanDetailPresenter;

public class DoubanDetailActivity extends BaseDoubanActivity<DouBanDetailPresenter> implements DouBanDetailContract.View {


    @BindView(R2.id.simpledraweeview)
    SimpleDraweeView mSimpledraweeview;
    @BindView(R2.id.movie_detail_hot_talk)
    TextView mMovieDetailHotTalk;
    @BindView(R2.id.movie_detail_coll_layout)
    CollapsingToolbarLayout mMovieDetailCollLayout;
    @BindView(R2.id.movie_detail_appbar)
    AppBarLayout mMovieDetailAppbar;
    @BindView(R2.id.movie_detail_info_genres)
    TextView mMovieDetailInfoGenres;
    @BindView(R2.id.movie_detail_info_original_title)
    TextView mMovieDetailInfoOriginalTitle;
    @BindView(R2.id.movie_detail_info_pubdata)
    TextView mMovieDetailInfoPubdata;
    @BindView(R2.id.movie_detail_info_durations)
    TextView mMovieDetailInfoDurations;
    @BindView(R2.id.movie_detail_rating_tv)
    TextView mMovieDetailRatingTv;
    @BindView(R2.id.movie_detail_rating_rating)
    RatingBar mMovieDetailRatingRating;
    @BindView(R2.id.movie_detail_rating_count)
    TextView mMovieDetailRatingCount;
    @BindView(R2.id.movie_detail_rating_layout)
    LinearLayout mMovieDetailRatingLayout;
    @BindView(R2.id.movie_detail_btn_watch)
    Button mMovieDetailBtnWatch;
    @BindView(R2.id.movie_detail_btn_watched)
    Button mMovieDetailBtnWatched;
    @BindView(R2.id.movie_detail_ticket)
    TextView mMovieDetailTicket;
    @BindView(R2.id.expandable_text)
    TextView mExpandableText;
    @BindView(R2.id.expand_collapse)
    ImageButton mExpandCollapse;
    @BindView(R2.id.movie_detail_summary)
    ExpandableTextView mMovieDetailSummary;
    @BindView(R2.id.movie_detail_actor_list)
    RecyclerView mMovieDetailActorList;
    @BindView(R2.id.movie_detail_scrollview)
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

        mId = getIntent().getStringExtra("id");
        mImgurl = getIntent().getStringExtra("imgurl");
        mSimpledraweeview.setImageURI(mImgurl);
        mPresenter.getMovieDetailReq(mId);

        LinearLayoutManager layout = new LinearLayoutManager(mContext);
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
                    Intent intent = new Intent(mContext, DouBanWebDetailActivity.class);
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
    public void stateError(String message) {

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
