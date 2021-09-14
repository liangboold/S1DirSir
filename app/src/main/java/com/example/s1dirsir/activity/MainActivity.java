package com.example.s1dirsir.activity;

import android.widget.Toast;

import com.bw.mvp.v.BaseActivty;
import com.example.s1dirsir.inject.DaggerActivityComment;
import com.example.s1dirsir.inject.FoodModule;
import com.example.s1dirsir.R;
import com.example.s1dirsir.bean.JsonBean;
import com.example.s1dirsir.contract.FoodContract;
import com.example.s1dirsir.presenter.FoodPersenter;

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
        Toast.makeText(this, jsonBean.toString(), Toast.LENGTH_SHORT).show();
    }
}