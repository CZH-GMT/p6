package com.example.retrofitshangchuan2.Presenter;

import com.example.retrofitshangchuan2.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
