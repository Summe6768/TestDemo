package com.app.summer.mvvm.bean;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 *
 */
public class User {


    public ObservableField<String> name = new ObservableField<>();

    public void onClickName(View view){
        Log.e("TAG", "onClickName :" + name.get());
    }

}
