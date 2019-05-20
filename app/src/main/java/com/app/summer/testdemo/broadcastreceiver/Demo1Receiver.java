package com.app.summer.testdemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class Demo1Receiver extends BroadcastReceiver {

    public static final String TAG = "Demo1Receiver1111";

    @Override
    public void onReceive(Context context, Intent intent) {

        String str = intent.getStringExtra("msg");

        Log.e("TAG", "onReceive1111111: " + str );

        //有序广播才能用这个方法,中断
        abortBroadcast();
//        Bundle bundle = new Bundle();
//        bundle.putString("test","广播处理的数据");
//        setResultExtras(bundle);

    }
}
