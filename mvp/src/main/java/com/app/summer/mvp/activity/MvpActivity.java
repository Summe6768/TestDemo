package com.app.summer.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.summer.mvp.R;
import com.app.summer.mvp.prsenter.LoginPresenter;
import com.app.summer.mvp.view.LoginView;

public class MvpActivity extends AppCompatActivity implements LoginView {

    private EditText edUserName;
    private EditText edPassWord;
    private String edUserNameStr;
    private String edPassWordStr;

    // 持有LoginPresenter的引用
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_activity);

        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);


        mLoginPresenter = new LoginPresenter(this);


    }

    public void onClickLogin(View view) {
        if (view.getId() == R.id.btnLogin) {
            edUserNameStr = edUserName.getText().toString();
            edPassWordStr = edPassWord.getText().toString();
            mLoginPresenter.btnOnClick(edUserNameStr, edPassWordStr);
        }
    }


    @Override
    public void onLoginResult(String name, String psd) {
        Log.e("TAG", "onLoginResult :" + name + "," + psd);
    }

    @Override
    public void onClick(String name, String psd) {
        if (!name.isEmpty() && !psd.isEmpty()) {
            mLoginPresenter.login(name, psd);
        } else {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
