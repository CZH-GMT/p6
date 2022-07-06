package com.example.qimob.model;

import com.example.qimob.Api.ApiService;
import com.example.qimob.Bean;
import com.example.qimob.presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class model  implements Imodel{
    @Override
    public void getdata(final ICallBack iCallBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)

                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        build.create(ApiService.class).getdata().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                    iCallBack.updatasuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallBack.updatafailed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
