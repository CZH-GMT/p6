package com.example.mvpwangluo.Api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String url="https://www.wanandroid.com/";
    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseBody> getdata(@Field("username")String name,@Field("password")String psw);

}
