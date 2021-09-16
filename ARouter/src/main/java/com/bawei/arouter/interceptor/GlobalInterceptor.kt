package com.bawei.arouter.interceptor

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.bawei.arouter.constants.ConfigConstants


/*
 * @ClassName GlobalInterceptor
 * @Description TODO
 * @Author 海
 * @Date 2021/9/9 9:31
 * @Version 1.0
*/
//定义一个拦截器，需要name随便写一个即可
@Interceptor(name = "login", priority = 9)
class GlobalInterceptor : IInterceptor{
    private var context: Context? = null


    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        val path = postcard!!.path
        val isLogin = true
        //首先判断路径是否匹配 如果匹配上就需要跳转到登录
        if (path == ConfigConstants.SECOND_PATH) {
            if (isLogin) {
                callback!!.onContinue(postcard)
            } else {
                //被拦击去到登录页面
                ARouter.getInstance().build(ConfigConstants.LOGIN_PATH).navigation()
                //callback.onInterrupt(null);
            }
        } else { //路径不匹配说明该模块不需要登录
            callback!!.onContinue(postcard)
        }
    }
    override fun init(context: Context?) {
        Log.i("TAG", "init: 路由登录拦截器初始化成功");
    }

}