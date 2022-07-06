package com.example.zhourizuoye;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String bannerurl="https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/10/3")
    Call<Bean> getdata();
}
