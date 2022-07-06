package com.example.tqimotiku1.Presenter;

import com.example.tqimotiku1.Beans;
import com.example.tqimotiku1.Model.DataModel;
import com.example.tqimotiku1.RcyFragment;
import com.example.tqimotiku1.View.Iview;

public class Datapresenter implements Ipresenter{
    private Iview iview;
    private final DataModel dataModel;

    public Datapresenter(Iview iview) {

        this.iview = iview;
        dataModel = new DataModel();

    }

    @Override
    public void getmath(String page) {
        dataModel.getdata(page, new ICallBack() {
            @Override
            public void success(Beans bean) {
                iview.updatasuccess(bean);
            }

            @Override
            public void failed(String error) {
                iview.updatafailed(error);

            }
        });

    }
}
