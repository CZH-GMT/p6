package com.example.mvpliebiao.presenter;

import com.example.mvpliebiao.Bean;

import java.util.List;

public interface ICallBack {
    void success(List<Bean.DataBean> dataBeanList);
    void failed(String error);
}
