package com.example.mvpliebiao2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpliebiao2.View.Iview;
import com.example.mvpliebiao2.presenter.Foodpresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private Foodpresenter foodpresenter;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        foodpresenter = new Foodpresenter(this);
        foodpresenter.getFood();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void updatesuccess(List<Bean.DataBean> list) {
        myAdapter.additem(list);

    }

    @Override
    public void updateFailed(String error) {
        Toast.makeText(this, error+"", Toast.LENGTH_SHORT).show();

    }
}
