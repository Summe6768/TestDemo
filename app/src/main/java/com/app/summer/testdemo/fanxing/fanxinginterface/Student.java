package com.app.summer.testdemo.fanxing.fanxinginterface;

/**
 *
 */
public class Student implements Listen<Piano>{

    @Override
    public void listen(Piano piano) {
        piano.paly();
    }
}
