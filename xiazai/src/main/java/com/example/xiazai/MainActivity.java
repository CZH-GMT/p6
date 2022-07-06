package com.example.xiazai;

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
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private TextView reuslt;
    private Button btn2;
    private ProgressBar progress1;
    private ProgressBar progress;
    private TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        reuslt = (TextView) findViewById(R.id.reuslt);

        btn.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        progress1 = (ProgressBar) findViewById(R.id.progress);
        progress1.setOnClickListener(this);

       progress1.setMax(100);
        value = (TextView) findViewById(R.id.value);
        value.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                download();
                break;
            case R.id.btn2:
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        doenloadhttp();
                    }
                }).start();

                break;
        }
    }

    String url = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";


    private void doenloadhttp() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();


            //文件总大小
            int contentLength = urlConnection.getContentLength();
            if (contentLength < 0) {
                Log.d(TAG, "doenloadhttp: " + "长度为-1");
            }


            InputStream inputStream = urlConnection.getInputStream();
            String s = Environment.getExternalStorageDirectory() + "/11.apk";
            FileOutputStream outputStream = new FileOutputStream(new File(s));

            byte[] bytes = new byte[1024 * 4];

            int len = 0;
            //已经下载的长度
            int count = 0;
            while ((len = inputStream.read(bytes)) != -1) {


                count = count + len;
                final int progress = count * 100 / contentLength;
                progress1.setProgress(progress);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        value.setText(progress+"%");
                    }
                });
                Log.d(TAG, "doenloadhttp: " + progress + "%");
                Log.d(TAG, "doenloadhttp: " + len);
                outputStream.write(bytes, 0, len);

            }
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static final String TAG = "MainActivity";

    private void download() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(build)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: " + e.getMessage());
                    }


                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s = Environment.getExternalStorageDirectory() + "/xx.apk";
                        File file = new File(s);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileOutputStream outputStream = new FileOutputStream(file);
                        InputStream inputStream = response.body().byteStream();
                        byte[] bytes = new byte[1024 * 4];
                        int len = 0;
                        //输入流读取
                        while ((len = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, len);
                        }


                        inputStream.close();
                        outputStream.close();
                    }
                });


    }
}
