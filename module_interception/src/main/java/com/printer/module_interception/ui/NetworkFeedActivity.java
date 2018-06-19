package com.printer.module_interception.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.printer.module_interception.R;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by linkaipeng on 2018/5/20.
 */

public class NetworkFeedActivity extends SupportActivity {


    public static void start(Context context) {
        Intent starter = new Intent(context, NetworkFeedActivity.class);
        starter.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_feed);
        if (findFragment(NetworkFeedFragment.class) == null) {
            loadRootFragment(R.id.fl_root, NetworkFeedFragment.newInstance());  // 加载根Fragment
        }
        TextView tvBack =  findViewById(R.id.network_feed_back_layout);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }
}
