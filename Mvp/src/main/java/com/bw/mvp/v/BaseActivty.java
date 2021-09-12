package com.bw.mvp.v;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.mvp.p.IPresenter;

import javax.inject.Inject;


public abstract class BaseActivty<P extends IPresenter> extends AppCompatActivity implements IActivity,IView{
    @Inject
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        immersive();
        initView();
        initData();
        showLoading();
    }

    @Override
    public void immersive() {
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null){
            p.Destory();
            p = null;
        }
    }
}
