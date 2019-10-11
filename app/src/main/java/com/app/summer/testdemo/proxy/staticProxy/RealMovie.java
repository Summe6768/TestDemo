package com.app.summer.testdemo.proxy.staticProxy;

import android.util.Log;

import com.app.summer.testdemo.proxy.staticProxy.Movie;

/**
 * @author jingwei
 * date: 2019/7/30
 * desc:
 */
public class RealMovie implements Movie {
    @Override
    public void play() {
        Log.e("TAG", "play :" + "您正在观看电影 《肖申克的救赎》");
    }
}
