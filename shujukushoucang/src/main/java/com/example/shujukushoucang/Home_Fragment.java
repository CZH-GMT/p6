package com.example.shujukushoucang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.greendao.DbUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private FragmentActivity activity;
    private MyAdapter myAdapter;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home_, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(View inflate) {
        recyclerView=inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnclicklistener(new MyAdapter.onclicklistener() {
            @Override
            public void onclicklistener(View view, int position) {
                GrilBean h = myAdapter.getitem(position);
               DBUtil.insert(h);
                Toast.makeText(activity, "收藏", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {


        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean body = response.body();
                List<GrilBean> results = body.getResults();
                myAdapter.additem(results);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable throwable) {

            }
        });
    }
}
