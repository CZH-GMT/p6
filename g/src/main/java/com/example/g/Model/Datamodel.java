package com.example.g.Model;

import com.example.g.ApiService;
import com.example.g.Bean;
import com.example.g.Presenter.ICallback;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datamodel implements Imodel{
    @Override
    public void getdata(int page, final ICallback iCallback) {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        build.create(ApiService.class).getdata("android",page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iCallback.success(bean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallback.failed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
