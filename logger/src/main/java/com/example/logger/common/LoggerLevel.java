package com.example.logger.common;

/*
 * @ClassName LoggerLevel
 * @Description TODO
 * @Author 海
 * @Date 2021/9/13 19:52
 * @Version 1.0
 */
public enum LoggerLevel {
    Verbose(1),Debug(2),Info(3),Warn(4),Error(5);
    private int value=0;
    LoggerLevel(int _value){
        this.value=_value;
    }
}