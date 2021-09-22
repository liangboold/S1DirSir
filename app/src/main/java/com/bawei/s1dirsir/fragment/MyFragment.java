package com.bawei.s1dirsir.fragment;


import android.view.View;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.HomePresenter;
import com.bw.mvp.view.BaseMVPFragment;

import javax.inject.Inject;

public class MyFragment extends BaseMVPFragment implements HomeContract {

    @Inject
    HomePresenter presenter;
    private TextView tv;

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.initHome();
            }
        });
    }

    @Override
    protected void initView() {

        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void injectCompoent() {
        DaggerHomeComponent.builder().fragmentComponent(fragmentComponent)
                .homeModule(new HomeModule(this))
                .build().injectFragment(this);
    }

    @Override
    public void foodSuccess(BaseBean baseBean) {
        System.out.println(baseBean.toString());
    }

    @Override
    public void foodFailed(Throwable throwable) {

    }
}