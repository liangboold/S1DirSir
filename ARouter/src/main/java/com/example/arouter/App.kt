package com.example.arouter

import android.app.Application
import com.alibaba.android.arouter.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter

/*
 * @ClassName App
 * @Description TODO
 * @Author 海
 * @Date 2021/9/9 9:53
 * @Version 1.0
*/
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            // 日志开启
            ARouter.openLog()
            // 调试模式开启，如果在install run模式下运行，则必须开启调试模式
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}