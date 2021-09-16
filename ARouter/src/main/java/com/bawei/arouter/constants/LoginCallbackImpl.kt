package com.bawei.arouter

import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.bawei.arouter.constants.ConfigConstants


/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName LoginCallbackImpl
 * @Description TODO
 * @Author 海
 * @Date 2021/9/16 8:10
 * @Version 1.0
*/
class LoginNavigationCallbackImpl : NavigationCallback {
    //找到了
    override fun onFound(postcard: Postcard?) {}

    //找不到
    override fun onLost(postcard: Postcard?) {}

    //跳转成功
    override fun onArrival(postcard: Postcard?) {}
    override fun onInterrupt(postcard: Postcard) {
        val path = postcard.path
        Log.i("TAG", "onInterrupt: $path")
        val bundle = postcard.extras
        // 被登录拦截了下来了
        // 需要调转到登录页面，把参数跟被登录拦截下来的路径传递给登录页面，登录成功后再进行跳转被拦截的页面
        ARouter.getInstance().build(ConfigConstants.LOGIN_PATH)
            .with(bundle)
            .withString(ConfigConstants.PATH, path)
            .navigation()
    }
}