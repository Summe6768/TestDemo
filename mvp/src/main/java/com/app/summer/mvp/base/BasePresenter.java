package com.app.summer.mvp.base;

/**
 *
 */
public interface BasePresenter<T> {
    void bindView(T view);

    void unlinkView();
}
