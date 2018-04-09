package gctraveltools.jsj.com.cn.demomodule.calendar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gctraveltools.jsj.com.cn.demomodule.R;


public class PictureActivity extends AppCompatActivity {

    private TextView mTextView;
    private boolean isShow;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        PictureView pictureView = (PictureView) findViewById(R.id.PictureView);
        final HeadCalendar headCalendar = (HeadCalendar) findViewById(R.id.HeadCalendar);
        mTextView = (TextView) findViewById(R.id.TextView);
        ScrollView scrollView = (ScrollView) findViewById(R.id.ScrollView);
        ArrayList<PrictureBean> items = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PrictureBean e = new PrictureBean();
            switch (i) {
                case 0:
                    e.Percentage = 0.3f;
                    break;
                case 1:
                    e.Percentage = 0.2f;
                    break;
                case 2:
                    e.Percentage = 0.8f;
                    break;
                case 3:
                    e.Percentage = 0.5f;
                    break;
                default:
                    e.Percentage = 1f;
                    break;
            }

            e.PriceDes = "1234";
            e.time = "333";
            items.add(e);

        }
        pictureView.setOnSelectListener(new PictureView.OnSelectListener() {
            @Override
            public void select(int position) {
                Toast.makeText(PictureActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        pictureView.setItems(items, 2);
        ObjectAnimator.ofFloat(pictureView, "height", 0, 1).setDuration(1000).start();


        headCalendar.setOnClickCalendarListener(new HeadCalendar.OnClickCalendarListener() {
            @Override
            public void onShowCanlendar() {
                if (isShow) {
                    showDetailCalendar(500, 0);
                } else {
                    showDetailCalendar(0, 500);
                }
                isShow = !isShow;
            }

            private void showDetailCalendar(int start, int end) {
                final ViewGroup.LayoutParams layoutParams = mTextView.getLayoutParams();
                ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
                valueAnimator.setDuration(300);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        layoutParams.height = animatedValue;
                        mTextView.requestLayout();
                    }
                });
                valueAnimator.start();
            }

            @Override
            public void onSelectData() {
            }
        });


    }
}
