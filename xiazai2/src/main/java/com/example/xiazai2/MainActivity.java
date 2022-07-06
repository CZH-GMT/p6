package com.example.xiazai2;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        bar = (ProgressBar) findViewById(R.id.bar);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        bar.setMax(100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                initOk();
                break;
            case R.id.btn2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            initHttp();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
        }
    }
    String url1 = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";
    private void initHttp() throws IOException {
        try {
            URL url = new URL(url1);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int contentLength = urlConnection.getContentLength();

            InputStream inputStream = urlConnection.getInputStream();
            String s = Environment.getExternalStorageDirectory() + "/yy.apk";
            FileOutputStream outputStream = new FileOutputStream(new File(s));

            byte[] bytes = new byte[1024];
            int len=0;
            int count=0;
            while ((len=inputStream.read(bytes))!=-1){
                count=count+len;
                int progress=count*100/contentLength;
                bar.setProgress(progress);

                outputStream.write(bytes,0,len);
            }
            inputStream.close();
            outputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }



    private void initOk() {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request build = new Request.Builder()
                .url(url1)
                .build();
        okHttpClient.newCall(build)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("TAG", "onFailure: "+e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = Environment.getExternalStorageDirectory() + "/huage.apk";
                        File file = new File(s);
                        if (!file.exists()) {
                            file.createNewFile();

                        }


                        FileOutputStream outputStream = new FileOutputStream(file);
                        InputStream inputStream = response.body().byteStream();
                        byte[] bytes = new byte[1024*4];
                        int len = 0;
                        while ((len = inputStream.read()) != -1) {
                            outputStream.write(bytes, 0, len);


                        }
                        outputStream.close();
                        inputStream.close();



                    }
                });


    }
}
