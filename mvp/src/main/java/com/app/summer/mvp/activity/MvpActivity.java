package com.app.summer.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.app.summer.mvp.R;
import com.app.summer.mvp.prsenter.LoginPresenter;
import com.app.summer.mvp.view.LoginView;

public class MvpActivity extends AppCompatActivity  implements LoginView {

    private EditText edUserName;
    private EditText edPassWord;

    // 持有LoginPresenter的引用
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_activity);

        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);

        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.login("name","123456");

    }



    @Override
    public void onLoginResult(final String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }
}
