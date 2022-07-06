package com.example.ceyan.Presenter;

import com.example.ceyan.Bean;
import com.example.ceyan.HomeFragment;
import com.example.ceyan.Model.DataModel;
import com.example.ceyan.View.Iview;

public class DataPresenter implements Ipresenter{
    private Iview iview;
    private final DataModel dataModel;

    public DataPresenter(Iview iview) {

        this.iview = iview;
        dataModel = new DataModel();
    }


    @Override
    public void getmath(String page) {
        dataModel.getdata(page, new ICallBack() {
            @Override
            public void success(Bean bean) {
            iview.updatasuccess(bean);
            }

            @Override
            public void failed(String error) {

            }
        });

    }
}
