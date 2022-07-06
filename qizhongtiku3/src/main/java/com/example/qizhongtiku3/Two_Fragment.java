package com.example.qizhongtiku3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

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

    private RecyclerView mRecyclerView;
    private FragmentActivity activity;
    private MyAdapter myAdapter;

    public Two_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two_, container, false);
        activity =getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        Retrofit build = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
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

    private void initView(View Inflater) {
        mRecyclerView = (RecyclerView)Inflater .findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            initData();
            myAdapter.notifyDataSetChanged();
        }
    }
}
