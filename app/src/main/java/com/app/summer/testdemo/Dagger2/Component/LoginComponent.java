package com.app.summer.testdemo.Dagger2.Component;

import com.app.summer.testdemo.Dagger2.Component.AppComponent.AppComponent;
import com.app.summer.testdemo.Dagger2.activity.Dagger22Activity;
import com.app.summer.testdemo.Dagger2.ano.ActivityScope;
import com.app.summer.testdemo.Dagger2.module.UserModule;

import dagger.Component;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(Dagger22Activity dagger22Activity);
}
