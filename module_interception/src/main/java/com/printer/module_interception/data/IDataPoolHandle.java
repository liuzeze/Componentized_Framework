package com.printer.module_interception.data;

import java.util.HashMap;


public interface IDataPoolHandle {
    void initDataPool();
    void clearDataPool();
    void addNetworkFeedData(String key, NetworkFeedModel networkFeedModel);
    void removeNetworkFeedData(String key);
    HashMap<String, NetworkFeedModel> getNetworkFeedMap();
    NetworkFeedModel getNetworkFeedModel(String requestId);
}
