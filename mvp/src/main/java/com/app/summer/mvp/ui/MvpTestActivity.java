package com.app.summer.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.summer.mvp.R;
import com.app.summer.mvp.presenter.MvpTestPresenterImpl;
import com.app.summer.mvp.presenter.view.MvpTestView;

public class MvpTestActivity extends AppCompatActivity implements MvpTestView {

    MvpTestPresenterImpl mvpTestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_test);

        mvpTestPresenter = new MvpTestPresenterImpl();
        mvpTestPresenter.bindView(this);
        mvpTestPresenter.downloadImg(1111);
    }

    @Override
    public void downloadImg(int img) {
        Log.e("TAG", "downloadImg: " + img );
    }

    @Override
    public void tost(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpTestPresenter.unlinkView();
    }
}
