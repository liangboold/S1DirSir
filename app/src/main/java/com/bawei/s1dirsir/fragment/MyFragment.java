package com.bawei.s1dirsir.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.activity.MainActivity;
import com.bawei.s1dirsir.activity.OrderFormActivity;
import android.widget.RelativeLayout;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.activity.AddressActivity;
import com.bw.mvp.view.BaseMVPFragment;

public class MyFragment extends BaseMVPFragment {

    private ImageView user;
    private TextView orderForm;
    private RelativeLayout receiv;

    @Override
    protected void initData() {
    orderForm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), OrderFormActivity.class);
            startActivity(intent);
        }
    });
    }

    @Override
    protected void initEvent() {
        receiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddressActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

        user = (ImageView) findViewById(R.id.user);
        orderForm = (TextView) findViewById(R.id.order_form);
        user = (ImageView) findViewById(R.id.user);
        receiv = (RelativeLayout) findViewById(R.id.receiv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void injectCompoent() {

    }

}