package com.example.okshangchuan3.Presenter;

import com.example.okshangchuan3.Bean;
import com.example.okshangchuan3.Home_Fragment;
import com.example.okshangchuan3.Model.Model;
import com.example.okshangchuan3.View.IView;

public class Presenter implements Ipresenter{
    private IView iView;
    private final Model model;

    public Presenter(IView iView) {

        this.iView = iView;
        model = new Model();

    }

    @Override
    public void getmath() {
        model.getdata(new ICallBack() {
            @Override
            public void success(Bean bean) {
                iView.updatasuccess(bean);
            }

            @Override
            public void failed(String error) {
                iView.updatafailed(error);

            }
        });

    }
}
