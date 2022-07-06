package com.example.g;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class VPActivity extends AppCompatActivity {

    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        boolean user = sharedPreferences.getBoolean("user", false);
        if (user){
            startActivity(new Intent(VPActivity.this,HomeActivity.class));

        }else {

        }
        sharedPreferences.edit().putBoolean("user",true).commit();

        setContentView(R.layout.activity_v_p);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        ArrayList<View> list = new ArrayList<>();
        View inflate = LayoutInflater.from(this).inflate(R.layout.itemone, null);
        View inflate1 = LayoutInflater.from(this).inflate(R.layout.itemtwo, null);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.itemthree, null);
        View inflate3 = LayoutInflater.from(this).inflate(R.layout.itemfour, null);
        inflate3.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VPActivity.this,HomeActivity.class));
            }
        });
        list.add(inflate);
        list.add(inflate1);
        list.add(inflate2);
        list.add(inflate3);


        VpAdapter vpAdapter = new VpAdapter();
        vpAdapter.list=list;
        vp.setAdapter(vpAdapter);


    }
}
