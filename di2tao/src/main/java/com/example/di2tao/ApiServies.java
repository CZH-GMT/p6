package com.example.di2tao;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServies {
    String url = "https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/28")
    Call<Bean> getdata();
}
