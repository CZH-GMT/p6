package com.example.gouwucheanli;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView RecyclerView;
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

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getdata().enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                List<ResultsBean> results = response.body().getResults();
                myAdapter.additem(results);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable throwable) {

            }
        });



    }

    private void initView(View inflater) {
        RecyclerView = (RecyclerView) inflater.findViewById(R.id.recyclerView);

        RecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        RecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onLonfItemClickListener(int position) {
                ResultsBean getitem = myAdapter.getitem(position);
                App.daoSession.insert(getitem);
                Toast.makeText(activity, "添加", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
