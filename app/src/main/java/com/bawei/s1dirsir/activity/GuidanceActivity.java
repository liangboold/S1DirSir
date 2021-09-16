package com.bawei.s1dirsir.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.GuidanceAdapter;
import com.bw.mvp.view.BaseActivty;

import java.util.ArrayList;

public class GuidanceActivity extends BaseActivty {

    private ViewPager vp;
    private Button btnTiao;
    private ArrayList<Integer> integers;

    @Override
    public int bindLayout() {
        return R.layout.activity_zhuye;
    }
    @Override
    public void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        btnTiao = (Button) findViewById(R.id.btn_tiao);
    }

    @Override
    public void initData() {
        integers = new ArrayList<>();
        integers.add(R.drawable.a11);
        integers.add(R.drawable.a22);
        integers.add(R.drawable.a33);



    }

    @Override
    public void showLoading() {
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
}