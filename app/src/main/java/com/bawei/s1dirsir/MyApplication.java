package com.bawei.s1dirsir;

import com.bw.di.BaseApplication;
import com.tencent.bugly.crashreport.CrashReport;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "25e990c2a2", false);
    }
}
