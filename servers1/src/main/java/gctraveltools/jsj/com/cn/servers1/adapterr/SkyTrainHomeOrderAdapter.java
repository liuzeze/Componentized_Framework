package gctraveltools.jsj.com.cn.servers1.adapterr;


import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;

import java.util.List;

import gctraveltools.jsj.com.cn.coremodellib.model.proto.skytrain.nano.TravelDto2;
import gctraveltools.jsj.com.cn.servers1.R;
import gctraveltools.jsj.com.cn.servers1.bean.SkyTrainFlightBean;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/9/25	15:06	    刘泽			    新增 类
 * 2017/9/25	15:06	    刘泽			   空铁服务首页行程列表适配器
 */

public class SkyTrainHomeOrderAdapter extends BaseQuickAdapter<TravelDto2, BaseViewHolder> {
    public SkyTrainHomeOrderAdapter(@Nullable List<TravelDto2> data) {
        super(R.layout.item_sky_train_home_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TravelDto2 item) {
        SkyTrainFlightBean flightBean = new Gson().fromJson(item.ext, SkyTrainFlightBean.class);
        if (flightBean != null && !TextUtils.isEmpty(flightBean.getDepartureAirportName()) && !TextUtils.isEmpty(flightBean.getDepartureAirportName())) {
            helper.setText(R.id.tv_airport, flightBean.getDepartureAirportName() + "-" + flightBean.getArrivalAirportName());
        }
        helper.setText(R.id.tv_time, item.flightNumber + "  " + item.travelDayStamp);
        helper.setGone(R.id.tv_no_server, !item.isProvideService);
        if (item.isProvideService) {
            helper.setTextColor(R.id.tv_airport, Color.parseColor("#333333"));
        } else {
            helper.setTextColor(R.id.tv_airport,Color.parseColor("#999999"));
        }
    }

}