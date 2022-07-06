package com.example.mvpliebiao4.view;

import com.example.mvpliebiao4.Bean;

import java.util.List;

public interface Iview {
    void updatasuccess(List<Bean.DataBean> list);
    void updatafailed(String error);

}
