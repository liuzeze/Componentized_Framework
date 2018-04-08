package gctraveltools.jsj.com.cn.douban;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;
import gctraveltools.jsj.com.cn.douban.Utils.FixDexUtils;
import gctraveltools.jsj.com.cn.douban.temp.FixTemp;

public class DouBanFixActivity extends BaseActivity {

    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dou_ban_fix);

        mTextView = findViewById(R.id.textView1);


        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        FixTemp fixTemp = new FixTemp();
        fixTemp.setText(mTextView);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FixDexUtils.loadFixedDex(mActivity, Environment.getExternalStorageDirectory());

            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
