package gctraveltools.jsj.com.cn.douban;

import android.os.Bundle;

import com.tencent.smtt.sdk.WebView;

import gctraveltools.jsj.com.cn.commonlib.base.BaseActivity;

public class DouBanWebDetailActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dou_ban_web_detail);
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.loadUrl( getIntent().getStringExtra("url"));
    }
}
