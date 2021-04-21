package com.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Constant {
    //  /src/main/resources/essentialData18H.csv
    /****** 18H数据路径常量 ******/
    public static final String EssentialData18H_PATH = "E:/java project/IdeaProjects/bysj/src/main/resources/essentialData/essentialData18H.csv";

    /****** 14H数据路径常量 ******/
    public static final String EssentialData14H_PATH = "E:/java project/IdeaProjects/bysj/src/main/resources/essentialData/essentialData14H.csv";

    /****** 12H数据路径常量 ******/
    public static final String EssentialData12H_PATH = "E:/java project/IdeaProjects/bysj/src/main/resources/essentialData/essentialData12H.csv";

    /****** 11H数据路径常量 ******/
    public static final String EssentialData11H_PATH = "E:/java project/IdeaProjects/bysj/src/main/resources/essentialData/essentialData11H.csv";

    /****** 11H类型名 ******/
    public static final String Type_11H = "11H";

    /****** 12H类型名 ******/
    public static final String Type_12H = "12H";

    /****** 14H类型名 ******/
    public static final String Type_14H = "14H";

    /****** 18H类型名 ******/
    public static final String Type_18H = "18H";

    /****** 规定的每日统计开始时间 ******/
    public static final String START_TIME = " 08:00:00";

    /****** 规定的每日统计结束时间 ******/
    public static final String END_TIME = " 10:00:00";

    /****** 规定的证据统计时间差 ******/
    public static final int DIFFERENCE_MINUTES = 20;

    /****** 规定的现象统计时间差 ******/
    public static final int DIFFERENCE_PHENOMENON_MINUTES = 60;

    /****** 规定的故障统计时间差 ******/
    public static final int DIFFERENCE_FAULT_MINUTES = 120;

    /****** 日期格式 ******/
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /****** 时间格式 ******/
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    /****** 18H默认应有心跳数 ******/
    public static final int EstimatedBeats_18H = 4;

    /****** 14H默认应有心跳数 ******/
    public static final int EstimatedBeats_14H = 120;

    /****** 12H默认应有心跳数 ******/
    public static final int EstimatedBeats_12H = 40;

    /****** 11H默认应有心跳数 ******/
    public static final int EstimatedBeats_11H = 4;

    /****** 18H单次时间差 ******/
    public static final int EstimatedTime_18H = 300;

    /****** 14H单次时间差 ******/
    public static final int EstimatedTime_14H = 10;

    /****** 12H单次时间差 ******/
    public static final int EstimatedTime_12H = 30;

    /****** 11H单次时间差 ******/
    public static final int EstimatedTime_11H = 300;
}
