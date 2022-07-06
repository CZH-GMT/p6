package com.example.retrofitrecyclerview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
            String url="http://www.qubaobei.com/";
            @GET("ios/cf/dish_list.php?stage_id=1&limit=5")
    Call<Bean> getfoodData(@Query("page")String page);

}
