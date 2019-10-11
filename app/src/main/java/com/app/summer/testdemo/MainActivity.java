package com.app.summer.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.summer.mvp.ui.MvpActivity;
import com.app.summer.mvvm.ui.Mvvm1Activity;
import com.app.summer.testdemo.Dagger2.activity.Dagger2Activity;
import com.app.summer.testdemo.ViewOnTouchEvent.ViewOnTouchEventActivity;
import com.app.summer.testdemo.bean.SetListBean;
import com.app.summer.testdemo.broadcastreceiver.BroadcastReceiverActivity;
import com.app.summer.testdemo.contentprovider.ContentProviderActivity;
import com.app.summer.testdemo.enumtest.TestEnum;
import com.app.summer.testdemo.fanxing.FanxingActivity;
import com.app.summer.testdemo.handler.HandlerActivity;
import com.app.summer.testdemo.instance.GongChang;
import com.app.summer.testdemo.instance.interfacetest.Eat;

import com.app.summer.testdemo.kotlin.KotlinActivity;
import com.app.summer.testdemo.mvvm.MvvmActivity;
import com.app.summer.testdemo.proxy.dynamicProxy.GuitaiA;
import com.app.summer.testdemo.proxy.dynamicProxy.MaotaiJiu;
import com.app.summer.testdemo.proxy.dynamicProxy.SellWine;
import com.app.summer.testdemo.proxy.staticProxy.Cinema;
import com.app.summer.testdemo.proxy.staticProxy.Movie;
import com.app.summer.testdemo.proxy.staticProxy.RealMovie;
import com.app.summer.testdemo.recycleView.RecycleViewActivity;
import com.app.summer.testdemo.rxjava.RxJavaActivity;
import com.app.summer.testdemo.service.ServiceActivity;
import com.app.summer.testdemo.sqlite.SqlLiteActivity;
import com.app.summer.testdemo.sqlite2.MySQLiteActivity;
import com.app.summer.testdemo.thisandsuper.ThisAndSuperActivity;
import com.app.summer.testdemo.thread.ThreadActivity;
import com.app.summer.testdemo.utlis.SetList;


import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private HashMap<Object, Object> config = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        for (TestEnum testEnum : TestEnum.values()) {
            //Log.e(TAG, "onCreate: " + testEnum);
        }
        config.put(TestEnum.A, "123");

        //简单工厂设计模式
        //gongchang();

        Log.e("TAG", "onCreate "  );

        //静态代理模式
        staticProxy();
        //动态代理模式
        dynamicProxy();

        SetList<SetListBean> setList = new SetList<>();

        setList.add(new SetListBean("11111",1));
        setList.add(new SetListBean("11111",1));

        setList.add(new SetListBean("22222",1));
        setList.add(new SetListBean("22222",1));

        Log.e("TAG", "onCreate SetList:" + setList);



    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
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
            case R.id.btnMvvmModule:
                startActivity(new Intent(this, Mvvm1Activity.class));
                break;
            case R.id.btnFanxing:
                startActivity(new Intent(this, FanxingActivity.class));
                break;
            case R.id.btnThread:
                startActivity(new Intent(this, ThreadActivity.class));
                break;
            case R.id.btnHandler:
                startActivity(new Intent(this, HandlerActivity.class));
                break;
            case R.id.viewOnTouchEvent:
                startActivity(new Intent(this, ViewOnTouchEventActivity.class));
                break;
            case R.id.btn_recycleView:
                startActivity(new Intent(this, RecycleViewActivity.class));
                break;
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart "  );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "onRestart "  );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume "  );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause "  );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop "  );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy "  );
    }

    /**
     * 静态代理模式
     */
    private void staticProxy(){
        RealMovie realMovie = new RealMovie();
        Cinema cinema = new Cinema(realMovie);
        cinema.play();
    }

    /**
     * 动态代理模式
     */
    private void dynamicProxy(){
        MaotaiJiu maotaiJiu = new MaotaiJiu();
        GuitaiA guitaiA = new GuitaiA(maotaiJiu);

        SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), guitaiA);

        dynamicProxy.mainJiu();

    }
}
