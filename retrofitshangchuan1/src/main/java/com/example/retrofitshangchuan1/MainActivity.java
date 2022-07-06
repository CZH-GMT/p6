package com.example.retrofitshangchuan1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private TabLayout tl;
    private FragmentManager supportFragmentManager;
    private Home_Fragment home_fragment;
    private Shangchuan_Fragment shangchuan_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        tl = (TabLayout) findViewById(R.id.tl);

        supportFragmentManager = getSupportFragmentManager();
        home_fragment = new Home_Fragment();
        shangchuan_fragment = new Shangchuan_Fragment();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl, home_fragment)
                .add(R.id.fl, shangchuan_fragment)
                .show(home_fragment)
                .hide(shangchuan_fragment)
                .commit();

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    supportFragmentManager.beginTransaction()

                            .show(home_fragment)
                            .hide(shangchuan_fragment)
                            .commit();

                }else {
                    supportFragmentManager.beginTransaction()

                            .show(shangchuan_fragment)
                            .hide(home_fragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tl.addTab(tl.newTab().setText("首页"));
        tl.addTab(tl.newTab().setText("上传"));

    }
}
