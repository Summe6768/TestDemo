package com.app.summer.mvvm.ui;


import com.app.summer.mvvm.bean.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 *
 */
public interface APi {
    @GET("/canshu")
    Call<ResponseBody> getUser(@Url String url);
}
