package com.example.retrofitshangchuan2;

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
    private ShangchuanFragment shangchuanFragment;

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
        shangchuanFragment = new ShangchuanFragment();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl, home_fragment)
                .add(R.id.fl, shangchuanFragment)
                .show(home_fragment)
                .hide(shangchuanFragment)
                .commit();


        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    supportFragmentManager.beginTransaction()

                            .show(home_fragment)
                            .hide(shangchuanFragment)
                            .commit();

                }else {
                    supportFragmentManager.beginTransaction()

                            .show(shangchuanFragment)
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
        tl.addTab(tl.newTab().setText("??????"));
        tl.addTab(tl.newTab().setText("??????"));


    }
}
