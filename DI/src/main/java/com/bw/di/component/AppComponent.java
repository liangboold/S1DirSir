package com.bw.di.component;

import android.content.Context;


import com.bw.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/10 19:09
 * @Version 1.0
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();
}
