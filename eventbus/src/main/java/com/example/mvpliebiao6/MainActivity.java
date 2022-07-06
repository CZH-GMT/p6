package com.example.mvpliebiao6;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //EventBus.getDefault().register(this);
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

       // EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(this);
    }
    public void getprogess(Integer i){


    }

    private static final String TAG = "MainActivity";
    private void initView() {
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEvent(Msgevent msgevent){
        Log.d(TAG, "getEvent: "+msgevent.getMes());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                Msgevent msgevent1 = new Msgevent();
                msgevent1.setMes("EventBus!");
                EventBus.getDefault().post(msgevent1);
                break;
        }
    }
}
