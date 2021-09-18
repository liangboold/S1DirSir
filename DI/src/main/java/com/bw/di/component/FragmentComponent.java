package com.bw.di.component;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.bw.di.module.FragmentModule;
import com.bw.di.scope.ActivityScope;

import dagger.Component;

/*
 * @ClassName FragmentModule
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/18 10:03
 * @Version 1.0
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {FragmentModule.class})
public interface FragmentComponent {
    Fragment fragment();
    Context context();
}
