package com.bw.di.component;

import android.app.Activity;
import android.content.Context;


import com.bw.di.module.ActivityModule;
import com.bw.di.scope.ActivityScope;

import dagger.Component;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/10 19:09
 * @Version 1.0
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();
    Context context();
}
