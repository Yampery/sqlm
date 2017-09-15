package com.sqlm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理时间工具
 * @author Yampery
 * @date 2017/6/26 9:59
 */
public class DateUtils {

    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将日期转换为"yyyy-MM-dd"格式
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 转换日期格式
     * @param date 日期
     * @param pattern 要转换的格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return "";
    }

    /**
     * 将字符串为"yyyy-MM-dd HH:mm:ss"格式转换为日期
     * @param sDate
     * @return
     */
    public static Date getFormatDate(String sDate) {
        return getFormatDate(sDate, DATE_TIME_PATTERN);
    }

    /**
     * 根据字符串创建日期
     * @param sDate 日期字符串
     * @param pattern 字符串格式
     * @return
     */
    public static Date getFormatDate(String sDate, String pattern) {

        Date date = null;

        if (null != sDate) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            try {

                date = df.parse(sDate);
            } catch (Exception e) {
                System.out.println("日期转换出错：" + e.getMessage());
                e.printStackTrace();
            } /// try catch
        } /// if end

        return date;
    }

    /**
     * 根据给定格式将对象转换为日期字符串
     * @param obj
     * @return
     */
    public static String getFromObj(Object obj, String patten) {
        if (null == obj)    return "";
        String sDate = obj.toString();
        return format(DateUtils.getFormatDate(sDate, patten), patten);
    }

    public static String getFromObj(Object obj) {
        return getFromObj(obj, DATE_TIME_PATTERN);
    }

    /**
     * 获取当前时间毫秒数
     * @return
     */
    public static long nowMIllis() {
        return System.currentTimeMillis();
    }

    /**
     * 将毫秒转化为 '时分秒'
     * @param d 毫秒数
     * @return String
     */
    public static String getPeriodByMS(long d) {

        if (0 >= d)
            return "　";

        //计算出相差天数
        long days = d / (24 * 3600);

        //计算出小时数
        long leave1 = d % (24 * 3600);    //计算天数后剩余的毫秒数
        long hours = leave1 / 3600;
        //计算相差分钟数
        long leave2 = leave1 % 3600;        //计算小时数后剩余的毫秒数
        long minutes = leave2 / 60;

        //计算相差秒数
        long leave3 = leave2 % 60;      //计算分钟数后剩余的毫秒数
        int seconds = Math.round(leave3);

        String returnStr = seconds + "秒";
        if(minutes > 0) {
            returnStr = minutes + "分" + returnStr;
        }
        if(hours>0) {
            returnStr = hours + "小时" + returnStr;
        }
        if(days>0) {
            returnStr = days + "天" + returnStr;
        }
        return returnStr;
    }
}
