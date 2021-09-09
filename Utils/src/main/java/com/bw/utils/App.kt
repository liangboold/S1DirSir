package com.bw.utils

import android.app.Application
import android.content.Context

/*
 * @ClassName App
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/9 19:13
 * @Version 1.0
 */
class App : Application() {
    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}