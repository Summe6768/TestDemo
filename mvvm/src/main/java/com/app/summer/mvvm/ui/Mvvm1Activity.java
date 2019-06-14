package com.app.summer.mvvm.ui;


import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import com.app.summer.mvvm.R;

import com.app.summer.mvvm.bean.User;
import com.app.summer.mvvm.databinding.ActivityMvvm1Binding;



public class Mvvm1Activity extends AppCompatActivity {

    public static final String TAG = "TAG";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm1);
        final ActivityMvvm1Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm1);

        final User user = new User();
        user.name.set("张三");

        binding.setUser(user);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    user.name.set("李四");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void mvvmOnClick(View view) {


//        Retrofit retrofit = new Retrofit.Builder()
//                //设置数据解析器
//                .addConverterFactory(GsonConverterFactory.create())
//                //设置网络请求的Url地址
//                .baseUrl("http://apis.baidu.com/")
//                .build();
//        // 创建网络请求接口的实例
//        APi mApi = retrofit.create(APi.class);
//
//        User user = new User();
//        user.setName("11");
//        user.setAge(11);
//
//        Gson gson = new Gson();
//        String str = gson.toJson(user);
//
//        Call<ResponseBody> call = mApi.getUser("这个是你要传的参数");
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.e("TAG", "onResponse :" + response);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("TAG", "onFailure :" + t);
//            }
//        });

    }

}
