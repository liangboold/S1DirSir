package com.bawei.s1dirsir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.GuidanceAdapter;
import com.bw.mvp.v.BaseActivty;

import java.util.ArrayList;
import java.util.List;

public class GuidanceActivity extends BaseActivty {

    private ViewPager vp;
    private Button btnTiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
        initView();
        List<Integer> integers = new ArrayList<>();
        integers.add(R.drawable.a11);
        integers.add(R.drawable.a22);
        integers.add(R.drawable.a33);
        GuidanceAdapter guidanceAdapter = new GuidanceAdapter(this, integers);
        vp.setAdapter(guidanceAdapter);
        btnTiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidanceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int bindLayout() {
        return 0;
    }
    @Override
    public void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        btnTiao = (Button) findViewById(R.id.btn_tiao);
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }
}