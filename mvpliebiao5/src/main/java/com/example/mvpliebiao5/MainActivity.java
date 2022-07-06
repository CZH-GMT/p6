package com.example.mvpliebiao5;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpliebiao5.View.Iview;
import com.example.mvpliebiao5.presenter.Foodpresenter;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Foodpresenter foodpresenter = new Foodpresenter(this);
        foodpresenter.getFood();
    }

    @Override
    public void updatasuccess(Bean bean) {
        myAdapter.Additem(bean.getData());


    }

    @Override
    public void updatefailed(String error) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(myAdapter);
        
    }
}
