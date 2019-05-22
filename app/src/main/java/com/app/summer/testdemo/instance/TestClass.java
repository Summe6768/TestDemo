package com.app.summer.testdemo.instance;

import android.util.Log;

import com.app.summer.testdemo.Dagger2.ano.Test;

public class TestClass {


    /**
     * 单例懒汉模式
     */
    private static TestClass testClass;

    public static TestClass getInstance(){
        if (testClass == null){
            testClass = new TestClass();
        }
        return testClass;
    }

    /**
     * 静态单例
     */
//    private static class t{
//        private static final TestClass testClass = new TestClass();
//    }
//
//    public static TestClass getInstance(){
//        return t.testClass;
//    }




    public TestClass test1(){
        Log.e("TAG", "test1: " );
        return this;
    }
    public TestClass test2(){
        Log.e("TAG", "test2: " );
        return this;
    }
    public TestClass test3(){
        Log.e("TAG", "test3: " );
        return this;
    }
    public TestClass test4(){
        Log.e("TAG", "test4: " );
        return this;
    }
}
