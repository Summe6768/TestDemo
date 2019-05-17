package com.app.summer.testdemo.mvvm.bean;

/**
 * @author: Summer
 * @date: 2019/5/14
 */
public class LoginBean {

    private String mId;
    private String mPassword;

    public LoginBean(String id, String password) {
        this.mId = id;
        this.mPassword = password;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

}
