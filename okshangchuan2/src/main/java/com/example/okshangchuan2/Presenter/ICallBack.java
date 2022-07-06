package com.example.okshangchuan2.Presenter;

import com.example.okshangchuan2.Bean;

public interface ICallBack {

    void success(Bean bean);
    void failed(String error);

}
