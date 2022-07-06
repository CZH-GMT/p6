package com.example.Presenter;

import com.example.zhouce.Bean;

public interface ICallBack {
    void success(Bean bean);
    void failed(String error);

}
