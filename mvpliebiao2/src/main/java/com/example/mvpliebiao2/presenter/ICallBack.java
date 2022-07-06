package com.example.mvpliebiao2.presenter;

import com.example.mvpliebiao2.Bean;

import java.util.List;

public interface ICallBack {
    void success(List<Bean.DataBean> list);
    void failed(String error);
}
