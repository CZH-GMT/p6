package com.example.day13zhishi;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String url="https://www.liulongbin.top:8888/";
    @Multipart
    @POST("api/private/v1/upload")
    Call<ResponseBody> getdata(@Header("authorization")String header, @Part MultipartBody.Part multibody);
}
