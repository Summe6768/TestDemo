package com.app.summer.testdemo.fanxing.fanxinginterface;

/**
 *
 */
public class Teacher implements Listen<Violin> {
    @Override
    public void listen(Violin violin) {
        violin.pull();
    }
}
