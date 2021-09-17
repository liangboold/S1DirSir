package com.bw.mvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.bw.di.BaseApplication;
import com.bw.di.component.ActivityComponent;
import com.bw.di.component.DaggerActivityComponent;
import com.bw.di.module.ActivityModule;
import com.bw.mvp.presenter.BasePresenter;

import javax.inject.Inject;


/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/16 19:29
 * @Version 1.0
 */
public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity {
    protected ActivityComponent activityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activityComponent = DaggerActivityComponent.builder().appComponent(((BaseApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this)).build();
        injectComponent();
        super.onCreate(savedInstanceState);
    }

    protected abstract void injectComponent();
}
