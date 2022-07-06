package com.example.qimoceshi.Model;

import com.example.qimoceshi.ApiService;
import com.example.qimoceshi.Bean;
import com.example.qimoceshi.Presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datamodel implements Imodel{
    @Override
    public void getdata(final ICallBack iCallBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.urldata)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class).getmath().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iCallBack.sucess(bean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallBack.failed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
