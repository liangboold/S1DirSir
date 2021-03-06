package com.bawei.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * @ClassName LogManager
 * @Description TODO
 * @Author 海
 * @Date 2021/9/11 8:28
 * @Version 1.0
 */
public class LogManager {
    /**
     * 保存日志实现的Map，可用于多个文件，多个进程使用
     */
    private static Map<String,ILog> sLogMap = new HashMap<>();
    /**
     * 默认的日志实现对象
     */
    private static ILog sDefLogImpl = null;
    /**
     * 微信的Xlog实现
     */
    private static ILog sXlogImpl = null;

    /**
     * 默认的应用信息
     */
    private static final String APP_INFO_NAME = "DeviceInfo.txt";
    /**
     * 崩溃的日志文件
     */
    private static final String CRASH_FILE = "crash_file";



    /**
     * 初始化块
     */
    static {
        String logFile = getLogPath();
        //以当前进程名 为文件名
        //sDefLogImpl = new LogImpl(logFile);
        sLogMap.put(LogConstant.DEF_NAME,sXlogImpl);
        //sLogMap.put(LogConstant.DEF_NAME,sDefLogImpl);
    }

    /**
     *
     * @param tag
     * @param msg
     * @return
     */
    public static int v(String tag, String msg) {
        return printLog(LogConstant.VERBOSE,tag,msg);
    }

    /**
     *
     * @param tag
     * @param msg
     * @return
     */
    public static int d(String tag, String msg) {
        return printLog(LogConstant.DEBUG,tag,msg);
    }

    /**
     *
     * @param tag
     * @param msg
     * @return
     */
    public static int i(String tag, String msg) {
        return printLog(LogConstant.INFO,tag,msg);
    }

    /**
     *
     * @param tag
     * @param msg
     * @return
     */
    public static int w(String tag, String msg) {
        return printLog(LogConstant.WARN,tag,msg);
    }

    /**
     *
     * @param tag
     * @param msg
     * @return
     */
    public static int e(String tag, String msg) {
        return printLog(LogConstant.ERROR,tag,msg);
    }

    /**
     * 日志打印函数
     * @param level
     * @param tag
     * @param msg
     * @return
     */
    private static int printLog(int level,String tag, String msg){
        //依次遍历map打开开关
        for (Map.Entry<String,ILog> entry : sLogMap.entrySet()){
            entry.getValue().print(level,tag,msg);
        }
        return 0;
    }


    /**
     * 保存获取的 软件信息，设备信息，异常信息到存储设备中
     * @param e
     * @return
     */
    public static String writeExceptionToFile(Throwable e) {
        String fileName = null;
        StringBuffer sb = new StringBuffer();

        //添加时间,进程等信息 打印进程ID 线程ID
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String time = sf.format(new Date());
        String message = time + " "
                + ""+ android.os.Process.myPid() + "|" +""+ android.os.Process.myTid()
                + "[" + RuntimeEnv.getCurrentFileName() + "->" + RuntimeEnv.getCurrentMethodName()+"]"
                + " ";
        sb.append(message);

        //崩溃的详细信息
        sb.append(getExecptionInfo(e));

        Log.d(LogConstant.TAG,"writeExceptionToFile --> " + sb.toString());

        //保存文件 手机应用目录
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

            //文件目录 包名/log/crash/
            File dir = new File(AndroidUtil.getExternalDataPath() + File.separator  + LogConstant.SUFFIX + File.separator + "crash" );
            //重新创建
            if (!dir.exists()){
                dir.mkdir();
            }
            //异常信息文件格式 时间 + .log
            fileName = dir.toString() + File.separator + getFormatTime("yyyy-MM-dd HH-mm-ss.SSS") + "_crash.log";
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(fileName);
                fos.write(sb.toString().getBytes());
                fos.flush();
                fos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }finally {
                try {
                    if (fos != null){
                        fos.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return fileName;
    }

    /**
     * 获取CrashFile
     * @return
     */
    public static File getCrashFile(){
        String fileName = RuntimeEnv.appContext.getSharedPreferences(RuntimeEnv.appContext.getPackageName(), Context.MODE_PRIVATE)
                .getString(CRASH_FILE,"");
        return new File(fileName);
    }

    /**
     * 缓存crashFile文件
     * @param fileName
     */
    public static void cacheCrashFile(String fileName) {
        SharedPreferences sp = RuntimeEnv.appContext.getSharedPreferences(RuntimeEnv.appContext.getPackageName(),Context.MODE_PRIVATE);
        sp.edit().putString(CRASH_FILE,fileName).commit();

    }

    /**
     * 获取系统未捕捉的错误信息
     * @param throwable
     * @return
     */
    public static String getExecptionInfo(Throwable throwable){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);

        //原因
        Throwable cause = throwable.getCause();
        while (cause != null){
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        return stringWriter.toString();
    }

    /**
     * 获取格式化时间
     * @param formatStr
     * @return
     */
    private static String getFormatTime(String formatStr) {
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        return df.format(System.currentTimeMillis());
    }

//    /**
//     * 设置开关的状态
//     * @param open
//     */
//    public static void openLog(boolean open){
//        //依次遍历map打开开关
//        for (Map.Entry<String,ILog> entry : sLogMap.entrySet()){
//            entry.getValue().setOpen(open);
//        }
//    }

    /**
     * 设置是否写入文件
     * @param write
     */
    public static void writeFile(boolean write){
        //依次遍历map打开开关
        for (Map.Entry<String,ILog> entry : sLogMap.entrySet()){
            entry.getValue().setWriteFile(write);
        }
    }

    private static String getLogPath(){
        //先创建文件夹 默认存储在 包名 + log 目录下
        File dir = new File(AndroidUtil.getExternalDataPath() + File.separator + LogConstant.SUFFIX);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String path = dir.getPath() + File.separator + RuntimeEnv.procName + LogConstant.FILE_SUFFIX;
        File outFile = new File(path);
        try {
            if (!outFile.exists()){
                outFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path ;
    }

} 