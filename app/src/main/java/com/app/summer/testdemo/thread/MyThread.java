package com.app.summer.testdemo.thread;

import android.util.Log;

/**
 *
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            sleep(1000);
            Log.e("TAG", "run " + "1111" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
