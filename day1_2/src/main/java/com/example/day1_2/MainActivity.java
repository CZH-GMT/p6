package com.example.day1_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private String url = "https://www.wanandroid.com/project/list/1/json?cid=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                OkHttpClient okHttpClient = new OkHttpClient();
                Request build = new Request.Builder()
                        .url(url)
                        .build();
                okHttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TAG", "onFailure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Log.d("TAG", "onResponse: ");



                    }
                });

                break;
            case R.id.btn2:
                OkHttpClient okHttpClient1 = new OkHttpClient();
                FormBody build1 = new FormBody.Builder()
                        .add("华哥","司令")
                        .add("华哥","111111111")
                        .add("华哥","111111111")
                        .build();
                Request build2 = new Request.Builder()
                        .url(url)
                        .post(build1)
                        .build();
                okHttpClient1.newCall(build2).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TAG", "onFailure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Log.d("TAG", "onResponse: ");

                    }
                });

                break;
        }
    }
}
