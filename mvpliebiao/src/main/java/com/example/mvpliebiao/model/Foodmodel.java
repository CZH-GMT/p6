package com.example.mvpliebiao.model;

import com.example.mvpliebiao.Api.ApiService;
import com.example.mvpliebiao.Bean;
import com.example.mvpliebiao.presenter.ICallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Foodmodel implements Imodel{
    @Override
    public void getFoodData(final ICallBack iCallBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iCallBack.success(bean.getData());



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
