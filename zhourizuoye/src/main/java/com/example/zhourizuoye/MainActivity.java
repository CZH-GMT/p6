package com.example.zhourizuoye;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int dao=4;
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            String[] arr={"一","二","三","四"};
            tv.setText(arr[dao]);
            if (dao==0){
                startActivity(new Intent(MainActivity.this,DengLuActivity.class));
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (dao>0){
                    try {
                        Thread.sleep(1000);
                        dao--;
                        mHandler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}
