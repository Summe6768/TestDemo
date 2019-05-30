package com.app.summer.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.summer.mvp.R;
import com.app.summer.mvp.prsenter.Perenter;
import com.app.summer.mvp.view.View;

public class MvpActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_activity);

//        throw new RuntimeException("这是一个异常......");

    }


}
