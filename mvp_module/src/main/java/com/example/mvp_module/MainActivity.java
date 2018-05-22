package com.example.mvp_module;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_module.base.BaseActivity;
import com.example.mvp_module.bean.BaseBean;

import butterknife.BindView;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity<MainPresenter> implements TempContract.View {
    @BindView(R.id.tv1)
    TextView mTextView;
    @BindView(R.id.tv2)
    TextView mTextView2;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initData() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getMemInfor();
            }
        });
    }


    @Override
    public void showImgsContent(BaseBean s) {
        mTextView.setText(s.getData().getMemberName());
    }

    @Override
    public void showMemInfor(String s) {
        mTextView2.setText(s);

    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
