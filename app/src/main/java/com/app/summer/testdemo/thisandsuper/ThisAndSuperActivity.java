package com.app.summer.testdemo.thisandsuper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.summer.testdemo.R;
import com.app.summer.testdemo.thisandsuper.superclass.TestSuperClass;
import com.app.summer.testdemo.thisandsuper.thisclass.TestThisClass;

public class ThisAndSuperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_and_super);

        TestSuperClass testSuperClass = new TestSuperClass();
        testSuperClass.value();
    }
}
