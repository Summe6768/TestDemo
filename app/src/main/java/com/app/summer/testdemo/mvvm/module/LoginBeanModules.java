package com.app.summer.testdemo.mvvm.module;

import com.app.summer.testdemo.mvvm.bean.LoginBean;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Module
public class LoginBeanModules {

    private String mId;
    private String mPassword;

    public LoginBeanModules(String id, String password) {
        this.mId = id;
        this.mPassword = password;
    }

    @Provides
    @Singleton
    public LoginBean providesLoginBean() {
        return new LoginBean(mId, mPassword);
    }
}
