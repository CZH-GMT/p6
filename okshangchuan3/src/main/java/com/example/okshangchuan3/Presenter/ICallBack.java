package com.example.okshangchuan3.Presenter;

import com.example.okshangchuan3.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);

}
