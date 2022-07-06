package com.example.mvpliebiao3.Model;

import com.example.mvpliebiao3.Bean;
import com.example.mvpliebiao3.Presenter.ICallBack;
import com.example.mvpliebiao3.api.ApiService;

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
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata(page)
                .subscribeOn(Schedulers.io())
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
