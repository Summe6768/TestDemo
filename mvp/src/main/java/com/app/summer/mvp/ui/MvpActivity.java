package com.app.summer.mvp.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.summer.mvp.R;
import com.app.summer.mvp.component.DaggerMvpComponent;
import com.app.summer.mvp.module.MvpModule;
import com.app.summer.mvp.presenter.MvpPersenterImpl;
import com.app.summer.mvp.presenter.view.MvpView;

import javax.inject.Inject;



public class MvpActivity extends AppCompatActivity implements MvpView {
    private EditText edUserName;
    private EditText edPassWord;

    @Inject
    MvpPersenterImpl mvpPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);


        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);

        DaggerMvpComponent
                .builder()
                .mvpModule(new MvpModule())
                .build()
                .inject(this);

        mvpPersenter.bindView(MvpActivity.this);

        edPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            String strName = edUserName.getText().toString();
            String strPwd = edPassWord.getText().toString();
            mvpPersenter.login(strName, strPwd);
        }
    }


    @Override
    public void loginSucceed(String succeed) {
        tost(succeed);
        startActivity(new Intent(this,MvpTestActivity.class));
    }

    @Override
    public void loginFailure(String failure) {
        tost(failure);
    }

    @Override
    public void tost(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpPersenter.unlinkView();
    }


}
