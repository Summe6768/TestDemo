package com.app.summer.testdemo.proxy.dynamicProxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jingwei
 * date: 2019/7/30
 * desc:
 */
public class GuitaiA implements InvocationHandler {

    private Object object;

    public GuitaiA(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Log.e("TAG", "invoke :" + "销售开始  柜台是： " + this.getClass().getSimpleName());
        method.invoke(object, args);
        Log.e("TAG", "invoke :" + "销售结束");

        return null;
    }
}
