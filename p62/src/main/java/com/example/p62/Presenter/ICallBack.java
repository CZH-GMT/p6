package com.example.p62.Presenter;

import com.example.p62.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
