package com.bw.di.module;

import android.content.Context;


import com.bw.di.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/10 19:09
 * @Version 1.0
 */
@Module
public class AppModule {
    private BaseApplication application;
    public AppModule(BaseApplication _application){
        application=_application;
    }

    @Singleton
    @Provides
    public Context provideContext(){
        return application;
    }

}
