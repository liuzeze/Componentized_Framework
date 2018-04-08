package gctraveltools.jsj.com.cn.commonlib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/12/27	17:27	    刘泽			    新增 类
 * 2017/12/27	17:27	    刘泽			    增加yyy属性
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Activity mActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewManager.getInstance().addActivity(this);
        mActivity = this;


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewManager.getInstance().finishActivity(this);


    }

}
