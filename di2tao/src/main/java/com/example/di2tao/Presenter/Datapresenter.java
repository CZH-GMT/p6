package com.example.di2tao.Presenter;

import com.example.di2tao.Bean;
import com.example.di2tao.Home_Fragment;
import com.example.di2tao.Model.Datamodel;
import com.example.di2tao.View.Iview;

public class Datapresenter implements Ipresenter{
    private Iview iview;
    private final Datamodel datamodel;

    public Datapresenter(Iview iview) {

        this.iview = iview;
        datamodel = new Datamodel();
    }

    @Override
    public void getmath() {
        datamodel.getdata(new ICallBack() {
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
