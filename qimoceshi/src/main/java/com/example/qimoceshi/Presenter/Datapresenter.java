package com.example.qimoceshi.Presenter;

import com.example.qimoceshi.Bean;
import com.example.qimoceshi.Model.Datamodel;
import com.example.qimoceshi.Oneragment;
import com.example.qimoceshi.View.Iview;

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
            public void sucess(Bean bean) {
                iview.updatasucess(bean);
            }

            @Override
            public void failed(String error) {

                iview.updatafailed(error);
            }
        });

    }
}
