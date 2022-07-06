package com.example.xiazai1;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private ProgressBar progress1;
    private TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        progress1 = (ProgressBar) findViewById(R.id.progress);
        value = (TextView) findViewById(R.id.value);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        progress1.setMax(100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                downlodeok();
                break;
            case R.id.btn2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        downhttp();
                    }
                }).start();

                break;
        }
    }


  String url1 = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";


    private void downhttp() {

        try {
            URL url = new URL(url1);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int contentLength = urlConnection.getContentLength();
            if (contentLength < 0) {
                Log.d(TAG, "doenloadhttp: " + "长度为-1");
            }
            InputStream inputStream = urlConnection.getInputStream();
            String s = Environment.getExternalStorageDirectory() + "/kk.apk";

            FileOutputStream outputStream = new FileOutputStream(new File(s));
            byte[] bytes = new byte[1024];
            int len=0;
            int count=0;
            while ((len=inputStream.read(bytes))!=-1){
                count=count+len;
                final int pregress=count*100/contentLength;

                progress1.setProgress(pregress);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        value.setText(pregress+"%");
                    }
                });
                outputStream.write(bytes,0,len);

            }
            inputStream.close();
            outputStream.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static final String TAG = "MainActivity";

    private void downlodeok() {
        OkHttpClient okHttpClient = new OkHttpClient();


        Request build = new Request.Builder()
                .url(url1)
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = Environment.getExternalStorageDirectory() + "/dd.apk";
                File file = new File(s);
                if (!file.exists()){
                    file.createNewFile();

                }
                FileOutputStream outputStream = new FileOutputStream(file);



                InputStream inputStream = response.body().byteStream();
                byte[] bytes = new byte[1024];
                int len=0;
                while ((len=inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);

                }
                inputStream.close();
                outputStream.close();


            }
        });


    }
}
