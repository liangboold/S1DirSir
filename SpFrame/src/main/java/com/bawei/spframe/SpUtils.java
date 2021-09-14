package com.bawei.spframe;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ClassName SpUtils
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/11 8:37
 * @Version 1.0
 */
public class SpUtils {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SpUtils(Context context,String fileName){
        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    //向sp中存入指定key对应的数据，其中value可以是String,boolean,float,int,long等各种基本类型的值，
    public void putString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }

    public void putBoolean(String key,boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putFloat(String key,float value){
        editor.putFloat(key, value);
        editor.commit();
    }

    public void putInt(String key,int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void putLong(String key,long value){
        editor.putLong(key, value);
        editor.commit();
    }

    //清除sp里的所有数据
    public void clear(){
        editor.clear();
        editor.commit();
    }

    //删除sp里指定key的数据项
    public void remove(String key){
        editor.remove(key);
        editor.commit();
    }

    //获取指定key对应的value，如果key不存在，则返回默认值defvalue
    public String getString(String key,String defValue){
        return preferences.getString(key, defValue);
    }

    public boolean getBoolean(String key,boolean defValue){
        return preferences.getBoolean(key, defValue);
    }

    public float getFloat(String key,float defValue){
        return preferences.getFloat(key,defValue);
    }

    public int getInt(String key,int defValue){
        return preferences.getInt(key, defValue);
    }

    public long getLong(String key,long defValue){
        return preferences.getLong(key, defValue);
    }

    //判断sp是否包含特定key的数据
    public boolean contains(String key){
        return preferences.contains(key);
    }
}
