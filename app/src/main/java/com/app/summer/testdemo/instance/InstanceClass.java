package com.app.summer.testdemo.instance;

import android.util.Log;

/**
 * 单例设计模式
 */

public class InstanceClass {

    /**
     * 单例饿汉（线程安全，但是浪费资源）
     */
//    private static InstanceClass testClass = new InstanceClass();
//
//    public static InstanceClass getInstance(){
//        return testClass;
//    }


    /**
     * 单例懒汉模式(线程不安全)
     */
//    private static InstanceClass testClass = null;
//
//    public static InstanceClass getInstance(){
//        if (testClass == null){
//            testClass = new InstanceClass();
//        }
//        return testClass;
//    }

    /**
     * 静态单例（线程安全，推荐使用）
     */
    private static class t{
        private static final InstanceClass testClass = new InstanceClass();
    }

    public static InstanceClass getInstance(){
        return t.testClass;
    }




    public InstanceClass test1(){
        Log.e("TAG", "test1: " );
        return this;
    }
    public InstanceClass test2(){
        Log.e("TAG", "test2: " );
        return this;
    }
    public InstanceClass test3(){
        Log.e("TAG", "test3: " );
        return this;
    }
    public InstanceClass test4(){
        Log.e("TAG", "test4: " );
        return this;
    }
}
