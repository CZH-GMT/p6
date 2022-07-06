package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String url = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";
    private Button btn;
    private ProgressBar progess;
    private TextView text;
    private long start;
    private long end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getprogess(Integer i) {
        progess.setProgress(i);
        end = System.currentTimeMillis();
        int s = (int) (end - start)/1000;
        text.setText(s+"s");


    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        progess = (ProgressBar) findViewById(R.id.progess);
        text = (TextView) findViewById(R.id.text);
        progess.setMax(100);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.putExtra("hh", url);

                startService(intent);
                start = System.currentTimeMillis();

                break;
        }
    }
}
