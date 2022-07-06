package com.example.g;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Activity;
import com.example.g.Presenter.Datapresenter;
import com.example.g.View.Iview;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends Fragment implements Iview {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private PopupWindow popupWindow;
    private Disposable subscribe;
    private SmartRefreshLayout mSml;
    private int count;
    private Datapresenter datapresenter;

    public OneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one2, container, false);
        activity = getActivity();
        initView(inflate);
        initData();

        return inflate;
    }

    private void initData() {
        datapresenter = new Datapresenter(this);
        datapresenter.getmath(count);
    }

    private void initView(final View inflate) {

        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        mSml = (SmartRefreshLayout) inflate.findViewById(R.id.sml);

        mSml.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                datapresenter.getmath(count);


                mSml.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                count=1;
                myAdapter.clear();
               datapresenter.getmath(count);
                mSml.finishRefresh();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void OnClickListener(int position) {
                View inflate1 = LayoutInflater.from(activity).inflate(R.layout.windows, null);

                popupWindow = new PopupWindow(inflate1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                popupWindow.showAtLocation(mRecyclerView, Gravity.CENTER, 0, 0);

                inflate1.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();

//                        NotificationManager systemService = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
////                        String id="123";
////                        String name="华哥";
////                        if (Build.VERSION.SDK_INT>=26){
////                            NotificationChannel notificationChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_DEFAULT);
////                            systemService.createNotificationChannel(notificationChannel);
////                        }
////
////                        Intent intent = new Intent(activity, Activity .class);
////                        PendingIntent activity1 = PendingIntent.getActivity(OneFragment.this.activity, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
////
////                        Notification hh = new NotificationCompat.Builder(activity, id)
////                                .setContentTitle("通知")
////                                .setSmallIcon(R.drawable.ic_launcher_background)
////                                .setAutoCancel(true)
////                                .setContentIntent(activity1)
////                                .build();
////                        systemService.notify(1,hh);
//                        NotificationManager systemService = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
//                        String id = "123";
//                        String name = "华哥";
//                        if (Build.VERSION.SDK_INT >= 26) {
//                            NotificationChannel notificationChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
//                            systemService.createNotificationChannel(notificationChannel);
//                        }
//                        Intent intent = new Intent(activity, Activity.class);
//                        PendingIntent activity1 = PendingIntent.getActivity(OneFragment.this.activity, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//
//                        Notification 通知 = new NotificationCompat.Builder(activity, id)
//                                .setSmallIcon(R.drawable.ic_launcher_background)
//                                .setContentTitle("通知")
//                                .setAutoCancel(true)
//                                .setContentIntent(activity1)
//                                .build();
//                        systemService.notify(1, 通知);
                        NotificationManager systemService = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
                        String id="123";
                        String name="dfghjkl";
                        if (Build.VERSION.SDK_INT>=26){
                            NotificationChannel notificationChannel = new NotificationChannel(id,name,NotificationManager.IMPORTANCE_DEFAULT);
                            systemService.createNotificationChannel(notificationChannel);
                        }
                        Intent intent = new Intent(activity, Activity.class);
                        PendingIntent activity1 = PendingIntent.getActivity(activity, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                        Notification hh = new NotificationCompat.Builder(activity, id)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentTitle("通知")
                                .setAutoCancel(true)
                                .setContentIntent(activity1)
                                .build();
                        systemService.notify(1,hh);


                    }
                });


            }
        });


        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.bannerurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        build.create(ApiService.class).getmath().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        myAdapter.addbanneritem(bannerBean.getData());
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
    public void updatasuccess(Bean bean) {
        myAdapter.dditem(bean.getData().getDatas());
        count++;


    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show();

    }


}
