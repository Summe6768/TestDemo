package com.app.summer.testdemo.broadcastreceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.app.summer.testdemo.R;

import java.util.zip.Inflater;

public class BroadcastReceiverActivity extends AppCompatActivity {

    public static final String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

//        //动态注册广播，动态注册广播优先于静态注册广播
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("BC_one");
//        Demo1Receiver2 demo1Receiver2 = new Demo1Receiver2();
//        registerReceiver(demo1Receiver2,intentFilter);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend://发送一条普通广播
                Intent intent = new Intent();
                //Android targetSdkVersion 26以上版本必须加这个方法
                //intent.setComponent(new ComponentName(this, Demo1Receiver.class));
                intent.setAction("BC_one");
                intent.putExtra("msg", "这是一条普通广播");
                sendBroadcast(intent);
                break;
            case R.id.btnSend2://发送一条有序广播
                Intent intent2 = new Intent();
                intent2.setAction("BC_one");
                intent2.putExtra("msg", "这是一条有序广播");
                sendOrderedBroadcast(intent2,null);
                break;
            case R.id.btnSend3://发送一条异步广播
                Intent intent3 = new Intent();
                intent3.setAction("BC_Three");
                intent3.putExtra("msg", "这是一条有序广播");
                sendStickyBroadcast(intent3);

                IntentFilter intentFilter = new IntentFilter("BC_Three");
                Demo1Receiver3 demo1Receiver3 = new Demo1Receiver3();
                registerReceiver(demo1Receiver3,intentFilter);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态广播一定要结束掉
        //unregisterReceiver(demo1Receiver2);
    }
}
