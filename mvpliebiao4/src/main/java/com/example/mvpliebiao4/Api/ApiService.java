package com.example.mvpliebiao4.Api;

import com.example.mvpliebiao4.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String url="http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20page=1")
    Observable<Bean> getdata(@Query("page")String page);


}
