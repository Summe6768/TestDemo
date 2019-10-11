package com.app.summer.testdemo.proxy.dynamicProxy;

import android.util.Log;

/**
 * @author jingwei
 * date: 2019/7/30
 * desc:
 */
public class MaotaiJiu implements SellWine {
    @Override
    public void mainJiu() {
        Log.e("TAG", "mainJiu :" + "我卖得是茅台酒。");
    }
}
