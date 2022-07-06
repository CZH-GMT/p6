package com.example.mvpliebiao4.presenter;

import com.example.mvpliebiao4.Bean;

import java.util.List;

public interface ICallBack{
    void success(Bean bean);
    void failed(String error);
}
