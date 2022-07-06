package com.example.retrofitshangchuan1;

import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shangchuan_Fragment extends Fragment implements View.OnClickListener {

    private FragmentActivity activity;
    private Button Btn;
    private ImageView Iamge;

    public Shangchuan_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shangchuan_, container, false);
        activity = getActivity();
        initView(inflate);


        return inflate;
    }

    private void initView(View inflate) {

        Btn = (Button) inflate.findViewById(R.id.btn);
        Btn.setOnClickListener(this);
        Iamge = (ImageView) inflate.findViewById(R.id.iamge);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/12/28
                reteofit();
                break;
            default:
                break;
        }
    }

    private static final String TAG = "Shangchuan_Fragment";
    private void reteofit() {
        String header="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE2MDkyNDMyMjIsImV4cCI6MTYwOTMyOTYyMn0.b8-ImvxX67ISXmtkIQeSXl-0IGZVv-QyLNlI6JVQ3ks";
        final String s = Environment.getExternalStorageDirectory() + "/Picture/a1.jpg";


        File file = new File(s);
        if (!file.exists()){
            Toast.makeText(activity, "文件不存在", Toast.LENGTH_SHORT).show();
        }
        final RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part multipartbody1 = MultipartBody.Part.createFormData("file", file.getName(), requestBody);



        new Retrofit.Builder()
                .baseUrl(ApiService.upurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getup(header,multipartbody1)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String string = response.body().string();
                            ImgeBean imgeBean = new Gson().fromJson(string, ImgeBean.class);
                            Glide.with(activity).load(imgeBean.getData().getUrl()).into(Iamge);
                            Log.d(TAG, "onResponse: "+string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                    }
                });
    }
}
