package com.app.summer.mvp.presenter.view;

import com.app.summer.mvp.base.view.BaseView;

/**
 *
 */
public interface MvpView extends BaseView {
    void loginSucceed(String succeed);
    void loginFailure(String failure);
}
