package com.app.summer.testdemo.Dagger2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.app.summer.testdemo.Dagger2.Component.DaggerUserComponent;
import com.app.summer.testdemo.Dagger2.module.UserModule;
import com.app.summer.testdemo.Dagger2.myApplication.MyApplication;
import com.app.summer.testdemo.Dagger2.object.UserManager;
import com.app.summer.testdemo.R;

import javax.inject.Inject;


public class Dagger2Activity extends AppCompatActivity {

//    private UserManager userManager;

//    @Test
//    @Inject
//    ApiService apiServiceTest;
//
//    @Release
//    @Inject
//    ApiService apiServiceRelease;
//
//    private boolean is = true;

//
//    UserManager userManager;
//
//    @Inject
//    QuanjuLei quanjuLei;

//    @Inject
//    ApiService apiService;
//
//    @Inject
//    ApiService apiService2;

    @Inject
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);

//        userManager = new UserManager(new ApiService(), new UserStore(this));
//        userManager.userManagerLoge();

//        DaggerUserComponent
//                .builder()
//                .userModule(new UserModule())
//                .build()
//                .inject(this);
//
//        apiService.apiService1();


//        DaggerUserComponent
//                .builder()
//                .userModule(new UserModule(this, ""))
//                .quanjuModule(new QuanjuModule())
//                .build()
//                .inject(this);
//
//        userManager.userManagerLoge();
//
//        quanjuLei.quanjufangfa();

//        DaggerUserComponent
//                .builder()
//                .userModule(new UserModule(this, "11"))
//                .build()
//                .inject(this);
//
//
//        apiServiceTest.apiService1();
//
//        apiServiceRelease.apiService1();

//        /**
//         * 单例
//         */
//        DaggerUserComponent.builder()
//                .userModule(new UserModule(this,"daad"))
//                .build()
//                .inject(this);
//
//        Log.e("TAG", "onCreate111: " + apiService );
//        Log.e("TAG", "onCreate222: " + apiService2 );


        DaggerUserComponent
                .builder()
                .userModule(new UserModule(this,""))
                .appComponent(((MyApplication)getApplication()).getAppComponent())
                .build()
                .inject(this);



        userManager.userManagerLoge();




    }

    public void btnOnClick(View view) {
        startActivity(new Intent(this,Dagger22Activity.class));
    }
}
