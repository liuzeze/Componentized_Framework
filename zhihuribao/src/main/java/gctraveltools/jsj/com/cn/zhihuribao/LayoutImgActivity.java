package gctraveltools.jsj.com.cn.zhihuribao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gctraveltools.jsj.com.cn.zhihuribao.view.TouchViewGroup;

public class LayoutImgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_img);
        TouchViewGroup touchViewGroup = (TouchViewGroup) findViewById(R.id.tvg_root);
        touchViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        touchViewGroup.setOnFinishListener(new TouchViewGroup.OnFnishListener() {
            @Override
            public void onFinish() {
                finish();
            }
        });
    }
}
