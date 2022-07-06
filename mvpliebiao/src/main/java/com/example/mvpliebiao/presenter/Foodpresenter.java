package com.example.mvpliebiao.presenter;

import com.example.mvpliebiao.Bean;
import com.example.mvpliebiao.R;
import com.example.mvpliebiao.View.Iview;
import com.example.mvpliebiao.model.Foodmodel;

import java.util.List;

public class Foodpresenter implements Ipresenter{

    private Iview iview;
    private final Foodmodel foodmodel;

    public Foodpresenter(Iview iview) {

        this.iview = iview;
        foodmodel = new Foodmodel();
    }

    @Override
    public void getfood() {
        foodmodel.getFoodData(new ICallBack() {
            @Override
            public void success(List<Bean.DataBean> dataBeanList) {
                iview.updateSuccess(dataBeanList);
            }

            @Override
            public void failed(String error) {
                iview.updateFailed(error);

            }
        });

    }
}
