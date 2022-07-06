package com.example.retrofit4;

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

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                initRetroFit();
                break;
            case R.id.btn2:
                testPath();
                break;
            case R.id.btn3:
                testRegister();
                break;
        }
    }

    private void initRetroFit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.baseUrl)
                .build();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("limit","20");
        stringStringHashMap.put("page","1");
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> foodData = apiService.getFoodData(stringStringHashMap);
        foodData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
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
                .baseUrl(ApiService.registerUrl)
                .build();
        Call<ResponseBody> lisi = retrofit.create(ApiService.class).getreGist("lisi", "111", "111");
        lisi.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
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

    private void testRegister() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.wanUrl)
                .build();
        Call<ResponseBody> home = retrofit.create(ApiService.class).getHome("0");
        home.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
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
}
