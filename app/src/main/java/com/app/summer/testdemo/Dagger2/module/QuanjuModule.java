package com.app.summer.testdemo.Dagger2.module;

import com.app.summer.testdemo.Dagger2.object.QuanjuLei;

import dagger.Module;
import dagger.Provides;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
@Module
public class QuanjuModule {

    @Provides
    public QuanjuLei quanju() {
        return new QuanjuLei();
    }
}
