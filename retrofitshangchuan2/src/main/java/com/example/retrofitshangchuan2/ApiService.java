package com.example.retrofitshangchuan2;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String url="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<Bean> getdata();



    //    String url="https://www.liulongbin.top:8888/";
//    @Multipart
//    @POST("api/private/v1/upload")
//    Call<ResponseBody> getdata(@Header("authorization")String header, @Part MultipartBody.Part multibody);


    String upurl="https://www.liulongbin.top:8888/";
    @Multipart
    @POST("api/private/v1/upload")
    Observable<ResponseBody> getupdata(@Header("authorization")String header, @Part MultipartBody.Part multibody);

}
