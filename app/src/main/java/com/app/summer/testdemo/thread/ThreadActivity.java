package com.app.summer.testdemo.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.summer.testdemo.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        MyThread thread = new MyThread();
        thread.start();

    }
}
