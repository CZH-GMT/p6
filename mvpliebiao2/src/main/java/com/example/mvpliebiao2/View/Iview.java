package com.example.mvpliebiao2.View;

import com.example.mvpliebiao2.Bean;

import java.util.List;

public interface Iview {
    void updatesuccess(List<Bean.DataBean> list);
    void updateFailed(String error);
}
