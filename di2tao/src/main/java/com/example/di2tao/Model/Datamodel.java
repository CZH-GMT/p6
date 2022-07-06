package com.example.di2tao.Model;

import com.example.di2tao.ApiServies;
import com.example.di2tao.Bean;
import com.example.di2tao.Presenter.ICallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Datamodel implements Imodel{
    @Override
    public void getdata(final ICallBack iCallBack) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServies.url)
                .build();
        build.create(ApiServies.class)
                .getdata().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {

                iCallBack.success(response.body());

            }

            @Override
            public void onFailure(Call<Bean> call, Throwable throwable) {


            }
        });

    }
}
