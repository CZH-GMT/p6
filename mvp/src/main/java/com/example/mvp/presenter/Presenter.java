package com.example.mvp.presenter;

import android.util.Log;

import androidx.annotation.LongDef;

import com.example.mvp.model.Model;
import com.example.mvp.view.IView;

public class Presenter implements Ipresenter{

    private final Model model;
    private final IView iView;

    public Presenter(IView iView){
    this.iView=iView;
    model=new Model();
}

    private static final String TAG = "Presenter";
    @Override
    public void getmodelData() {
        model.randomNum(new ICallBack() {
            @Override
            public void success(String msg) {
                Log.d(TAG, "success: "+msg);
                iView.updateUISuccess(msg);
            }

            @Override
            public void failed(String error) {
                iView.updateUIFailed(error);
                Log.d(TAG, "failed: "+error);

            }
        });

    }
}
