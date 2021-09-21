package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bw.mvp.view.BaseMVPActivity;

public class ShopListActivity extends BaseMVPActivity {
    private ImageView back;


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
    protected void initEvent() {

    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_list;
    }


    @Override
    protected void injectComponent() {

    }
}