package com.example.mvpshujuku.presenter;

import com.example.mvpshujuku.Bean;
import com.example.mvpshujuku.MainActivity;
import com.example.mvpshujuku.Model.Foodmodel;
import com.example.mvpshujuku.SubBean;
import com.example.mvpshujuku.View.Iview;

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
            public void success(Bean bean) {
                iview.updatasucess(bean);
            }

            @Override
            public void failed(String error) {
                iview.updataFailed(error);

            }
        });

    }

    @Override
    public void getFoodbyDB() {

    }

    @Override
    public void insert(SubBean subBean) {
        foodmodel.getFoodDB(subBean);
    }


}
