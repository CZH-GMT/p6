package com.example.jishi;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jishi.R;

import org.greenrobot.eventbus.EventBus;

public class WebActivity extends AppCompatActivity {

    private WebView web;
    long start,end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        start= System.currentTimeMillis();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        end= System.currentTimeMillis();

        int time=(int) (end-start)/1000;
        EventBus.getDefault().post(time);
    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);
        web.loadUrl("https://www.baidu.com/?tn=88093251_34_hao_pg");
        web.setWebViewClient(new WebViewClient());
       
    }
}
