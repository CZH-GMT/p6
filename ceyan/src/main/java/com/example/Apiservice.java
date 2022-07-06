package com.example;

import com.example.ceyan.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiservice {
//    String Url="https://www.wanandroid.com/";
//    @GET("project/list/1/json?")
//    Observable<Bean> getdata(@Query("cid")String page);
    String Url="https://www.wanandroid.com/";
    @GET("project/list/1/json?")
    Observable<Bean> getdata(@Query("cid")String page);
}
