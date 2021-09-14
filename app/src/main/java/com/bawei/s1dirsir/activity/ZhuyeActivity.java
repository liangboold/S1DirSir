package com.bawei.s1dirsir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adarpter.Zhuadarpter;

import java.util.ArrayList;
import java.util.List;

public class ZhuyeActivity extends AppCompatActivity {

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
        Zhuadarpter zhuadarpter = new Zhuadarpter(this, integers);
        vp.setAdapter(zhuadarpter);
        btnTiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZhuyeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        btnTiao = (Button) findViewById(R.id.btn_tiao);
    }
}