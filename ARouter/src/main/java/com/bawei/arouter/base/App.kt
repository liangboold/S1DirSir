package com.bawei.arouter.base

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
        // 初始化阿里巴巴路由框架
        if (BuildConfig.DEBUG){  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 日志开启
            ARouter.openLog()
            // 调试模式开启，如果在install run模式下运行，则必须开启调试模式
            ARouter.openDebug()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this)

    }


}