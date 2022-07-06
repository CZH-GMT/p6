package com.example.mvpshujuku.Model;

import com.example.mvpshujuku.ApiService;
import com.example.mvpshujuku.Bean;
import com.example.mvpshujuku.SubBean;
import com.example.mvpshujuku.presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Foodmodel implements Imodel{
    @Override
    public void getFooddata(final ICallBack iCallBack) {

        Retrofit build = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        build.create(ApiService.class).getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
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

    @Override
    public void getFoodDB() {


    }

    @Override
    public void insertSubbeanDB(SubBean subBean) {

    }
}
