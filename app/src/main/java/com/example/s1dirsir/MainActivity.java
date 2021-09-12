package com.example.s1dirsir;


import android.app.Application;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.mvp.v.BaseActivty;

public class MainActivity extends BaseActivty<FoodPersenter> implements FoodContract.FoodView{


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        DaggerActivityComment.builder().foodModule(new FoodModule(this)).build().inject(this);
        p.initFood();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFood(JsonBean jsonBean) {

    }
}