package com.app.summer.testdemo.thisandsuper.superclass;

import android.util.Log;

/**
 * @author: Summer
 * @date: 2019/5/17
 */
public class TestSuperClass extends Country{
    String name;

    @Override
    public void value() {
        name = "shanghai";
        super.value();
        Log.e("TAG", "name: " + name );
        Log.e("TAG", "superName: " + super.name );
    }

}
