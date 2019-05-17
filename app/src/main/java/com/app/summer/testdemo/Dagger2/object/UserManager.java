package com.app.summer.testdemo.Dagger2.object;

/**
 * @author: Summer
 * @date: 2019/5/13
 */
public class UserManager {

    private ApiService mApiService;
    private UserStore mUserStore;

    public UserManager(ApiService apiService, UserStore userStore) {
        this.mApiService = apiService;
        this.mUserStore = userStore;
    }

    public void userManagerLoge() {
        mApiService.apiService1();
        mUserStore.userStore1();
    }


}
