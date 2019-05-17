package com.app.summer.testdemo.Dagger2.object;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * @author: Summer
 * @date: 2019/5/13
 */
public class UserStore {

    private Context mContext;

    @Inject
    public UserStore(Context context) {
        mContext = context;
    }

    public void userStore1() {
        Log.e("TAG", "userStore1:....... ");
    }
}
