package com.example.p62.Presenter;

import com.example.p62.Bean;
import com.example.p62.HomeFragment;
import com.example.p62.Model.Datamodel;
import com.example.p62.View.Iview;



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

            }
        });

    }
}
