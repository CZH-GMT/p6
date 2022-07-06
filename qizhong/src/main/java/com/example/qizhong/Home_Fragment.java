//package com.example.qizhong;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class Home_Fragment extends Fragment {
//
//    private FragmentActivity activity;
//    private RecyclerView recyclerView;
//    private MyAdapter myAdapter;
//
//
//    public Home_Fragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View inflate = inflater.inflate(R.layout.fragment_home_, container, false);
//        activity = getActivity();
//        initView(inflate);
//        initData();
//
//        return inflate;
//    }
//
//    private void initView(View inflate) {
//        recyclerView=inflate.findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLay
//
//
//
//
//
//
//
//
//
//
//
//               // outManager(activity));
//        myAdapter = new MyAdapter(activity);
//        recyclerView.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClickListener(int position) {
//                SubBean subBean = myAdapter.list.get(position);
//                App.daoSession.insertOrReplace(subBean);
//                Toast.makeText(activity, "已添加", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    private void initData() {
//        Retrofit build = new Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(Apiservice.url).build();
//        build.create(Apiservice.class).getdata().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Bean bean) {
//
//                    myAdapter.additem(bean.getData().getDatas());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//
//    }
//}
