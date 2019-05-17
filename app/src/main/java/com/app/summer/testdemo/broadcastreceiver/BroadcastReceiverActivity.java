package com.app.summer.testdemo.broadcastreceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.summer.testdemo.R;

public class BroadcastReceiverActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    public void btnOnClickBroadcastReceiver(View view) {

        Intent intent = new Intent("com.hhh");
        intent.setComponent(new ComponentName(
                "com.app.summer.demo",
                "com.app.summer.demo.broadcastreceiver.Demo1Receiver"
                )
        );
        intent.putExtra("msg", "这是广播发送的消息");
        sendBroadcast(intent);

    }
}
