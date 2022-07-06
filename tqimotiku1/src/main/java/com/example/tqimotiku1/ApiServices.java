package com.example.tqimotiku1;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    String url = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Observable<Bean> getdata();


    String dataurl = "https://www.wanandroid.com/";
    @GET("project/list/1/json?")
    Observable<Beans> getmath(@Query("cid")String page);
}
