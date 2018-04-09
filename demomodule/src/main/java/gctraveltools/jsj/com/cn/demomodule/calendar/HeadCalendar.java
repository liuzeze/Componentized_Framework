package gctraveltools.jsj.com.cn.demomodule.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Calendar;

import gctraveltools.jsj.com.cn.demomodule.R;


/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/3/14	15:26	    刘泽			    新增 类
 * 2018/3/14	15:26	    刘泽			    增加yyy属性
 */

public class HeadCalendar extends FrameLayout {

    private int mNowYear;
    private int mNowMonth;
    private int mNowDay;
    //年
    private ArrayList<Integer> years = new ArrayList<Integer>();
    //月
    private ArrayList<Integer> months = new ArrayList<Integer>();
    //日
    private ArrayList<Integer> days = new ArrayList<Integer>();
    private ArrayList<CalendarBean> mDateList = new ArrayList<>();
    private OnClickCalendarListener mCalendarListener;

    public HeadCalendar(@NonNull Context context) {
        this(context, null);
    }

    public HeadCalendar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public HeadCalendar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Calendar calendar = Calendar.getInstance();
        //当前的年份
        mNowYear = calendar.get(Calendar.YEAR);
        //当前的月份
        mNowMonth = calendar.get(Calendar.MONTH);
        //当前的天
        mNowDay = calendar.get(Calendar.DAY_OF_MONTH);
        //年月日时分的集合赋值
        for (int i = mNowYear; i <= mNowYear + 1; i++) {
            years.add(i);
        }
        for (int i = 1; i <= 12; i++) {
            months.add(i);
        }
        for (int i = 1; i <= 31; i++) {
            days.add(i);
        }
        initView(context);
    }

    private void initView(Context context) {
        View inflate = View.inflate(context, R.layout.head_calendar, null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.RecyclerView);
        TextView jump = (TextView) inflate.findViewById(R.id.tv_jump_canlendar);

        LinearLayoutManager layout = new LinearLayoutManager(context);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layout);
        getCalendarList();
        CalendarAdapter adapter = new CalendarAdapter(mDateList);
        recyclerView.setAdapter(adapter);
        addView(inflate);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mCalendarListener != null) {
                    mCalendarListener.onSelectData();
                }
            }
        });
        jump.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCalendarListener != null) {
                    mCalendarListener.onShowCanlendar();
                }
            }
        });

    }


    public void getCalendarList() {
        mDateList.clear();
        for (int year : years) {
            for (int month : months) {
                int mMonthDays = DateUtils.getMonthDays(year, month - 1);
                for (int i = 1; i <= mMonthDays; i++) {
                    if (!prevDay(year, month - 1, i) && !afterDay(year, month - 1, i)) {
                        LunarCalendar lunarCalendar = new LunarCalendar();
                        String lunarDate = lunarCalendar.getLunarDate(year, month, i);
                        String festival = lunarCalendar.getFestival();
                        String weekNumber = DateUtils.getWeekNumber(year + "-" + DateUtils.fillZero(month) + "-" + DateUtils.fillZero(i), "yyyy-MM-dd");
                        CalendarBean calendarBean = new CalendarBean(weekNumber, month, i, festival == null ? lunarDate : festival);
                        mDateList.add(calendarBean);
                    }
                }


            }
        }
    }

    /**
     * 判断是否是传入日期之前的日期
     * true  不可点击
     *
     * @param year
     * @param month
     * @param Day
     * @return
     */
    protected boolean prevDay(int year, int month, int Day) {
        return ((year < mNowYear)) || (year == mNowYear && month < mNowMonth) || (year == mNowYear && month == mNowMonth && Day < mNowDay);
    }

    /**
     * 判断是否是传入日期之前的日期
     * true  不可点击
     *
     * @param year
     * @param month
     * @param Day
     * @return
     */
    protected boolean afterDay(int year, int month, int Day) {
        return (year == mNowYear + 1 && month > mNowMonth) || (year == mNowYear + 1 && month == mNowMonth && Day >= mNowDay);
    }

    public void setOnClickCalendarListener(OnClickCalendarListener onClickCalendarListener) {
        mCalendarListener = onClickCalendarListener;
    }

    public interface OnClickCalendarListener {
        void onShowCanlendar();

        void onSelectData();
    }


}
