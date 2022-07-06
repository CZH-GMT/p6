package com.example.mvpliebiao3.Presenter;

import com.example.mvpliebiao3.Bean;
import com.example.mvpliebiao3.Model.Foodmodel;
import com.example.mvpliebiao3.R;
import com.example.mvpliebiao3.View.Iview;

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
           public void success(List<Bean.DataBean> dataBeanslist) {
               iview.updatesuccess(dataBeanslist);
           }

           @Override
           public void failed(String error) {
               iview.updatefailed(error);

           }
       });


    }
}
