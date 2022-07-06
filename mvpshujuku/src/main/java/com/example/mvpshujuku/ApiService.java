package com.example.mvpshujuku;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="http://www.qubaobei.com/";
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20page=1")
    Observable<Bean> getData();
}
