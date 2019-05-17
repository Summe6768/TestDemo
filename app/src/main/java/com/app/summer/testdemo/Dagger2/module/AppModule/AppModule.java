package com.app.summer.testdemo.Dagger2.module.AppModule;

import com.app.summer.testdemo.Dagger2.object.QuanjuLei;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    public QuanjuLei providesApiService(){
        return new QuanjuLei();
    }
}
