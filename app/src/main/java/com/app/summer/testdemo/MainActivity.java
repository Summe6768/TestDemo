package com.app.summer.testdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.summer.testdemo.Dagger2.activity.Dagger2Activity;
import com.app.summer.testdemo.broadcastreceiver.BroadcastReceiverActivity;
import com.app.summer.testdemo.mvvm.MvvmActivity;
import com.app.summer.testdemo.sqlite.SqlLiteActivity;
import com.app.summer.testdemo.sqlite2.MySQLiteActivity;
import com.app.summer.testdemo.thisandsuper.ThisAndSuperActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnDagger2;
    private Button mBtnMvvm;
    private Button mBtnBroadcastReceiver;
    private Button mBtnSqLite;
    private Button mBtnSqLite2;
    private Button mBtnThisAndSuper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initOnClick();
    }


    private void initView() {
        mBtnDagger2 = findViewById(R.id.btnDagger2);
        mBtnMvvm = findViewById(R.id.btnMvvm);
        mBtnBroadcastReceiver = findViewById(R.id.btnBroadcastReceiver);
        mBtnSqLite = findViewById(R.id.btnSqLite);
        mBtnSqLite2 = findViewById(R.id.btnSqLite2);
        mBtnThisAndSuper = findViewById(R.id.btnThisAndSuper);
    }

    private void initOnClick() {
        mBtnDagger2.setOnClickListener(this);
        mBtnMvvm.setOnClickListener(this);
        mBtnBroadcastReceiver.setOnClickListener(this);
        mBtnSqLite.setOnClickListener(this);
        mBtnSqLite2.setOnClickListener(this);
        mBtnThisAndSuper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
        }
    }
}
