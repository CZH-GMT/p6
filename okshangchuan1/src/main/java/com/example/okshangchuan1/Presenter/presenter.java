package com.example.okshangchuan1.Presenter;

import com.example.okshangchuan1.Bean;
import com.example.okshangchuan1.Home_Fragment;
import com.example.okshangchuan1.Model.model;
import com.example.okshangchuan1.View.Iview;

public class presenter implements Ipresenter{
    private Iview iview;
    private final com.example.okshangchuan1.Model.model model;

    public presenter(Iview iview) {

        this.iview = iview;
        model = new model();
    }

    @Override
    public void XaingMu() {
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
