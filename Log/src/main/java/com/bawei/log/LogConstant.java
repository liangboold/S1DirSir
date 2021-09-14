package com.bawei.log;

import android.text.TextUtils;
import android.util.Log;

/*
 * @ClassName LogUtil
 * @Description TODO
 * @Author 海
 * @Date 2021/9/10 20:10
 * @Version 1.0
 */
public class LogConstant {

    public static final String TAG = "LOG";
    /**
     * Log的后缀
     */
    public static final String SUFFIX = "log";

    /**
     * Log文件的后缀
     */
    public static final String FILE_SUFFIX = ".log";

    /**
     * 默认名称
     */
    public static final String DEF_NAME = "log";

    /**
     * Priority constant for the println method; use v.
     */
    public static final int VERBOSE = 1;

    /**
     * Priority constant for the println method; use d.
     */
    public static final int DEBUG = 2;

    /**
     * Priority constant for the println method; use i.
     */
    public static final int INFO = 3;

    /**
     * Priority constant for the println method; use w.
     */
    public static final int WARN = 4;

    /**
     * Priority constant for the println method; use e
     */
    public static final int ERROR = 5;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 6;


    /**
     * 日志打印的标签
     */
    public static final String V = "V";
    public static final String D = "D";
    public static final String I = "I";
    public static final String W = "W";
    public static final String E = "E";
    public static final String A = "A";


}