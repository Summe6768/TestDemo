package com.app.summer.testdemo.Dagger2.Component.AppComponent;

import com.app.summer.testdemo.Dagger2.module.AppModule.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
}
