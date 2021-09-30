package com.eup.mvp_demo;

import com.eup.mvp_demo.model.User;

public class LoginPricenter {
    private LoginInterface mLoginInterface;

    public LoginPricenter(LoginInterface mLoginInterface) {
        this.mLoginInterface = mLoginInterface;
    }

    public void login(User user){
        if (user.isValidEmail() && user.isValidPassword()){
            mLoginInterface.loginSuccess();
        } else {
            mLoginInterface.loginError();
        }
    }
}
