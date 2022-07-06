package com.example.okshangchuan1.Presenter;

import com.example.okshangchuan1.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);
}
