package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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
                download(hh);
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);


    }

    private void download(String hh) {
        try {
            URLConnection urlConnection = new URL(hh).openConnection();
            int contentLength = urlConnection.getContentLength();
          //  String s = Environment.getExternalStorageDirectory() + File.separator + "hu.apk";
            String s = Environment.getExternalStorageDirectory() + File.separator + "hu.apk";
            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(s);
            byte[] bytes = new byte[1024];
            int len=0;
            int count=0;
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                count+=len;
                int i = count * 100 / contentLength;
                EventBus.getDefault().post((Integer)i);

            }
            inputStream.close();
            outputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
