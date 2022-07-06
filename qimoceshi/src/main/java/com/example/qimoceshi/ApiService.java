package com.example.qimoceshi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    String urldata="https://gitee.com/";
    @GET("ccyy2019/server/raw/master/workbook_test1")
    Observable<Bean> getmath();
















    String url="https://www.wanandroid.com/";
    @FormUrlEncoded
    @POST("user/login?username=password")
    Call<RequestBody> getdata(@Field("111111")String name,@Field("111111")String password);
}
