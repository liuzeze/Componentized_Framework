package gctraveltools.jsj.com.cn.demomodule.calendar;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2018/3/14	16:19	    刘泽			    新增 类
 * 2018/3/14	16:19	    刘泽			    增加yyy属性
 */

public class CalendarBean {
    public String week = "";
    public int month = 0;
    public int day = 0;
    public String des = "";

    public CalendarBean(String week, int month, int day, String des) {
        this.week = week;
        this.month = month;
        this.day = day;
        this.des = des;
    }
}
