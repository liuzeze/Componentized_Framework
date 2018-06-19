package com.printer.module_interception.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.printer.module_interception.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by linkaipeng on 2018/5/20.
 */

public class NetworkFeedFragment extends SupportFragment {

    private static final String TAG = "NetworkFeedActivity";
    private RecyclerView mNetworkFeedRecyclerView;
    private NetworkFeedAdapter mNetworkFeedAdapter;

    public static NetworkFeedFragment newInstance() {
        return new NetworkFeedFragment();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, NetworkFeedFragment.class);
        context.startActivity(starter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network_feed, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mNetworkFeedRecyclerView = (RecyclerView) view.findViewById(R.id.network_feed_recyclerView);
        mNetworkFeedRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNetworkFeedAdapter = new NetworkFeedAdapter(this);
        mNetworkFeedRecyclerView.setAdapter(mNetworkFeedAdapter);
    }

}
