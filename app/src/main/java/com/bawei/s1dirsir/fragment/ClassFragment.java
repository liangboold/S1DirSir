package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.s1dirsir.R;
import com.bw.shoppingcart.JsonBean;

import java.util.ArrayList;

public class ClassFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_class, container, false);
    }

    @Override
    public void onResume() {
        Intent intent = getActivity().getIntent();
        ArrayList<JsonBean.DataBean> data = intent.getParcelableArrayListExtra("data");
        System.out.println(data);
        super.onResume();
    }
}