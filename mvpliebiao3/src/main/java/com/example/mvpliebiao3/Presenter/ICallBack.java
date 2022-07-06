package com.example.mvpliebiao3.Presenter;

import com.example.mvpliebiao3.Bean;

import java.util.List;

public interface ICallBack {
    void success(List<Bean.DataBean> dataBeanslist);
    void failed(String error);
}
