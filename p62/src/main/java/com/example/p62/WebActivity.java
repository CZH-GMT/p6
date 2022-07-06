package com.example.p62;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        web = (WebView) findViewById(R.id.web);
        Intent intent = getIntent();
        String hh = intent.getStringExtra("hh");
        web.loadUrl(hh);
        web.setWebViewClient(new WebViewClient());
    }
}
