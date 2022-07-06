package com.example.mvpliebiao4.model;

import com.example.mvpliebiao4.Api.ApiService;
import com.example.mvpliebiao4.Bean;
import com.example.mvpliebiao4.presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Foodmodel implements Imodel{
    @Override
    public void getFoodData(String page, final ICallBack iCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.url)
                .build();
        build.create(ApiService.class).getdata(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Bean bean) {

                        iCallBack.success(bean);

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        iCallBack.failed(throwable.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
