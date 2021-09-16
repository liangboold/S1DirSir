package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bw.mvp.v.BaseActivty;

public class ShopListActivity extends BaseActivty {
    private ImageView back;

    @Override
    public int bindLayout() {
        return R.layout.activity_shop_list;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.back);
    }

    @Override
    public void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showLoading() {

    }
}