package com.example.retrofitshangchuan1.Presenter;

import com.example.retrofitshangchuan1.Bean;
import com.example.retrofitshangchuan1.Home_Fragment;
import com.example.retrofitshangchuan1.Model.Model;
import com.example.retrofitshangchuan1.View.Iview;

public class Presenter implements Ipresenter{
    private Iview iview;
    private final Model model;

    public Presenter(Iview iview) {


        this.iview = iview;
        model = new Model();
    }

    @Override
    public void getmath() {
        model.getdata(new ICallBack() {
            @Override
            public void success(Bean bean) {
                iview.updatasuccess(bean);
            }

            @Override
            public void failed(String error) {
                iview.updatafailed(error);

            }
        });

    }
}
