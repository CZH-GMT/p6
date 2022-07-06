package com.example.qimoceshi.Presenter;

import com.example.qimoceshi.Bean;

public interface ICallBack {
    void sucess(Bean bean);
    void failed(String error);
}
