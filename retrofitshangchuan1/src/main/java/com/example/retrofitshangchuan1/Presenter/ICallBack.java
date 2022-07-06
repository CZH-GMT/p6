package com.example.retrofitshangchuan1.Presenter;

import com.example.retrofitshangchuan1.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
