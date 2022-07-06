package com.example.mvp.model;

import com.example.mvp.presenter.ICallBack;

import java.util.Random;

public class Model implements IModel{

    @Override
    public void randomNum(ICallBack iCallBack) {
        Random random = new Random();
        int i = random.nextInt();
        if (i%2==0){

            iCallBack.success(i+"--成功了！偶数");
        }else {
            iCallBack.failed(i+"--失败了！奇数");
        }
    }
}
