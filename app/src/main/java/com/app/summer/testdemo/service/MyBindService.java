package com.app.summer.testdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBindService extends Service {

    private static final String TAG = "MyBindService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    public void Play() {
        Log.e(TAG, "播放");
    }

    public void Pause() {
        Log.e(TAG, "暂停");
    }

    public void Next() {
        Log.e(TAG, "下一首");
    }

    public void Pervious() {
        Log.e(TAG, "上一首");
    }

    public class MyBind extends Binder {
        public MyBindService getService() {
            return MyBindService.this;
        }
    }
}
