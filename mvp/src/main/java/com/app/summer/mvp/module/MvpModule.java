package com.app.summer.mvp.module;

import com.app.summer.mvp.presenter.MvpPersenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class MvpModule {
    @Provides
    public MvpPersenterImpl mvpPersenterImplProvides(){
        return new MvpPersenterImpl();
    }
}
