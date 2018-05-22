package gctraveltools.jsj.com.cn.demomodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.demomodule.calendar.PictureActivity;
import gctraveltools.jsj.com.cn.demomodule.coordinator.CoordinatorLayoutActivity;
import gctraveltools.jsj.com.cn.demomodule.downfnish.LayoutImgActivity;
import gctraveltools.jsj.com.cn.demomodule.dragview.DragFloatActionButtonActivity;
import gctraveltools.jsj.com.cn.demomodule.fangdajing.MagnifyingGlassActivity;
import gctraveltools.jsj.com.cn.demomodule.scroll.ScrollActivity;
import gctraveltools.jsj.com.cn.demomodule.suspendhead.SuspendActivity;

@Route(path = ARouterPath.DemoAty)

public class DemoMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_layout_main);
        findViewById(R.id.textview1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoMainActivity.this, CoordinatorLayoutActivity.class));
            }
        }); findViewById(R.id.textview2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoMainActivity.this, DragFloatActionButtonActivity.class));
            }
        });
        findViewById(R.id.textview3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(mActivity, LayoutImgActivity.class));
            }
        });
        findViewById(R.id.textview4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, ScrollActivity.class));
            }
        });
        findViewById(R.id.textview5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, PictureActivity.class));
            }
        });

        findViewById(R.id.textview6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, SuspendActivity.class));
            }
        });

        findViewById(R.id.textview7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, MagnifyingGlassActivity.class));
            }
        });
    }
}
