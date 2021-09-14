package com.example.logger.impl;

import android.util.Log;

import com.example.logger.ILogger;
import com.example.logger.common.LoggerLevel;

/*
 * @ClassName LogcatLogger
 * @Description TODO
 * @Author 海
 * @Date 2021/9/13 19:57
 * @Version 1.0
 */
public class LogcatLogger implements ILogger {
    private boolean isDebug=true;
    private String TAG="";
    private LoggerLevel level=LoggerLevel.Debug;
    private String loggerFormat="(:=>"+TAG+" %s --> %s";
    @Override
    public void d(String Tag, String log) {
        if (isDebug&&level.ordinal()>= LoggerLevel.Debug.ordinal()){
            Log.d(TAG, String.format(loggerFormat,Tag,log));
        }

//        LeakCanary.getInstance().install(this);
    }

    @Override
    public void v(String Tag, String log) {
        if (isDebug&&level.ordinal()>= LoggerLevel.Verbose.ordinal()){
            Log.v(TAG, String.format(loggerFormat,Tag,log));
        }
    }

    @Override
    public void i(String Tag, String log) {
        if (isDebug&&level.ordinal()>= LoggerLevel.Info.ordinal()){
            Log.i(TAG, String.format(loggerFormat,Tag,log));
        }
    }

    @Override
    public void w(String Tag, String log) {
        if (isDebug&&level.ordinal()>= LoggerLevel.Warn.ordinal()){
            Log.v(TAG, String.format(loggerFormat,Tag,log));
        }
    }

    @Override
    public void e(String Tag, String log) {
        if (isDebug&&level.ordinal()>= LoggerLevel.Error.ordinal()){
            Log.e(TAG, String.format(loggerFormat,Tag,log));
        }
    }

    @Override
    public void setDebug(boolean isDebug) {
        this.isDebug=isDebug;
    }

    @Override
    public void setLogTAG(String tag) {
        this.TAG=tag;
    }

    @Override
    public void setLoggerLevel(LoggerLevel level) {

    }


    @Override
    public void setSaveUrl(String url) {

    }
}
