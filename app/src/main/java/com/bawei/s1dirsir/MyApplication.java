package com.bawei.s1dirsir;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.bw.di.BaseApplication;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "25e990c2a2", false);
        //推送
        UMConfigure.init(this, "615e9c3b33d9774a4ad2625a",
                "DEF", UMConfigure.DEVICE_TYPE_PHONE , "d067ccc554d931eb220c0e06ac9eb7bd");

        init(this);
        //统计
        // 初始化SDK appkey在官方注册应用即可获取
        UMConfigure.init(this, "5efbf5110cafb29d4b000013", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, null);
        // 选用AUTO页面采集模式，如果是在AUTO页面采集模式下，则需要注意，所有Activity中都不能调用MobclickAgent.onResume和onPause方法
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
    public static void init(Context context) {

        //获取消息推送实例
        PushAgent pushAgent = PushAgent.getInstance(context);
        //注册推送服务，每次调用register方法都会回调该接口
        pushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i("123", "注册成功：deviceToken：--> " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("123", "注册失败：--> " + "s:" + s + ",s1:" + s1);
            }
        });
    }
}
