package com.app.summer.mvp.prsenter;

import com.app.summer.mvp.model.LoginModel;
import com.app.summer.mvp.view.LoginView;

/**
 *
 */
public class LoginPresenter {

    // 持有LoginView接口的引用
    private LoginView mLoginView;
    private LoginModel mLoginModel;

    // 传入LoginView
    public LoginPresenter() {

    }

    public void login(String name, String psd) {

        if (!name.isEmpty() && !psd.isEmpty()){
            //mLoginModel.qingqiu();
        }
    }


}
