package com.example.mvpliebiao2.presenter;

import com.example.mvpliebiao2.Bean;
import com.example.mvpliebiao2.View.Iview;
import com.example.mvpliebiao2.model.Foodmodel;

import java.util.List;

public class Foodpresenter implements Ipresenter{
    private Iview iview;
    private final Foodmodel foodmodel;

    public Foodpresenter(Iview iview) {
        this.iview = iview;
        foodmodel = new Foodmodel();
    }

    @Override
    public void getFood() {
        foodmodel.getFooddata(new ICallBack() {
            @Override
            public void success(List<Bean.DataBean> list) {
                iview.updatesuccess(list);

            }

            @Override
            public void failed(String error) {
                iview.updateFailed(error);

            }
        });

    }
}
