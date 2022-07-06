package com.example.Presenter;

import com.example.Model.Datamodel;
import com.example.View.Iview;
import com.example.zhouce.Bean;
import com.example.zhouce.Home_Fragment;

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
                iview.Updatasuccess(bean);
            }

            @Override
            public void failed(String error) {
                iview.Updatafailed(error);

            }
        });

    }
}
