package com.example.shujukushoucang3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String url="https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/3")
    Call<Bean> getitem();
}
