package com.example.retrofit5;

import java.util.HashMap;

import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

    String baseUrl="http://www.qubaobei.com";
    @GET("/ios/cf/dish_list.php?stage_id=1")
    Call<ResponseBody> getFoodData(@QueryMap HashMap<String,String>  hashMap);



    String wanUrl= "https://www.wanandroid.com/";
    @GET("article/list/{page}/json")
    Call<ResponseBody> getHome(@Path("page")String page);


    String registerUrl=" https://www.wanandroid.com/";
    @FormUrlEncoded
    @POST("user/register")
    Call<ResponseBody> rigister(@Field("username")String name,@Field("password")String psw,@Field("repassword")String rpsw);


}
