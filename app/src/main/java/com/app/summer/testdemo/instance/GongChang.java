package com.app.summer.testdemo.instance;

import android.util.Log;

import com.app.summer.testdemo.instance.interfacetest.Eat;

/**
 *工厂设计模式
 */
public class GongChang {
    public Eat getEat(String name) {
        switch (name){
            case "shutiao":
                return new Shutiao();
            case "hanbao":
                return new Hanbao();
                default:
                    Log.e("TAG", "getEat: " + "我们不生产此产品" );
                    return null;
        }
    }
}
