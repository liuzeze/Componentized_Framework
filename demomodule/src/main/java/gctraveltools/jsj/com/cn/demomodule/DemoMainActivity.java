package gctraveltools.jsj.com.cn.demomodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import gctraveltools.jsj.com.cn.commonlib.ARouterPath;
import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.demomodule.coordinator.CoordinatorLayoutActivity;

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
        });
    }
}
