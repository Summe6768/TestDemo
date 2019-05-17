package com.app.summer.testdemo.Dagger2.module;

import android.content.Context;

import com.app.summer.testdemo.Dagger2.object.ApiService;
import com.app.summer.testdemo.Dagger2.object.UserManager;
import com.app.summer.testdemo.Dagger2.object.UserStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author: Summer
 * @date: 2019/5/10
 */


@Module
public class UserModule {

    private Context mContext;
    private String mString;

    public UserModule(Context context, String string) {
        this.mContext = context;
        this.mString = string;
    }

    @Provides
    public ApiService providesApiServiceTest() {
        return new ApiService("测试版本");
    }

//    @Release
//    @Provides
//    public ApiService providesApiServiceRelease() {
//        return new ApiService("正确版本");
//    }

    @Provides
    public Context providesUrl() {
        return mContext;
    }

    @Provides
    public String providesUrlString() {
        return mString;
    }

    @Provides
    public UserManager providesUserManager(ApiService apiService, UserStore userStore) {
        return new UserManager(apiService, userStore);
    }

}
