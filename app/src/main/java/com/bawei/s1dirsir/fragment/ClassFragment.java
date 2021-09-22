package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.s1dirsir.R;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.shoppingcart.JsonBean;

import java.util.ArrayList;

public class ClassFragment extends BaseMVPFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_class;
    }

    @Override
    public void onResume() {
        Intent intent = getActivity().getIntent();
        ArrayList<JsonBean.DataBean> data = intent.getParcelableArrayListExtra("data");
        System.out.println(data);
        super.onResume();
    }

    @Override
    protected void injectCompoent() {

    }
}