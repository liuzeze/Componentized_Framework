package com.printer.module_interception.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.printer.module_interception.R;
import com.printer.module_interception.data.DataPoolImpl;
import com.printer.module_interception.data.NetworkFeedModel;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by linkaipeng on 2018/5/20.
 */

public class NetworkFeedAdapter extends RecyclerView.Adapter {

    private static final String TAG = "NetworkFeedAdapter";
    private NetworkFeedFragment mFragment;
    private List<NetworkFeedModel> mNetworkFeedList;

    public NetworkFeedAdapter(NetworkFeedFragment fragment) {
        mFragment = fragment;
        mNetworkFeedList = new ArrayList(DataPoolImpl.getInstance().getNetworkFeedMap().values());

        try {
            Collections.sort(mNetworkFeedList, new Comparator<NetworkFeedModel>() {
                @Override
                public int compare(NetworkFeedModel networkFeedModel1, NetworkFeedModel networkFeedModel2) {
                    return (int) (networkFeedModel2.getCreateTime() - networkFeedModel1.getCreateTime());
                }
            });
        } catch (Exception e) {
            Log.e(TAG, TAG, e);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_network_feed, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (!(viewHolder instanceof ItemViewHolder)) {
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        final NetworkFeedModel networkFeedModel = mNetworkFeedList.get(i);
        itemViewHolder.mUrlTextView.setText(networkFeedModel.getUrl());

        if (networkFeedModel.getStatus() >= 400 && networkFeedModel.getStatus() <= 600) {
            itemViewHolder.mStatusView.setBackgroundResource(R.drawable.red_rect);
            itemViewHolder.mStatusCodeTextView.setTextColor(mFragment.getResources().getColor(R.color.red));
        } else {
            itemViewHolder.mStatusView.setBackgroundResource(R.drawable.green_rect);
            itemViewHolder.mStatusCodeTextView.setTextColor(mFragment.getResources().getColor(R.color.green));
        }
        itemViewHolder.mStatusCodeTextView.setText("Status: " + networkFeedModel.getStatus());

        Format format = new DecimalFormat("#.00");
        String dataSize = format.format(networkFeedModel.getSize() * 0.001) + " KB";
        itemViewHolder.mSizeTextView.setText(dataSize);
        itemViewHolder.mCostTimeTextView.setText(networkFeedModel.getCostTime() + " ms");
        itemViewHolder.mRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment.start(NetworkFeedDetailFragment.getInstance(networkFeedModel.getRequestId()));
            }
        });

        itemViewHolder.mMethodTextView.setText(networkFeedModel.getMethod());
        itemViewHolder.mContentTypeTextView.setText("ContentType: " + networkFeedModel.getContentType());
    }

    @Override
    public int getItemCount() {
        return mNetworkFeedList.size();
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mRootLayout;
        private TextView mUrlTextView;
        private TextView mStatusCodeTextView;
        private TextView mSizeTextView;
        private TextView mCostTimeTextView;
        private TextView mMethodTextView;
        private TextView mContentTypeTextView;
        private View mStatusView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mRootLayout = (LinearLayout) itemView.findViewById(R.id.item_network_feed_root_layout);
            mUrlTextView = (TextView) itemView.findViewById(R.id.item_network_feed_url_textView);
            mStatusCodeTextView = (TextView) itemView.findViewById(R.id.item_network_feed_status_textView);
            mSizeTextView = (TextView) itemView.findViewById(R.id.item_network_feed_size_textView);
            mCostTimeTextView = (TextView) itemView.findViewById(R.id.item_network_feed_cost_time_textView);
            mMethodTextView = (TextView) itemView.findViewById(R.id.item_network_feed_method_textView);
            mContentTypeTextView = (TextView) itemView.findViewById(R.id.item_network_feed_content_type_textView);
            mStatusView = itemView.findViewById(R.id.item_network_feed_status_view);
        }
    }
}
