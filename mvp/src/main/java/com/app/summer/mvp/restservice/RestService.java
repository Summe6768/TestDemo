package com.app.summer.mvp.restservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 *
 */
public interface RestService {
    @GET
    Call<String> getIP(@Url String url);
}
