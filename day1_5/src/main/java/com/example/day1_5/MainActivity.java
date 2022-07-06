package com.example.day1_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smart;
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=5&page=";
    private int page = 1;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url(url + page)
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Bean bean = new Gson().fromJson(string, Bean.class);
                final List<Bean.DataBean> data = bean.getData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (page == 1) {
                            myAdapter.additem(data);

                        } else {
                            myAdapter.addrefurashitem(data);
                        }
                    }
                });

            }
        });

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        smart = (SmartRefreshLayout) findViewById(R.id.smart);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);

        smart.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                smart.finishLoadMore();

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                initData();
                smart.finishRefresh();

            }
        });
    }
}
