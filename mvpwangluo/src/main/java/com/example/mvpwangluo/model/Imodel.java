package com.example.mvpwangluo.model;

import com.example.mvpwangluo.presenter.ICallback;

public interface Imodel {

    void login(String name, String psw, ICallback iCallback);
}
