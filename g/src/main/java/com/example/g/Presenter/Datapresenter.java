package com.example.g.Presenter;

import com.example.g.Bean;
import com.example.g.Model.Datamodel;
import com.example.g.OneFragment;
import com.example.g.View.Iview;

public class Datapresenter implements Ipresenter {
    private Iview iview;
    private final Datamodel datamodel;

    public Datapresenter(Iview iview) {

        this.iview = iview;
        datamodel = new Datamodel();

    }

    @Override
    public void getmath(int page) {
        datamodel.getdata(page, new ICallback() {
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
