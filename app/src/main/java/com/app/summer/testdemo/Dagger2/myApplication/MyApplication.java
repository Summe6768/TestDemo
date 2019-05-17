package com.app.summer.testdemo.Dagger2.myApplication;

import android.app.Application;

import com.app.summer.testdemo.Dagger2.Component.AppComponent.AppComponent;
import com.app.summer.testdemo.Dagger2.Component.AppComponent.DaggerAppComponent;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
