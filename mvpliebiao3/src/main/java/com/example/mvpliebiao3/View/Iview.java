package com.example.mvpliebiao3.View;

import com.example.mvpliebiao3.Bean;

import java.util.List;

public interface Iview {
    void updatesuccess(List<Bean.DataBean> list);
    void updatefailed(String error);

}
