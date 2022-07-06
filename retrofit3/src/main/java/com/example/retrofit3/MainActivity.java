package com.example.retrofit3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                initRetrofit();
                break;
            case R.id.btn2:
                testPath();
                break;
            case R.id.btn3:
                testRegister();
            break;
            case R.id.btn4:

                break;
        }
    }

    private void testRegister() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.registerUrl)
                .build();

        Call<ResponseBody> lisi = retrofit.create(ApiService.class).register("lisi", "111", "111");
        lisi.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, "xxxx"+string, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Log.d("TAG", "onFailure: "+throwable.getMessage());
            }
        });
    }

    private void testPath() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.wanUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> homeData = apiService.getHomeData("0");
        homeData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, "xxxx"+string, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Log.d("TAG", "onFailure: "+throwable.getMessage());
            }
        });


    }


    private void initRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseurl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("limit","20");
        stringStringHashMap.put("page","1");
        Call<ResponseBody> foodData = apiService.getFoodData(stringStringHashMap);
        foodData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, "xxxx"+string, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Log.d("Tag","onFailure:"+ throwable.getMessage());
            }
        });

    }
}
