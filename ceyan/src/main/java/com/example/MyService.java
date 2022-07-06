package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final String hh = intent.getStringExtra("hh");
        new Thread(new Runnable() {
            @Override
            public void run() {
                downloadHttp(hh);
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }


    //    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        final String hh = intent.getStringExtra("hh");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                downloadHttp(hh);
//            }
//        }).start();
//
//        return super.onStartCommand(intent, flags, startId);
//    }

    private void downloadHttp(String hh) {
        try {
            String s = Environment.getExternalStorageDirectory() + File.separator + "qq.apk";

            URL url = new URL(hh);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int contentLength = urlConnection.getContentLength();

            FileOutputStream outputStream = new FileOutputStream(s);
            InputStream inputStream = urlConnection.getInputStream();

            byte[] bytes = new byte[1024];
            int count = 0;

            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {

                outputStream.write(bytes, 0, len);
                count += len;
                int progess = count * 100 / contentLength;
                Log.d("TAG", "downloadHttp: " + progess);
                EventBus.getDefault().postSticky((Integer) progess);
            }
            inputStream.close();
            outputStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}
