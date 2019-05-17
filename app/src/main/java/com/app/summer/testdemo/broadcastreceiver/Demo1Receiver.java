package com.app.summer.testdemo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class Demo1Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("TAG", "onReceive: "
                +"接收到的Intent的Action位："
                +intent.getAction()
                +"\n消息内容是："
                +intent.getStringExtra("msg"));

    }
}
