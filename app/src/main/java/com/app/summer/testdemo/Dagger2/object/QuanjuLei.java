package com.app.summer.testdemo.Dagger2.object;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class QuanjuLei {
    public QuanjuLei() {

    }

    @Inject
    public void quanjufangfa() {
        Log.e("TAG", "quanjufangfa: ");
    }
}
