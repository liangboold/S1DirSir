package com.bawei.s1dirsir.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bawei.s1dirsir.R;
import com.bw.database.user.GreenDaoManager;
import com.bw.mvp.view.BaseMVPActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GuidanceActivity extends AppCompatActivity {
    int time = 5;
    private TextView pageTvTime;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (time==0){
                startActivity(new Intent(GuidanceActivity.this,MainActivity.class));
                finish();
            }else {
                pageTvTime.setText(time+"");
            }
        }
    };
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
        initView();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time--;
                handler.sendEmptyMessage(0);
            }
        },0,1000);
    }

    private void initView() {
        pageTvTime = (TextView) findViewById(R.id.page_tv_time);
    }

}