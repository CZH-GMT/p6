package com.example.tqimotiku1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tl;
    private ViewPager vp;
    private Button btn;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServices.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiServices.class).getdata().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        strings = new ArrayList<>();
                        fragments = new ArrayList<>();

                        for (int i = 0; i <bean.getData().size() ; i++) {
                            Bean.DataBean dataBean = bean.getData().get(i);
                            fragments.add(RcyFragment.newInstance(dataBean.getId()+"",null));
                            strings.add(dataBean.getName());


                        }
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

                            @Nullable
                            @Override
                            public CharSequence getPageTitle(int position) {
                                return strings.get(position);
                            }
                        });
                        tl.setupWithViewPager(vp);



                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                break;
        }
    }
}
