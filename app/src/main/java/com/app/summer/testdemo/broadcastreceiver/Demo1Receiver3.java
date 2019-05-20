package com.app.summer.testdemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Demo1Receiver3 extends BroadcastReceiver {

    public static final String TAG = "Demo1Receiver333";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + "收到了异步广播" );
    }
}
