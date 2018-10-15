package com.richard.java.study.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.Test;

import java.util.Date;

public class DateTimeUtilTest {
    @Test
    public void testGetStartTimeOfDate() throws Exception {
        DateTime dateTime = DateTimeUtil.getStartTimeOfDate(new Date());
        System.out.println(DateTimeUtil.formatDateTime2Str(dateTime));
    }

    @Test
    public void testGetEndTimeOfDate() throws Exception {
        DateTime dateTime = DateTimeUtil.getEndTimeOfDate(new Date());
        System.out.println(DateTimeUtil.formatDateTime2Str(dateTime));
    }

    @Test
    public void testGetDateByDateAndDayOfWeek() throws Exception {
        DateTime dateTime = DateTimeUtil.getDateByDateAndDayOfWeek(new Date(), DateTimeConstants.SUNDAY);
        System.out.println(DateTimeUtil.formatDateTime2Str(dateTime));
    }

    @Test
    public void testMinusMonths() throws Exception {
        System.out.println(DateTimeUtil.formatDateTime2Str(DateTime.now().minusMonths(3)));
    }
}