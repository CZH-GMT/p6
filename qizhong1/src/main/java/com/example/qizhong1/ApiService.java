package com.example.qizhong1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String url="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/10/28")
    Call<Bean> getdata();
}
