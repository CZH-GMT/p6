package com.example.ti2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private FragmentActivity activity;
    private TabLayout tl1;
    private ViewPager vp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(View inflate) {
        tl1=inflate.findViewById(R.id.tl1);
        vp=inflate.findViewById(R.id.vp);



    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getData().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                List<Bean.DataBean> data = response.body().getData();
                fragments = new ArrayList<>();
                strings = new ArrayList<>();
                for (int i = 0; i <data.size() ; i++) {
                    Bean.DataBean dataBean = data.get(i);
                    fragments.add(RcyFragment.newInstance(dataBean.getId()+"",null));
                    strings.add(dataBean.getName());

                }
                vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                tl1.setupWithViewPager(vp);

            }

            @Override
            public void onFailure(Call<Bean> call, Throwable throwable) {

            }
        });

    }
}
