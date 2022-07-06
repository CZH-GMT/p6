package com.example.qizhong2;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private TabLayout tl;
    private LinearLayout ll;
    private DrawerLayout dl;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        tl = (TabLayout) findViewById(R.id.tl);
        ll = (LinearLayout) findViewById(R.id.ll);
        dl = (DrawerLayout) findViewById(R.id.dl);

        supportFragmentManager = getSupportFragmentManager();
        final Home_Fragment home_fragment = new Home_Fragment();
        final Me_Fragment me_fragment = new Me_Fragment();

        supportFragmentManager.beginTransaction()
                .add(R.id.fl,home_fragment)
                .add(R.id.fl,me_fragment)
                .show(home_fragment)
                .hide(me_fragment)
                .commit();

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    supportFragmentManager.beginTransaction().show(home_fragment).hide(me_fragment).commit();
                }else {
                    supportFragmentManager.beginTransaction().show(me_fragment).hide(home_fragment).commit();
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
        tl.addTab(tl.newTab().setText("我的"));


    }
}
