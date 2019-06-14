package com.app.summer.mvp.presenter;

import com.app.summer.mvp.base.BasePresenter;
import com.app.summer.mvp.presenter.view.MvpTestView;

/**
 *
 */
public class MvpTestPresenterImpl implements BasePresenter<MvpTestView> {
    private MvpTestView mvpTestView;

    @Override
    public void bindView(MvpTestView view) {
        this.mvpTestView = view;
    }

    @Override
    public void unlinkView() {
        mvpTestView = null;
    }

    public void downloadImg(int img){
        mvpTestView.downloadImg(img);
        mvpTestView.tost("传过来的的img");
    }
}
