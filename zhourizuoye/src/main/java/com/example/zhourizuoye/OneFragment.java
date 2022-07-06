package com.example.zhourizuoye;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiService.bannerurl).addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                List<ResultsBean> data = response.body().getResults();
                myAdapter.additem(data);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable throwable) {

            }
        });


    }

    private void initView(View inflate) {
        recyclerView=inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);




    }
}
