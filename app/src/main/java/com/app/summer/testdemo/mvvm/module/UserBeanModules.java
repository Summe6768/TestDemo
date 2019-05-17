package com.app.summer.testdemo.mvvm.module;

import com.app.summer.testdemo.mvvm.bean.UserBean;

import dagger.Module;
import dagger.Provides;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Module
public class UserBeanModules {

    private String mName;
    private int mAge;

    public UserBeanModules(String name, int age) {
        this.mName = name;
        this.mAge = age;
    }

    @Provides
    public UserBean providesUserBean() {
        return new UserBean(mName, mAge);
    }
}
