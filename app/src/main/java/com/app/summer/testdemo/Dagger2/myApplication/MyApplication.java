package com.app.summer.testdemo.Dagger2.myApplication;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.app.summer.testdemo.Dagger2.Component.AppComponent.AppComponent;
import com.app.summer.testdemo.Dagger2.Component.AppComponent.DaggerAppComponent;
import com.taobao.sophix.SophixManager;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Bugly初始化
        CrashReport.initCrashReport(getApplicationContext(), "46ea81ed85", true);

        appComponent = DaggerAppComponent.create();


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
