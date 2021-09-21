package com.bw.mvp.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bw.di.BaseApplication;
import com.bw.di.component.DaggerFragmentComponent;
import com.bw.di.component.FragmentComponent;
import com.bw.di.module.FragmentModule;

/*
 * @ClassName BaseFragment
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/18 10:05
 * @Version 1.0
 */
public abstract class BaseMVPFragment extends BaseFragment{
    protected FragmentComponent fragmentComponent;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        fragmentComponent = DaggerFragmentComponent.builder().appComponent(((BaseApplication) getContext().getApplicationContext()).appComponent)
                .fragmentModule(new FragmentModule(this))
                .build();
        injectCompoent();
        super.onActivityCreated(savedInstanceState);

    }

    protected abstract void injectCompoent();
}
