package com.app.summer.testdemo.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.app.summer.testdemo.R;
import com.app.summer.testdemo.databinding.ActivityMvvmBinding;
import com.app.summer.testdemo.mvvm.bean.LoginBean;
import com.app.summer.testdemo.mvvm.bean.UserBean;
import com.app.summer.testdemo.mvvm.component.DaggerUserBeanComponent;
import com.app.summer.testdemo.mvvm.module.LoginBeanModules;
import com.app.summer.testdemo.mvvm.module.UserBeanModules;

import javax.inject.Inject;

public class MvvmActivity extends AppCompatActivity {

    ActivityMvvmBinding binding;


    @Inject
    UserBean userBean;
    @Inject
    LoginBean loginBean;

    @Inject
    LoginBean loginBean2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);

        DaggerUserBeanComponent
                .builder()
                .userBeanModules(new UserBeanModules("张三", 25))
                .loginBeanModules(new LoginBeanModules("ID", "密码"))
                .build()
                .inject(this);

        binding.setUserBean(userBean);

        Log.e("TAG", "onCreate: " + loginBean.getmId() + "   " + loginBean.getmPassword());

        Log.e("TAG", "onCreate: " + loginBean );
        Log.e("TAG", "onCreate: " + loginBean2 );

    }
}
