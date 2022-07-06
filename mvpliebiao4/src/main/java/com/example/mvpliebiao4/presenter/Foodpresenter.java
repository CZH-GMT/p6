package com.example.mvpliebiao4.presenter;

import com.example.mvpliebiao4.Bean;
import com.example.mvpliebiao4.MainActivity;
import com.example.mvpliebiao4.model.Foodmodel;
import com.example.mvpliebiao4.view.Iview;

import java.util.List;

public class Foodpresenter implements Ipresenter{
    private Iview iview;
    private final Foodmodel foodmodel;

    public Foodpresenter(Iview iview) {

        this.iview = iview;
        foodmodel = new Foodmodel();

    }

    @Override
    public void getFood(String page) {
        foodmodel.getFoodData(page, new ICallBack() {
            @Override
            public void success(Bean bean) {
                iview.updatasuccess(bean.getData());
            }

            @Override
            public void failed(String error) {
                iview.updatafailed(error);

            }
        });

    }
}
