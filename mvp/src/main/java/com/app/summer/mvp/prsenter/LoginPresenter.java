package com.app.summer.mvp.prsenter;

import com.app.summer.mvp.view.LoginView;

import java.lang.ref.WeakReference;

/**
 *
 */
public class LoginPresenter {

    // 持有LoginView接口的引用
    private LoginView mLoginView;



    // 传入LoginView
    public LoginPresenter(LoginView loginView) {
        this.mLoginView = loginView;

    }

    /**
     * 登录按钮点击事件
     * @param name
     * @param psd
     */
    public void btnOnClick(String name, String psd) {

        mLoginView.onClick(name, psd);
    }

    /**
     * 登录后返回的输入内容
     * @param name
     * @param psd
     */
    public void login(String name, String psd) {

        mLoginView.onLoginResult(name, psd);
    }





}
