package com.example.retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String baseUrl="http://www.qubaobei.com";
    @GET("/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Call<ResponseBody>   getFoodData();
}
