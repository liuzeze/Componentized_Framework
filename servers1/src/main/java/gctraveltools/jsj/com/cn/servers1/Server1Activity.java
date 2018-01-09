package gctraveltools.jsj.com.cn.servers1;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.animation.ScaleInAnimation;

import java.util.ArrayList;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.GetTravels2Response;
import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.TravelDto2;
import gctraveltools.jsj.com.cn.servers1.Base.BaseServerActivity;
import gctraveltools.jsj.com.cn.servers1.adapterr.SkyTrainHomeOrderAdapter;
import gctraveltools.jsj.com.cn.servers1.presenter.TemPresenter;
import gctraveltools.jsj.com.cn.servers1.presenter.TempContract;

@Route(path = ARouterPath.Server1Aty)
public class Server1Activity extends BaseServerActivity<TemPresenter> implements TempContract.View {


    private RecyclerView mRecyclerview;
    private SkyTrainHomeOrderAdapter mAdapter;
    private ArrayList<TravelDto2> mTravelDtos = new ArrayList<>();
    private ProgressBar mProgressBar;
    private TextView mTextView;

    @Override
    protected int getLayout() {
        return R.layout.activity_main_server;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);

    }

    @Override
    protected void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mTextView = (TextView) findViewById(R.id.textview);

        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(Server1Activity.this));
        mAdapter = new SkyTrainHomeOrderAdapter(mTravelDtos);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        mRecyclerview.addItemDecoration(itemDecoration);
        mAdapter.setNewData(null);
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.openLoadAnimation(new ScaleInAnimation());
        mAdapter.isFirstOnly(false);//init firstOnly state
        mPresenter.getTravelList();
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
    public void showImgsContent(GetTravels2Response data) {
        mProgressBar.setVisibility(View.GONE);
        if (data.baseResponse.isSuccess) {
            mTravelDtos.clear();
            for (int i = 0; i < data.travelDto2S.length; i++) {
                TravelDto2 travelDto = data.travelDto2S[i];
                mTravelDtos.add(travelDto);
            }
            mAdapter.setNewData(mTravelDtos);
        } else {
            Toast.makeText(Server1Activity.this, data.baseResponse.errorMessage, Toast.LENGTH_SHORT).show();
            mAdapter.setNewData(null);
        }
    }
}
