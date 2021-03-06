package com.bawei.log;


import android.content.Context;

import java.util.logging.LogManager;

/*
 * @ClassName RuntimeEnv
 * @Description TODO
 * @Author 海
 * @Date 2021/9/11 8:24
 * @Version 1.0
 */
public class RuntimeEnv {
    /**
     * 调试用的标志
     */
    private static final String TAG = RuntimeEnv.class.getSimpleName();

    /**
     * 运行时的Application 类型的Context
     */
    public static Context appContext = null;
    /**
     * 进程名 子进程将按照 主进程_子进程 显示
     */
    public static String procName = "";
    /**
     * 包名
     */
    public static String packageName = "";
    /**
     * 应用名称
     */
    public static String appName = "";

    private static final int MY_PERMISSIONS_REQUEST_WRITE_STORE = 1;

    /***
     * 获取当前运行的类的方法 和行数
     * @return
     */
    public static String getCurrentMethodName() {
        StackTraceElement element = getCallLogManagerStackTrace();
        if (element != null){
            String methodName = element.getMethodName();
            int lineNumber = element.getLineNumber();
            return methodName + "() " + lineNumber;
        }
        return null;
    }

    /***
     * 获取当前运行的类的方法 和行数
     * @return
     */
    public static String getCurrentMethodName2() {
        StackTraceElement element = getCallLogManagerStackTrace();
        if (element != null){
            String methodName = element.getMethodName();
            return methodName;
        }
        return null;
    }

    /***
     * 获取当前运行的类的行数
     * @return
     */
    public static int getCurrentLineNumber() {
        StackTraceElement element = getCallLogManagerStackTrace();
        if (element != null){
            return element.getLineNumber();
        }
        return -1;
    }


    /**
     * 获取当前运行的Class
     * @return
     */
    public static String getCurrentClassName() {
        StackTraceElement element = getCallLogManagerStackTrace();
        if (element != null){
            String clazz = element.getClassName();
            //去最后一个即 类的简名
            if (clazz.contains(".")){
                String strArray[] = clazz.split("\\.");
                clazz = strArray[strArray.length -1];
            }
            return clazz;
        }
        return null;
    }

    /**
     * 获取当前运行的Class
     * @return
     */
    public static String getCurrentFileName() {
        StackTraceElement element = getCallLogManagerStackTrace();
        if (element != null){
            String fileName = element.getFileName();
            return fileName;
        }
        return null;
    }

    /**
     * 获取调用LogManager的调用栈
     * @return
     */
    private static StackTraceElement getCallLogManagerStackTrace(){
        int level = 0;
        //LogManager的全限定名称
        String clazzName = LogManager.class.getCanonicalName();
        //方法数组
        String array[] = new String[]{"v","d","i","w","e"};

        StackTraceElement[] stacks = new Throwable().getStackTrace();
        //依次寻找，找到LogManager的上一级
        for (level = 0 ;level < stacks.length;level++){
            String method = stacks[level].getMethodName();

            if (clazzName.equals(stacks[level].getClassName()) && (method.equals(array[0])
                    || method.equals(array[1]) || method.equals(array[2])
                    || method.equals(array[3]) || method.equals(array[4]))){
                break;
            }
        }

        //返回上一级的调用栈
        if (stacks.length > (level + 1)){
            return stacks[level +1];
        }
        return null;
    }



} 