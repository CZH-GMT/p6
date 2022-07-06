package com.example.mvpliebiao4.model;

import com.example.mvpliebiao4.presenter.ICallBack;

public interface Imodel {
    void getFoodData(String page, ICallBack iCallBack);
}
