package com.example.g;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    private Button btn;
    private TextView tv;
    private Disposable subscribe;
    private Disposable subscribe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        final int dao=5;
//        subscribe = Observable.interval(1, 1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        tv.setText(dao - aLong + "");
//                        if (aLong >= 5) {
//                            startActivity(new Intent(MainActivity.this, VPActivity.class));
//                            subscribe.dispose();
//                            finish();
//                        }
//                    }
//                });

//        subscribe1 = Observable.interval(1, 1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        tv.setText(dao - aLong + "");
//                        if (aLong >= 5) {
//                            startActivity(new Intent(MainActivity.this, VPActivity.class));
//                            subscribe1.dispose();
//                            finish();
//                        }
//                    }
//                });
       subscribe1 = Observable.interval(1, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        tv.setText(dao - aLong + "");
                        if (aLong >= 5) {
                            startActivity(new Intent(MainActivity.this, VPActivity.class));
                            subscribe1.dispose();
                            finish();
                        }
                    }
                });
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(2,1,2,1);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,200);
        RotateAnimation rotateAnimation = new RotateAnimation(0,20000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setDuration(1000);
        iv.startAnimation(animationSet);


        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                startActivity(new Intent(MainActivity.this,VPActivity.class));
                subscribe1.dispose();
                finish();
                break;
        }
    }
}
