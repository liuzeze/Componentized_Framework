package com.printer.module_interception.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.printer.module_interception.R;
import com.printer.module_interception.data.DataPoolImpl;
import com.printer.module_interception.data.NetworkFeedModel;
import com.printer.module_interception.utils.DataTranslator;

import java.util.Map;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by linkaipeng on 2018/5/20.
 */

public class NetworkFeedDetailFragment extends SupportFragment {

    private NetworkFeedModel mNetworkFeedModel;
    private TextView mRequestHeadersTextView;
    private TextView mResponseHeadersTextView;
    private TextView mBodyTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_network_feed_detail, container, false);
        mRequestHeadersTextView = (TextView) view.findViewById(R.id.request_headers_textView);
        mResponseHeadersTextView = (TextView) view.findViewById(R.id.response_headers_textView);
        mBodyTextView = (TextView) view.findViewById(R.id.body_textView);
        initData();
        return view;
    }

    public static void start(Context context, String requestId) {
        Intent starter = new Intent(context, NetworkFeedDetailFragment.class);
        starter.putExtra("requestId", requestId);
        context.startActivity(starter);
    }


    private void initData() {
        String requestId = getArguments().getString("requestId");
        if (TextUtils.isEmpty(requestId)) {
            return;
        }
        mNetworkFeedModel = DataPoolImpl.getInstance().getNetworkFeedModel(requestId);
        if (mNetworkFeedModel == null) {
            return;
        }
        setRequestHeaders();
        setResponseHeaders();
        setBody();
    }

    private void setRequestHeaders() {
        mRequestHeadersTextView.setText(parseHeadersMapToString(mNetworkFeedModel.getRequestHeadersMap()));
    }

    private void setResponseHeaders() {
        mResponseHeadersTextView.setText(parseHeadersMapToString(mNetworkFeedModel.getResponseHeadersMap()));
    }

    private void setBody() {
        try {
            if (mNetworkFeedModel.getContentType().contains("json")) {
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                JsonObject bodyJO = new JsonParser().parse(mNetworkFeedModel.getBody()).getAsJsonObject();
                //部分接口数据设置带格式的text会有jni异常
                String text = gson.toJson(bodyJO);
                mBodyTextView.setText(bodyJO.toString());
            } else {
                mBodyTextView.setText(mNetworkFeedModel.getBody());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String parseHeadersMapToString(Map<String, String> headers) {
        if (headers == null || headers.isEmpty()) {
            return "Header is Empty.";
        }
        StringBuilder headersBuilder = new StringBuilder();
        for (String name : headers.keySet()) {
            if (TextUtils.isEmpty(name)) {
                continue;
            }
            headersBuilder
                    .append(name)
                    .append(": ")
                    .append(headers.get(name))
                    .append("\n");
        }
        return headersBuilder.toString();
    }

    public static NetworkFeedDetailFragment getInstance(String requestId) {
        NetworkFeedDetailFragment networkFeedDetailFragment = new NetworkFeedDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("requestId", requestId);
        networkFeedDetailFragment.setArguments(bundle);
        return networkFeedDetailFragment;
    }
}
