package com.example.ceyan.Model;

import android.util.Log;

import com.example.Apiservice;
import com.example.ceyan.Bean;
import com.example.ceyan.Presenter.ICallBack;
import com.example.ceyan.SubBean;
import com.google.gson.Gson;

import java.util.List;

import freemarker.ext.beans.BeansWrapper;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;

public class DataModel implements Imodel {
    @Override
    public void getdata(String page, final ICallBack iCallBack) {

       new Retrofit.Builder()
               .baseUrl(Apiservice.Url)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build()
               .create(Apiservice.class)
               .getdata(page)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<Bean>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {

                   }

                   @Override
                   public void onNext(@NonNull Bean bean) {
                       int datas = bean.getData().getDatas().size();
                       iCallBack.success(bean);
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });

//        new Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(Apiservice.Url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(Apiservice.class)
//                .getdata(page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bean bean) {
//                        int size = bean.getData().getDatas().size();
//
//                        Log.d(TAG, "onNext: "+size);
//                        iCallBack.success(bean);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        iCallBack.failed(e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }
}
