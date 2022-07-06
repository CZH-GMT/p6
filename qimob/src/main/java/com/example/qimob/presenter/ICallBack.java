package com.example.qimob.presenter;

import com.example.qimob.Bean;

public interface ICallBack {
    void updatasuccess(Bean bean);
    void updatafailed(String error);
}
