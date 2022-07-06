package com.example.qizhongtiiku1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    private TextView tv;
    private Button btn;
    private int dao=5;
    private Handler mHandler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            String[] arr={"1","2","3","4","5"};
            tv.setText(arr[dao]);
            if (dao==0){
                //startActivity(new Intent(MainActivity.this,Home_Activity.class));
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
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);


        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        RotateAnimation rotateAnimation = new RotateAnimation(0,720);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,200);
        ScaleAnimation scaleAnimation = new ScaleAnimation(2, 1, 2, 1);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(1000);
        iv.startAnimation(animationSet);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (dao>0){
                    try {
                        Thread.sleep(100);
                        dao--;
                        mHandler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                startActivity(new Intent(MainActivity.this,Home_Activity.class));
                break;
        }
    }
}
