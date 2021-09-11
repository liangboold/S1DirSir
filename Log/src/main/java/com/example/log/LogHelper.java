package com.example.log;


import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.log.LogConstant.A;
import static com.example.log.LogConstant.D;
import static com.example.log.LogConstant.E;
import static com.example.log.LogConstant.I;
import static com.example.log.LogConstant.V;
import static com.example.log.LogConstant.W;

/*
 * @ClassName LogHelper
 * @Description TODO
 * @Author 海
 * @Date 2021/9/11 8:19
 * @Version 1.0
 */
public class LogHelper {
    public static String formatLog(int level, String tag, String msg){
        //例:2021-09-11 10.22.23.445
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = sf.format(new Date());
        String preTAG = V;

        switch (level) {
            case LogConstant.VERBOSE:
                preTAG = V;
                break;
            case LogConstant.DEBUG:
                preTAG = D;
                break;
            case LogConstant.INFO:
                preTAG = I;
                break;
            case LogConstant.WARN:
                preTAG = W;
                break;
            case LogConstant.ERROR:
                preTAG = E;
                break;
            case LogConstant.ASSERT:
                preTAG = A;
                break;
            default:
                break;
        }
        //打印进程ID 线程ID 当前类 当前方法
        StringBuilder builder = new StringBuilder();
        builder.append(time).append(" ")
                .append(preTAG).append(" ")
                .append(android.os.Process.myPid()).append("|")
                .append(android.os.Process.myTid()).append("[")
                .append( RuntimeEnv.getCurrentFileName()).append("->")
                .append(RuntimeEnv.getCurrentMethodName()).append("]")
                .append("[").append(tag).append("]").append(msg);
        return builder.toString();
    }

    public static String formatXLog(int level, String tag, String msg){

        // 时间格式 2017-8-26 23.22.23.445
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = sf.format(new Date());
        String preTAG = V;

        switch (level) {
            case LogConstant.VERBOSE:
                preTAG = V;
                break;
            case LogConstant.DEBUG:
                preTAG = D;
                break;
            case LogConstant.INFO:
                preTAG = I;
                break;
            case LogConstant.WARN:
                preTAG = W;
                break;
            case LogConstant.ERROR:
                preTAG = E;
                break;
            case LogConstant.ASSERT:
                preTAG = A;
                break;
            default:
                break;
        }
        //打印进程ID 线程ID 当前类 当前方法
        StringBuilder builder = new StringBuilder();
        builder.append("[")
                .append(RuntimeEnv.getCurrentFileName()).append("->")
                .append(RuntimeEnv.getCurrentMethodName()).append("]")
                .append("[").append(tag).append("] ").append(msg);
        return builder.toString();
    }
} 