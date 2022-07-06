package com.example.qizhongtiiku1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {

    private Toolbar toolbar;

    private TabLayout tl;
    private LinearLayout ll;
    private NavigationView nv;
    private DrawerLayout dl;
    private ViewPager vp;
    private FrameLayout fl;
    private FragmentManager supportFragmentManager;
    private Home_Fragment home_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        tl = (TabLayout) findViewById(R.id.tl);
        ll = (LinearLayout) findViewById(R.id.ll);
        nv = (NavigationView) findViewById(R.id.nv);
        dl = (DrawerLayout) findViewById(R.id.dl);
        fl = (FrameLayout) findViewById(R.id.fl);
        home_fragment = new Home_Fragment();
        final Me_Fragment me_fragment = new Me_Fragment();

        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl, home_fragment)
                .add(R.id.fl,me_fragment)
                .commit();
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position==0){
                    supportFragmentManager.beginTransaction()
                            .show(home_fragment)
                            .hide(me_fragment)
                            .commit();

                }else {
                    supportFragmentManager.beginTransaction()
                            .show(me_fragment)
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

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, toolbar, 0, 0);
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();





       tl.addTab(tl.newTab().setText("首页"));
       tl.addTab(tl.newTab().setText("列表"));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "网格");
        menu.add(0, 1, 0, "列表");
        //menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                RecyclerView recyclerView1 = home_fragment.getRecyclerView();

                recyclerView1.setLayoutManager(new GridLayoutManager(this, 2));


                break;
            case 1:
                RecyclerView recyclerView = home_fragment.getRecyclerView();
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
