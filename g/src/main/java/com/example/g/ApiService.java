package com.example.g;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

public interface ApiService {
    String url="https://www.wanandroid.com/";
    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Observable<Bean> getdata(@Field ("k") String hh,@Path("page") int page);



    String bannerurl="https://www.wanandroid.com/";
    @GET("banner/json")
    Observable<BannerBean> getmath();
}
