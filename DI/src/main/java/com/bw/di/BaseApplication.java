package com.bw.di;

import android.app.Application;

import com.bw.di.component.AppComponent;
import com.bw.di.component.DaggerAppComponent;
import com.bw.di.module.AppModule;


public class BaseApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppInjection();
    }

    private void initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
