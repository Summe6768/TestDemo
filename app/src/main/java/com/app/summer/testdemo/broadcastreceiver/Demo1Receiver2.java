package com.app.summer.testdemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Demo1Receiver2 extends BroadcastReceiver {

    public static final String TAG = "Demo1Receiver222";

    @Override
    public void onReceive(Context context, Intent intent) {

        String str = intent.getStringExtra("msg");

        Log.e(TAG, "onReceive2222222: " + str );

//        Bundle bundle = getResultExtras(true);
//        String sr = bundle.getString("test");
//
//        Log.e(TAG, "bundle接收的数据: "  + sr);
    }

}
