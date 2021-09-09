package com.bw.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.util.*

/*
 * @ClassName GlideUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/9 19:11
 * @Version 1.0
*/
object GlideUtil {
    fun imgLoad(path:Objects,img:ImageView){
        Glide.with(App.context!!).load(path).into(img)
    }
    fun imgLoadCircle(path:Objects,img:ImageView){
        Glide.with(App.context!!).load(path).transform(CircleCrop()).into(img)
    }
    fun imgLoadRounded(path:Objects,img:ImageView,corners: Int){
        Glide.with(App.context!!).load(path).transform(RoundedCorners(corners)).into(img)
    }
}