package com.example.s1dirsir;


import android.content.Context;
import android.view.View;

import com.bw.database.user.GreenDaoManager;
import com.bw.database.user.User;
import com.bw.database.user.UserDao;
import com.bw.mvp_library.v.BaseActivty;
public class MainActivity extends BaseActivty {

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void immersive() {
        super.immersive();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
    }
}