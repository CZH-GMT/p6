package com.example.okshangchuan3.Model;

import com.example.okshangchuan3.ApiService;
import com.example.okshangchuan3.Bean;
import com.example.okshangchuan3.Presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements Imodel{
    @Override
    public void getdata(final ICallBack iCallBack) {

        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getdata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iCallBack.success(bean);

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
