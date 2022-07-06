package com.example.tqimotiku1;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Home_Activity extends AppCompatActivity {

    private WebView web;
    private String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        initView();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(sticky = true)
    public void getdata(Util util){
        link = util.getLink();
    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);



        //String hh = intent.getStringExtra("hh");
        web.loadUrl(link);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
