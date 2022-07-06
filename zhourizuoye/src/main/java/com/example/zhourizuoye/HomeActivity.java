package com.example.zhourizuoye;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tl;
    private ViewPager vp;
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
        banner = (Banner) findViewById(R.id.banner);

        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("华哥最帅");
        strings.add("司令牛逼");
        strings.add("华哥最帅");
        strings.add("司令牛逼");
        integers.add(R.drawable.a1);
        integers.add(R.drawable.a3);
        integers.add(R.drawable.a4);
        integers.add(R.drawable.b1);
        banner.setImages(integers).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(HomeActivity.this).load(path).into(imageView);

            }
        }).setBannerTitles(strings).isAutoPlay(true).setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE).start();

        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        //tl.setupWithViewPager(vp);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("学校新闻");
        tl.getTabAt(1).setText("班级成绩查询出");


    }
}
