package com.example.p62;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getdata();
}
