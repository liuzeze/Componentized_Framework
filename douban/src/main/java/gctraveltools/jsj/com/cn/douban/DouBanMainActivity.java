package gctraveltools.jsj.com.cn.douban;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.coremodellib.model.bean.MovieListBean;
import gctraveltools.jsj.com.cn.douban.adapter.DouBanMovieListAdapter;
import gctraveltools.jsj.com.cn.douban.base.BaseDoubanActivity;
import gctraveltools.jsj.com.cn.douban.databinding.ActivityDouBanMainBinding;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanListContract;
import gctraveltools.jsj.com.cn.douban.presenter.DouBanListPresenter;

@Route(path = ARouterPath.DouBanAty)
public class DouBanMainActivity extends BaseDoubanActivity<DouBanListPresenter,ActivityDouBanMainBinding>
        implements NavigationView.OnNavigationItemSelectedListener, DouBanListContract.View {


    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<MovieListBean.SubjectsEntity> mMovieLists = new ArrayList<>();
    private DouBanMovieListAdapter mAdapter;
    private String mPath = "in_theaters";

    @Override
    protected int getLayout() {
        return R.layout.activity_dou_ban_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("正在热映");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance()
                        .build(ARouterPath.ZhiHUAty)
                        .navigation();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new DouBanMovieListAdapter(mMovieLists);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.getMovieListReq(mPath);


        initListener();

    }

    private void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getMovieListReq(mPath);

            }
        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                View img = view.findViewById(R.id.simpledraweeview);
                img.setTransitionName("moviesimg");
                //第一个页面
                Intent intent = new Intent(mActivity, DoubanDetailActivity.class);
                intent.putExtra("id", mMovieLists.get(position).getId());
                intent.putExtra("imgurl", mMovieLists.get(position).getImages().getMedium());
                //第二个参数：共享元素的view  第三个参数:在xml文件中定义的transitionName
                ActivityOptionsCompat moviesimg = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                        img,
                        "moviesimg");
                startActivity(intent, moviesimg.toBundle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dou_ban_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            mToolbar.setTitle("正在热映");
            mPath = "in_theaters";
            mPresenter.getMovieListReq(mPath);
            mSwipeRefreshLayout.setRefreshing(true);

        } else if (id == R.id.nav_gallery) {
            mToolbar.setTitle("即将上映");
            mPath = "coming_soon";
            mPresenter.getMovieListReq(mPath);
            mSwipeRefreshLayout.setRefreshing(true);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void stateError(String message) {

    }

    @Override
    public void showImgsContent(MovieListBean movieListBean) {
        mSwipeRefreshLayout.setRefreshing(false);
        mMovieLists = movieListBean.getSubjects();
        mAdapter.setNewData(mMovieLists);
    }
}
