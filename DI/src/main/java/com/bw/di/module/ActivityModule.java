package com.bw.di.module;

import android.app.Activity;


import com.bw.di.scope.ActivityScope;

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
public class ActivityModule {

    private Activity activity;
    public ActivityModule(Activity _activity){
        activity=_activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity(){
        return activity;
    }
}
