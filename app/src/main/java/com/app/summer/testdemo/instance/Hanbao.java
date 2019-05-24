package com.app.summer.testdemo.instance;

import android.util.Log;

import com.app.summer.testdemo.instance.interfacetest.Eat;

/**
 *汉堡类
 */
public class Hanbao implements Eat {
    @Override
    public void est() {
        Log.e("TAG", "est: " + "我吃到了汉堡" );
    }
}
