package com.app.summer.testdemo.proxy.staticProxy;

import android.util.Log;

/**
 * @author jingwei
 * date: 2019/7/30
 * desc: 静态代理  类
 */
public class Cinema implements Movie {

    private RealMovie realMovie;

    public Cinema(RealMovie realMovie) {
        super();
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        guanggao(true);
        realMovie.play();
        guanggao(false);
    }

    private void guanggao(boolean isStart){
        if ( isStart ) {
            Log.e("TAG", "guanggao :" + "电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            Log.e("TAG", "guanggao :" + "电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }

}
