package com.example.mvpliebiao5.model;

import com.example.mvpliebiao5.Api.ApiService;
import com.example.mvpliebiao5.Bean;
import com.example.mvpliebiao5.presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Foodmodel implements Imodel{
    @Override
    public void getData(final ICallBack iCallBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iCallBack.successer(bean);

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
