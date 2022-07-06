package com.example.jishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private int math;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        initView();
        initData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void gettime(Integer time) {
        myAdapter.updata(math, time);
    }


    private void initData() {
        ArrayList<Bean> beans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean("新闻" + i, 0);
            beans.add(bean);

        }
        myAdapter.additem(beans);


    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(int position, Bean bean) {
                math = position;
                startActivity(new Intent(MainActivity.this, WebActivity.class));

            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }

    boolean editmore = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (editmore) {
                    editmore = false;
                    btn1.setText("编辑");
                } else {
                    editmore = true;
                    btn1.setText("取消编辑");
                }
                myAdapter.setout(editmore);

                break;
            case R.id.btn2:
                myAdapter.remove();
                break;
        }
    }
}
