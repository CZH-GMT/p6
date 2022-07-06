package com.example.di2tao.Presenter;

import com.example.di2tao.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
