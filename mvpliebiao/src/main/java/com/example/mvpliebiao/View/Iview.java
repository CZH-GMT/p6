package com.example.mvpliebiao.View;

import com.example.mvpliebiao.Bean;

import java.util.List;

public interface Iview {
    void updateSuccess(List<Bean.DataBean> list);
    void updateFailed(String error);
}
