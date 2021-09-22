package com.bawei.s1dirsir.fragment;


import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.HomePresenter;
import com.bw.mvp.view.BaseMVPFragment;

import java.util.List;

import javax.inject.Inject;

public class MyFragment extends BaseMVPFragment {

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
        return R.layout.fragment_my;
    }

    @Override
    protected void injectCompoent() {

    }

}