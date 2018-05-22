package gctraveltools.jsj.com.cn.demomodule.dragview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import gctraveltools.jsj.com.cn.demomodule.R;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/4/8	10:09	    刘泽			    新增 类
 * 2018/4/8	10:09	    刘泽			    增加yyy属性
 */
public class DragFloatActionButtonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_drag_float_action_button);
        DragFloatActionButton actionButton = (DragFloatActionButton) findViewById(R.id.drag_view);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DragFloatActionButtonActivity.this,"点击事件",Toast.LENGTH_LONG).show();
            }
        });
    }
}
