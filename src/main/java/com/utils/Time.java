package com.utils;

import com.constant.Constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Time {

    //获取当天的开始统计时间
    public static String getStartTime(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(Constant.FORMAT_DATE);
        //获取当天的日期
        LocalDateTime date =LocalDateTime.now();
        String nowDate = date.format(formatDate);
        //加上默认开始时间
        nowDate = nowDate + Constant.START_TIME;

        /*********  测试需要 *********/
        //测试需要将日期强制设定为2021-03-23；
        nowDate = "2021-03-23 08:00:00";
        /*********  测试需要 *********/

        return nowDate;
    }

    //获取当天的结束统计时间
    public static String getEndTime(){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(Constant.FORMAT_DATE);
        //获取当天的日期
        LocalDateTime date =LocalDateTime.now();
        String endDate = date.format(formatDate);
        //加上默认结束时间
        endDate = endDate + Constant.END_TIME;

        /*********  测试需要 *********/
        //测试需要将日期强制设定为2021-03-23；
        endDate = "2021-03-23 10:00:00";
        /*********  测试需要 *********/

        return endDate;
    }


    //获取下一个时间段的日期
    public static String getNextTime(String startTime,int minutes){
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern(Constant.FORMAT_TIME);
        LocalDateTime nowTime = LocalDateTime.parse(startTime,formatTime);
        nowTime = nowTime.plus(minutes, ChronoUnit.MINUTES);
        return nowTime.format(formatTime);
    }



}
