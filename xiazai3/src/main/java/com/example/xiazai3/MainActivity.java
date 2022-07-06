package com.example.xiazai3;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button btn2;
    private ProgressBar bar;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        bar = (ProgressBar) findViewById(R.id.bar);
        text = (TextView) findViewById(R.id.text);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                okhttp();
                break;
            case R.id.btn2:
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           http();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }).start();
                break;
        }
    }

    private void http() throws IOException {
        try {
            URL url = new URL(url1);
            URLConnection urlConnection = url.openConnection();
            int contentLength = urlConnection.getContentLength();

            InputStream inputStream = urlConnection.getInputStream();
            String s = Environment.getExternalStorageDirectory() + "/pp.apk";
            FileOutputStream outputStream = new FileOutputStream(new File(s));
            int len=0;
            int count=0;
            byte[] bytes = new byte[1024];
            while ((len=inputStream.read(bytes))!=-1){
                count+=len;
                final int i = count * 100 / contentLength;
                bar.setProgress(i);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(i+"%");
                    }
                });


                outputStream.write(bytes,0,len);

            }
            inputStream.close();
            outputStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    String url1 = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";
    private void okhttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request builder = new Request.Builder()
                .url(url1)
                .build();
        okHttpClient.newCall(builder)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = Environment.getExternalStorageDirectory() + "/gaungtouqiang.apk";
                        File file = new File(s);
                        if (!file.exists()){
                            file.createNewFile();
                        }
                        FileOutputStream outputStream = new FileOutputStream(file);
                        InputStream inputStream = response.body().byteStream();
                        int len=0;
                        byte[] bytes = new byte[1024];
                        while ((len=inputStream.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);

                        }
                        inputStream.close();
                        outputStream.close();
                    }

                });


    }
}
