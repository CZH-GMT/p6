package com.example.tqimotiku1.Presenter;

import com.example.tqimotiku1.Bean;
import com.example.tqimotiku1.Beans;

public interface ICallBack {
    void success(Beans bean);
    void failed(String error);
}
