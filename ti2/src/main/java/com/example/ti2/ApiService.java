package com.example.ti2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String url=" https://www.wanandroid.com/";
    @GET("project/tree/json")
    Call<Bean> getData();



    String dataurl="https://www.wanandroid.com/";
    @GET("project/list/1/json?")
    Call<RcyBean> getitem(@Query("cid")String cid);
}
