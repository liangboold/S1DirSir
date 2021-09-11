package com.bw.utils;

import android.widget.ImageView;

import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.Objects;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/10 19:09
 * @Version 1.0
 */
public class ImgUtil {
        
    public static void imgLoad(Object path,ImageView img){
        Glide.with( Utils.getApp()).load(path).into(img);
    }
    public static void  imgLoadCircle(Object path,ImageView img){
        Glide.with( Utils.getApp()).load(path).transform(new CircleCrop()).into(img);
    }
    public static void  imgLoadRounded(Object path,ImageView img,int corners){
        Glide.with( Utils.getApp()).load(path).transform(new RoundedCorners(corners)).into(img);
    }
}
