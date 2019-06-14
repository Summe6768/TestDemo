package com.app.summer.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.summer.mvp.base.BasePresenter;
import com.app.summer.mvp.presenter.view.MvpView;

/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());


    }

    public abstract int getLayout();

}
