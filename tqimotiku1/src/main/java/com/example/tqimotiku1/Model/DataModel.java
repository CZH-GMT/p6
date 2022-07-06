package com.example.tqimotiku1.Model;

import com.example.tqimotiku1.ApiServices;
import com.example.tqimotiku1.Beans;
import com.example.tqimotiku1.Presenter.ICallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModel implements Imodel{
    @Override
    public void getdata(String page, final ICallBack iCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServices.dataurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        build.create(ApiServices.class)
                .getmath(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Beans beans) {
                        iCallBack.success(beans);

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
