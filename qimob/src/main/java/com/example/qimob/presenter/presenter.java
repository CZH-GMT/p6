package com.example.qimob.presenter;

import com.example.qimob.Bean;
import com.example.qimob.HomeFragment;
import com.example.qimob.View.Iview;
import com.example.qimob.model.model;

public class presenter implements Ipresenter{
    private Iview iview;
    private com.example.qimob.model.model model;
    private final com.example.qimob.model.model model1;

    public presenter(Iview iview) {
        this.iview = iview;
        model1 = new model();

    }



    @Override
    public void get() {
        model1.getdata(new ICallBack() {
            @Override
            public void updatasuccess(Bean bean) {
                iview.updatasuccess(bean);
            }

            @Override
            public void updatafailed(String error) {
                iview.updatafailed(error+"");

            }
        });
    }

}
