package com.example.shujukushoucang3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        activity =getActivity();
        initView(inflate);
        initData();

        return inflate;
    }

    private void initView(final View inflate) {
        recyclerView=inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnitemclicklistener(new MyAdapter.onitemclick() {
            @Override
            public void onitemclicklistener(int position) {
                ResultsBean getitem = myAdapter.getitem(position);
                long insert = App.daoSession.insert(getitem);
                myAdapter.notifyDataSetChanged();
                if (insert>0){
                    Toast.makeText(activity, "成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
                .build();
        build.create(ApiService.class).getitem().enqueue(new Callback<Bean>() {
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
}
