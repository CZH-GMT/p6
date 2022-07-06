package com.example.mvpshujuku.Model;

import com.example.mvpshujuku.SubBean;
import com.example.mvpshujuku.presenter.ICallBack;

public interface Imodel {
    void getFooddata(ICallBack iCallBack);



    void getFoodDB();
    //插入数据库
    void insertDB(SubBean subBean);

}
