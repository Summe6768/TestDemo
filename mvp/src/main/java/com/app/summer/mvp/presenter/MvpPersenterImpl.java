package com.app.summer.mvp.presenter;

import android.widget.Toast;

import com.app.summer.mvp.base.BasePresenter;
import com.app.summer.mvp.presenter.view.MvpView;

/**
 *
 */
public class MvpPersenterImpl implements BasePresenter<MvpView> {

    private MvpView mvpView;

    @Override
    public void bindView(MvpView view) {
        this.mvpView = view;
    }

    @Override
    public void unlinkView() {
        mvpView = null;
    }

    public void login(String name, String pwd) {
        if (!name.isEmpty() && !pwd.isEmpty()) {
            if (name.equals("zhangsan") && pwd.equals("123456")) {
                mvpView.loginSucceed("登录成功");
            } else {
                mvpView.loginFailure("登录失败");
            }
        } else {
            mvpView.tost("用户名密码不能为空");
        }
    }

}
