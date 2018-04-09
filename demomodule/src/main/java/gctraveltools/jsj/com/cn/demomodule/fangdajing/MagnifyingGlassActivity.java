package gctraveltools.jsj.com.cn.demomodule.fangdajing;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import gctraveltools.jsj.com.cn.demomodule.R;

public class MagnifyingGlassActivity extends AppCompatActivity {

    private MagnifyingView mMagnifyingView;
    private TextView mTextView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnifying_glass);
        mTextView = (TextView) findViewById(R.id.textview);
        mMagnifyingView = (MagnifyingView) findViewById(R.id.MagnifyingView);
        mTextView.post(new Runnable() {
            @Override
            public void run() {
                mMagnifyingView.setBitmap(geViewBitmap(mTextView));

            }
        });

    }

    /**
     * 截图listview
     **/
    public static Bitmap geViewBitmap(View view) {
        Bitmap bitmap;
        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
