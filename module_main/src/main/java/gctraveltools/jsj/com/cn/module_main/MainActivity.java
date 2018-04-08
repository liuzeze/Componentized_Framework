package gctraveltools.jsj.com.cn.module_main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.commonlib.tablayout.CommonTabLayout;
import gctraveltools.jsj.com.cn.commonlib.tablayout.listener.CustomTabEntity;
import gctraveltools.jsj.com.cn.module_main.entity.TabEntity;

public class MainActivity extends BaseActivity {
    boolean mBoolean = true;
    private TextView mView1;
    private TextView mView2;

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        CommonTabLayout commonTabLayout = (CommonTabLayout) findViewById(R.id.CommonTabLayout);
        commonTabLayout.setTabData(mTabEntities);
        initView();
    }


    protected void initView() {

        mView1 = (TextView) findViewById(R.id.tv1);
        mView2 = (TextView) findViewById(R.id.tv2);


        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                titleAnima();

                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance()
                        .build(ARouterPath.Server1Aty)
                        .navigation(MainActivity.this);

            }
        });

        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleAnima();
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance()
                        .build(ARouterPath.ZhiHUAty)
                        .navigation();

            }
        });
        ((Button) findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleAnima();
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance()
                        .build(ARouterPath.DouBanAty)
                        .navigation();

            }
        });
        ((Button) findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleAnima();
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance()
                        .build(ARouterPath.DemoAty)
                        .navigation();

            }
        });

    }

    private void titleAnima() {
        if (mBoolean) {
            mView1.animate().translationY(-100).setDuration(500).start();
            mView2.animate().translationY(0).setDuration(500).start();
        } else {
            mView1.animate().translationY(0).setDuration(500).start();
            mView2.animate().translationY(100).setDuration(500).start();
        }
        mBoolean = !mBoolean;
    }

}
