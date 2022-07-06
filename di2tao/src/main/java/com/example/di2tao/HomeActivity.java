package com.example.di2tao;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout fl;
    private TabLayout tl;
    private LinearLayout ll;
    private NavigationView nv;
    private DrawerLayout dl;
    private Home_Fragment home_fragment;
    private Two_Fragment two_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fl = (FrameLayout) findViewById(R.id.fl);
        tl = (TabLayout) findViewById(R.id.tl);
        ll = (LinearLayout) findViewById(R.id.ll);
        nv = (NavigationView) findViewById(R.id.nv);
        dl = (DrawerLayout) findViewById(R.id.dl);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, toolbar, 0, 0);
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
     //   View headerView = nv.getHeaderView(0);
//        View iv = headerView.findViewById(R.id.iv);
//        final WebView web = headerView.findViewById(R.id.web);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                web.loadUrl("https://www.baidu.com/?tn=40020637_7_oem_dg");
//                web.setWebViewClient(new WebViewClient());
//            }
//        });
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                float v = nv.getLeft() * slideOffset;
                ll.setGravity((int)v);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        home_fragment = new Home_Fragment();

        two_fragment = new Two_Fragment();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl,home_fragment)
                .add(R.id.fl,two_fragment)
                .show(home_fragment)
                .hide(two_fragment)
                .commit();

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        if (position==0){
                            supportFragmentManager.beginTransaction()
                                    .show(home_fragment)
                                    .hide(two_fragment)
                                    .commit();
                        }else {
                            supportFragmentManager.beginTransaction()
                                    .show(two_fragment)
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
        tl.addTab(tl.newTab().setText("我的"));


    }
}
