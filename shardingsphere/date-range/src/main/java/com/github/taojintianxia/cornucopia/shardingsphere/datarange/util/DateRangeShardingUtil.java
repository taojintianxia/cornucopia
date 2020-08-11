package com.github.taojintianxia.cornucopia.shardingsphere.datarange.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Nianjun Sun
 */
public class DateRangeShardingUtil {
    
    public static String getDateFromTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.YEAR)).append(calendar.get(Calendar.MONTH)).append(calendar.get(Calendar.DAY_OF_MONTH));
        
        return stringBuilder.toString();
    }
    
    public static String getToMonthFromTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.YEAR)).append(calendar.get(Calendar.MONTH));

        return stringBuilder.toString();
    }

    public static String getToYearFromTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calendar.get(Calendar.YEAR));

        return stringBuilder.toString();
    }
}
