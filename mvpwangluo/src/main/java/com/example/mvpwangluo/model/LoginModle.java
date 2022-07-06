package com.example.mvpwangluo.model;

import android.util.Log;

import com.example.mvpwangluo.Api.ApiService;
import com.example.mvpwangluo.presenter.ICallback;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModle implements Imodel{
    private static final String TAG = "LoginModle";

    @Override
    public void login(String name, String psw, final ICallback iCallback) {

        Retrofit build = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata(name,psw)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.d(TAG, "onNext: "+string);
                            iCallback.success(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.d(TAG, "onError: "+throwable.getMessage());
                        iCallback.failed(throwable.getMessage());
//失败
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
