package com.example.mvpshujuku.presenter;

import com.example.mvpshujuku.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
