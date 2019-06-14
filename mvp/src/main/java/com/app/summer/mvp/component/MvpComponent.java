package com.app.summer.mvp.component;

import com.app.summer.mvp.module.MvpModule;
import com.app.summer.mvp.ui.MvpActivity;

import dagger.Component;

/**
 *
 */
@Component(modules = MvpModule.class)
public interface MvpComponent {
    void inject(MvpActivity mvpActivity);
}
