package com.bawei.arouter.constants

import com.alibaba.android.arouter.BuildConfig

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName ConfigConstants
 * @Description TODO
 * @Author 海
 * @Date 2021/9/15 20:24
 * @Version 1.0
*/
object ConfigConstants {
    const val IS_DEBUG = BuildConfig.DEBUG
    const val TAG = "TAG"
    const val PATH = "path"

    //存储是否登录的
    const val SP_IS_LOGIN = "sp_is_login"
    private const val BASE_PATH = "/base/path/"

    //登录
    const val LOGIN_PATH = BASE_PATH + "login"

    //不需要登录的activity
    const val FIRST_PATH = BASE_PATH + "first"

    //登录登录的actvity
    const val SECOND_PATH = BASE_PATH + "second"
}
