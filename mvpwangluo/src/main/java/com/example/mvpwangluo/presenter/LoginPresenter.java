package com.example.mvpwangluo.presenter;

import com.example.mvpwangluo.MainActivity;
import com.example.mvpwangluo.model.Imodel;
import com.example.mvpwangluo.model.LoginModle;
import com.example.mvpwangluo.view.IView;

public class LoginPresenter implements Ipresenter {

    private IView iview;
    private final LoginModle loginModle;

    public LoginPresenter(IView iview) {

        this.iview = iview;
        loginModle = new LoginModle();
    }

    @Override
    public void getLoginData(String name,String psw) {
        loginModle.login(name,psw, new ICallback() {
            @Override
            public void success(String msg) {
                iview.loginSuccess(msg);
            }

            @Override
            public void failed(String error) {
                iview.loginFailed(error);

            }
        });
    }
}
