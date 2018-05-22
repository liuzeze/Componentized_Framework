package gctraveltools.jsj.com.cn.demomodule.scroll;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import gctraveltools.jsj.com.cn.demomodule.R;

public class ScrollActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SynScrollerview mSynScrollerview;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mSynScrollerview = (SynScrollerview) findViewById(R.id.synscrollerview);
        mLinearLayout = (LinearLayout) findViewById(R.id.item_root);
        mLinearLayout.setClickable(true);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add("左侧条目" + i);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ScrollAdapter(strings, mSynScrollerview));
        mRecyclerView.setOnTouchListener(getListener());
        mLinearLayout.setOnTouchListener(getListener());
        // mSynScrollerview.setOnScrollListener(getListener());
    }

    @NonNull
    private View.OnTouchListener getListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mSynScrollerview.onTouchEvent(motionEvent);
                return false;
            }
        };
    }
}
