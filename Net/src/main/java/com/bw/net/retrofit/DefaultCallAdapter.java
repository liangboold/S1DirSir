package com.bw.net.retrofit;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @package:com.bw.net.retrofit
 * @fileName:DefaultCallAdapter
 * @date on:2021/9/9 9:06
 * @another:HG
 * @email:1572651596@qq.com
 */
public class DefaultCallAdapter<R>implements CallAdapter<R,Object> {
    Type mType = null;

    public DefaultCallAdapter(Type mType) {
        this.mType = mType;
    }

    @Override
    public Type responseType() {
        return mType;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
