package com.bw.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 * @ClassName BaseFragment
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/18 10:03
 * @Version 1.0
 */
abstract class BaseFragment extends Fragment {

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(getLayoutId(), container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    protected abstract void initData();

    protected abstract void initEvent();


    protected abstract void initView();

    protected abstract int getLayoutId();

    public <T extends View> T findViewById(int id) {
        return inflate.findViewById(id);
    }
}
