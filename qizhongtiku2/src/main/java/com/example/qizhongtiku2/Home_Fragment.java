package com.example.qizhongtiku2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private SmartRefreshLayout sm;
private int count=1;
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
        sm=inflate.findViewById(R.id.sm);
        recyclerView = inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);

        sm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                count++;
                initData();
                sm.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                count=1;
                initData();
                sm.finishRefresh();
            }
        });

    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        build.create(ApiService.class).getdata(count).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                List<Bean.DataBean> data = bean.getData();
                if (count==1){
                    myAdapter.additem(data);
                }else {
                    myAdapter.additemtwo(data);
                }


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

}
