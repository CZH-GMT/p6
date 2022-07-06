package com.example.ceshitikusan;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Two_Fragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    public Two_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two_, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(final View inflate) {
        recyclerView = inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);
        DDDD dddd = new DDDD();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("444");
        activity.registerReceiver(dddd,intentFilter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {

                Intent intent = new Intent();
                intent.setAction("444");
                intent.putExtra("hhh","广播");
                activity.sendBroadcast(intent);


            }
        });
    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        build.create(ApiService.class).getdata().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                List<Bean.ResultsBean> results = bean.getResults();
                myAdapter.additem(results);
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && myAdapter != null) {
            initData();
            myAdapter.notifyDataSetChanged();
        }
    }
}
