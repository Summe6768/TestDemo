package com.app.summer.testdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.summer.mvp.activity.MvpActivity;
import com.app.summer.testdemo.Dagger2.activity.Dagger2Activity;
import com.app.summer.testdemo.broadcastreceiver.BroadcastReceiverActivity;
import com.app.summer.testdemo.contentprovider.ContentProviderActivity;
import com.app.summer.testdemo.enumtest.TestEnum;
import com.app.summer.testdemo.fanxing.FanxingActivity;
import com.app.summer.testdemo.instance.GongChang;
import com.app.summer.testdemo.instance.interfacetest.Eat;

import com.app.summer.testdemo.kotlin.KotlinActivity;
import com.app.summer.testdemo.mvvm.MvvmActivity;
import com.app.summer.testdemo.rxjava.RxJavaActivity;
import com.app.summer.testdemo.service.ServiceActivity;
import com.app.summer.testdemo.sqlite.SqlLiteActivity;
import com.app.summer.testdemo.sqlite2.MySQLiteActivity;
import com.app.summer.testdemo.thisandsuper.ThisAndSuperActivity;
import com.app.summer.testdemo.thread.ThreadActivity;
import com.app.summer.testdemo.utlis.APKVersionCodeUtils;


import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private HashMap<Object, Object> config = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (TestEnum testEnum : TestEnum.values()) {
            //Log.e(TAG, "onCreate: " + testEnum);
        }
        config.put(TestEnum.A, "123");

        //简单工厂设计模式
        gongchang();


    }


    public void onClickMainActivity(View v) {
        switch (v.getId()) {
            case R.id.btnDagger2:
                startActivity(new Intent(this, Dagger2Activity.class));
                break;
            case R.id.btnMvvm:
                startActivity(new Intent(this, MvvmActivity.class));
                break;
            case R.id.btnBroadcastReceiver:
                startActivity(new Intent(this, BroadcastReceiverActivity.class));
                break;
            case R.id.btnSqLite:
                startActivity(new Intent(this, SqlLiteActivity.class));
                break;
            case R.id.btnSqLite2:
                startActivity(new Intent(this, MySQLiteActivity.class));
                break;
            case R.id.btnThisAndSuper:
                startActivity(new Intent(this, ThisAndSuperActivity.class));
                break;
            case R.id.btnService:
                startActivity(new Intent(this, ServiceActivity.class));
                break;
            case R.id.btnContentProvider:
                startActivity(new Intent(this, ContentProviderActivity.class));
                break;
            case R.id.btnRxJava:
                startActivity(new Intent(this, RxJavaActivity.class));
                break;
            case R.id.btnKotlin:
                startActivity(new Intent(this, KotlinActivity.class));
                break;
            case R.id.btnMvp:
                startActivity(new Intent(this, MvpActivity.class));
                break;
            case R.id.btnFanxing:
                startActivity(new Intent(this, FanxingActivity.class));
                break;
            case R.id.btnThread:
//                startActivity(new Intent(this, ThreadActivity.class));
//                break;
                throw new RuntimeException("运行异常");
        }
    }


    private void gongchang() {
        GongChang gongChang = new GongChang();
        Eat eat = gongChang.getEat("shutiao");
        if (eat != null) {
            eat.est();
        }
        Eat eat2 = gongChang.getEat("hanbao");
        if (eat2 != null) {
            eat2.est();
        }
        Eat eat3 = gongChang.getEat("jiji");
        if (eat3 != null) {
            eat3.est();
        }
    }
}
