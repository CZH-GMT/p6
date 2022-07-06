package com.example.okshangchuan2.Presenter;

import com.example.okshangchuan2.Bean;
import com.example.okshangchuan2.Home_Fragment;
import com.example.okshangchuan2.Model.Model;
import com.example.okshangchuan2.View.Iview;

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
