package com.app.summer.testdemo.fanxing.fanxingclass;

import android.util.Log;

/**
 *
 */
public class ShowObject<E> {
    public void showMess(E e){
        Log.e("TAG", "showMess " + e.toString());
    }
}
