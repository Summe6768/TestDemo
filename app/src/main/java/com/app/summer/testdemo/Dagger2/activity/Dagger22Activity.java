package com.app.summer.testdemo.Dagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.summer.testdemo.Dagger2.Component.DaggerLoginComponent;
import com.app.summer.testdemo.Dagger2.module.UserModule;
import com.app.summer.testdemo.Dagger2.myApplication.MyApplication;
import com.app.summer.testdemo.R;

public class Dagger22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger22);


        DaggerLoginComponent
                .builder()
                .userModule(new UserModule(this,""))
                .appComponent(((MyApplication)getApplication()).getAppComponent())
                .build()
                .inject(this);
    }
}
