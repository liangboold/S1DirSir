package com.example.logger;

import com.example.logger.common.LoggerLevel;

/*
 * @ClassName ILogger
 * @Description TODO
 * @Author 海
 * @Date 2021/9/13 19:58
 * @Version 1.0
 */
public interface ILogger {
    void d(String Tag,String log);
    void v(String Tag,String log);
    void i(String Tag,String log);
    void w(String Tag,String log);
    void e(String Tag,String log);

    //是否Debug

    void setDebug(boolean isDebug);

    //默认TAG

    void setLogTAG(String tag);

    //默认日志等级

    void setLoggerLevel(LoggerLevel level);

    //Log存储位置 可以是本地路径 可以是网络路径 可以是Email地址

    void setSaveUrl(String url);
}