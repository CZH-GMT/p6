package com.example;

import com.example.zhouce.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/28")
    Observable<Bean> getdata();

}
