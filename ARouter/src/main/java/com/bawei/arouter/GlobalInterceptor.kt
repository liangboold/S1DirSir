package com.bawei.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/*
 * @ClassName GlobalInterceptor
 * @Description TODO
 * @Author 海
 * @Date 2021/9/9 9:31
 * @Version 1.0
*/
//定义一个拦截器，需要name随便写一个即可
@Interceptor(name = "/service/interceptor", priority = 9)
class GlobalInterceptor : IInterceptor{
    private var context: Context? = null
    override fun init(context: Context?) {
        this.context = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        //错误后失效的时间
        postcard?.timeout = 1
        val flag = postcard?.extra
    }

}