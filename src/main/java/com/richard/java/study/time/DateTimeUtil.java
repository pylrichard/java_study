package com.richard.java.study.time;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    public static final String PATTERN_YMD = "yyyy-MM-dd";
    public static final String PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YMDHMSE = "yyyy-MM-dd HH:mm:ss EE";

    /**
     * 获取需要的DateTime
     */

    /**
     * 获取时间所在周周几对应的日期
     * 常用来获取周一和周日对应的日期
     *
     * @param dayOfWeek 见org.joda.time.DateTimeConstants.MONDAY
     */
    public static DateTime getDateByDateAndDayOfWeek(Date date, Integer dayOfWeek) {
        DateTime dateTime = convertToDateTime(date);
        /*
            withDayOfWeek(1)类似于Calendar.set(MONDAY)，但比Calendar好用
            Calendar使用西方时间，周日相当于北京时间周一，见Calendar.DAY_OF_WEEK
         */
        return dateTime.withDayOfWeek(dayOfWeek)
                //当天某小时，设置为0点
                .withHourOfDay(0)
                //当天某分钟，设置为0分
                .withMinuteOfHour(0)
                //当天某秒，设置为0秒
                .withSecondOfMinute(0);
    }

    /**
     * 获取一天的开始时间
     */
    public static DateTime getStartTimeOfDate(Date date) {
        DateTime dateTime = convertToDateTime(date);

        return dateTime.withTimeAtStartOfDay();
    }

    /**
     * 获取一天的结束时间
     */
    public static DateTime getEndTimeOfDate(Date date) {
        DateTime dateTime = convertToDateTime(date);

        return dateTime.millisOfDay().withMaximumValue();
    }

    /**
     * Date和DateTime互相转换
     */

    public static Date convertToDate(DateTime dateTime) {
        return dateTime.toDate();
    }

    public static DateTime convertToDateTime(Date date) {
        return new DateTime(date);
    }

    /**
     * 格式化方法
     */

    public static String formatDateTime2Str(DateTime dateTime) {
        return formatDateTime2Str(dateTime, DateTimeUtil.PATTERN_YMDHMS);
    }

    public static String formatDateTime2Str(DateTime dateTime, String format) {
        return formatDateTime2Str(dateTime, format, Locale.ENGLISH);
    }

    public static String formatDateTime2Str(DateTime dateTime, String format, Locale locale) {
        return dateTime.toString(format, locale);
    }

    public static DateTime formatStr2DateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);

        return formatter.parseDateTime(dateTime);
    }
}
