package com.example.guangbo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button btn1;
    private DongReceiver dongReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
//        DongReceiver dongReceiver = new DongReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("guangtouqiang");
//        registerReceiver(dongReceiver,intentFilter);
        DongReceiver dongReceiver = new DongReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("xionger");
        registerReceiver(dongReceiver,intentFilter);
        

//        DongReceiver dongReceiver = new DongReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("I am DynamicBroadcastReceiver");
//        registerReceiver(dongReceiver,intentFilter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
//                Intent intent = new Intent("com.example.test_broadcast");
//                intent.putExtra("key", "我是广播数据");
//                sendBroadcast(intent);
                Intent intent = new Intent("com.example.test_broadcast");
                intent.putExtra("key","我是静态广播数据");
                sendBroadcast(intent);

                break;
            case R.id.btn1:
                Intent intent1 = new Intent();
                intent1.setAction("xionger");
                intent1.putExtra("msg","我是动态广播");
                sendBroadcast(intent1);



                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dongReceiver);
    }
}
