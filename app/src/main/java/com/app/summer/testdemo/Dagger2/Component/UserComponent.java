package com.app.summer.testdemo.Dagger2.Component;

import com.app.summer.testdemo.Dagger2.Component.AppComponent.AppComponent;
import com.app.summer.testdemo.Dagger2.activity.Dagger2Activity;
import com.app.summer.testdemo.Dagger2.ano.ActivityScope;
import com.app.summer.testdemo.Dagger2.module.UserModule;

import dagger.Component;


@ActivityScope
@Component(modules = {UserModule.class}, dependencies = {AppComponent.class})
public interface UserComponent {
    void inject(Dagger2Activity dagger2Activity);
}
