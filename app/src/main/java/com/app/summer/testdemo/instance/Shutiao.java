package com.app.summer.testdemo.instance;

import android.util.Log;

import com.app.summer.testdemo.instance.interfacetest.Eat;

/**
 *薯条类
 */
public class Shutiao implements Eat {
    @Override
    public void est() {
        Log.e("TAG", "est: " + "我吃到了薯条");
    }
}
