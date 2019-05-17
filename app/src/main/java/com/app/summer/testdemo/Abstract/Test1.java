package com.app.summer.testdemo.Abstract;

/**
 * @author: Summer
 * @date: 2019/5/9
 */
public class Test1 extends AbstractTest {

    private int i = 1;

    @Override
    public void jisuan() {
        super.jisuan();
    }


    @Override
    public int test() {
        return i++;
    }

}
