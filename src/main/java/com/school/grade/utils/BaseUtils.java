package com.school.grade.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 常用工具类
 */
public class BaseUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取当年每周范围的详细日期
     */
    public static String[] getWeekByYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.YEAR);
        cal.set(Calendar.YEAR, year + 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.add(Calendar.DAY_OF_MONTH, -(6 + cal.get(Calendar.DAY_OF_WEEK)));
        //52
        int weeks = cal.get(Calendar.WEEK_OF_YEAR);
        String[] days = new String[weeks];
        for (int i = weeks - 1; i >= 0; i--) {
            days[i] = sdf.format(cal.getTime());
            cal.add(Calendar.WEEK_OF_YEAR, -1);
        }
        return days;
    }

    /**
     * 得到几天后的时间
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

}
