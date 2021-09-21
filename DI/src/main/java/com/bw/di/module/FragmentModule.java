package com.bw.di.module;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.bw.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/*
 * @ClassName FragmentModule
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/18 9:58
 * @Version 1.0
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @ActivityScope
    @Provides
    public Fragment provideFragment(){
        return fragment;
    }
}
