package com.app.summer.testdemo.Dagger2.object;

import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/10
 */
public class ApiService {

    private String str;

    public ApiService(String string){
        this.str = string;
    }


    public void apiService1() {
        Log.e("TAG", "apiService1:...." );
    }
}
