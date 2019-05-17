package com.app.summer.testdemo.mvvm.component;

import com.app.summer.testdemo.mvvm.MvvmActivity;
import com.app.summer.testdemo.mvvm.module.LoginBeanModules;
import com.app.summer.testdemo.mvvm.module.UserBeanModules;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Singleton
@Component(modules = {UserBeanModules.class, LoginBeanModules.class})
public interface UserBeanComponent {
    void inject(MvvmActivity mvvmActivity);
}
