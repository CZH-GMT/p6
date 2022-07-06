package com.example.mvpliebiao3.api;

import com.example.mvpliebiao3.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String url="http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20")
    Observable<Bean> getdata(@Query("page")String page);
}
