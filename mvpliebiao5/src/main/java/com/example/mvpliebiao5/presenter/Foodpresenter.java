package com.example.mvpliebiao5.presenter;

import com.example.mvpliebiao5.Bean;
import com.example.mvpliebiao5.MainActivity;
import com.example.mvpliebiao5.View.Iview;
import com.example.mvpliebiao5.model.Foodmodel;

public class Foodpresenter implements Ipresenter{
    private Iview iview;
    private final Foodmodel foodmodel;

    public Foodpresenter(Iview iview) {

        this.iview = iview;
        foodmodel = new Foodmodel();
    }

    @Override
    public void getFood() {
        foodmodel.getData(new ICallBack() {
            @Override
            public void successer(Bean bean) {
                iview.updatasuccess(bean);
            }

            @Override
            public void failed(String error) {
                iview.updatefailed(error);

            }
        });


    }
}
