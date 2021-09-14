package com.bawei.log;

import android.app.Application;

/*
 * @ClassName App
 * @Description TODO
 * @Author 海
 * @Date 2021/9/10 20:13
 * @Version 1.0
 */
public interface ILog  {

    /**
     * 日志打印接口
     * @param level
     * @param tag
     * @param msg
     */
    void print(int level,String tag, String msg);

    /**
     * 设置是否写入文件
     * @param isWrite
     */
    void setWriteFile(boolean isWrite);

}