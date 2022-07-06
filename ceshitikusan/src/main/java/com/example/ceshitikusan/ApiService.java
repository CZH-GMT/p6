package com.example.ceshitikusan;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/10/3")
    Observable<Bean> getdata();
}
