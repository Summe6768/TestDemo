package com.app.summer.mvp.view;

import dagger.Module;

/**
 *
 */
@Module
public interface LoginView {

    void onLoginResult(String name,String psd);

    void onClick(String name, String psd);

}
