package com.example.day2;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
                OkHttpClient okHttpClient = new OkHttpClient();
                Request build = new Request.Builder()
                        .url("http://c.m.163.com/nc/video/list/00850FRB/n/0-10.html")
                        .header("User-Agent", "Mozilla/5.0 (Linux; X11)")
                        .build();
                okHttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TAG", "onFailure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Log.d("TAG", "onResponse: "+string);
                    }
                });


                break;
            case R.id.btn2:
                String json="{\"page\":\"1\",\n" +
                        " \"count\":\"2\",\n" +
                        " \"type\":\"video\"\n" +
                        " }";
                RequestBody requestBody = RequestBody.create(MediaType.parse("text/json"), json);
                OkHttpClient okHttpClient1 = new OkHttpClient();
                Request build1 = new Request.Builder()
                        .post(requestBody)
                        .url("https://api.apiopen.top/getJoke")
                        .build();
                okHttpClient1.newCall(build1).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TAG", "onFailure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d("TAG", "onResponse: "+response.body().string());
                    }
                });


                break;
            case R.id.btn3:


                break;
        }
    }
}
