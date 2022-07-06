package com.example.mvpliebiao5.presenter;

import com.example.mvpliebiao5.Bean;

public interface ICallBack {
    void successer(Bean bean);
    void failed(String error);
}
