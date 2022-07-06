package com.example.qizhongtiku2;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;
    private FrameLayout fl;
    private FragmentManager supportFragmentManager;
    private Home_Fragment home_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        tl = (TabLayout) findViewById(R.id.tl);


        fl = (FrameLayout) findViewById(R.id.fl);
       // final ArrayList<Fragment> fragments = new ArrayList<>();
        home_fragment = new Home_Fragment();
        final Web_Fragment web_fragment = new Web_Fragment();
        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl, home_fragment)
                .add(R.id.fl,web_fragment)
                .show(home_fragment)
                .hide(web_fragment)
                .commit();
        tl.addTab(tl.newTab().setText("首页"));
        tl.addTab(tl.newTab().setText("列表"));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    supportFragmentManager.beginTransaction()
                            .show(home_fragment)
                            .hide(web_fragment)
                            .commit();
                }else {
                    supportFragmentManager.beginTransaction()
                            .show(web_fragment)
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


    }
}
