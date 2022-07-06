package com.example.mvpliebiao3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpliebiao3.Presenter.Foodpresenter;
import com.example.mvpliebiao3.View.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private Foodpresenter foodpresenter;
    int page = 1;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        foodpresenter = new Foodpresenter(this);
        foodpresenter.getFood(page + "");

    }

    private void initView() {


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(myAdapter);
    }


    @Override
    public void updatesuccess(List<Bean.DataBean> list) {
        myAdapter.additem(list);


    }

    @Override
    public void updatefailed(String error) {
        Toast.makeText(this, error+"", Toast.LENGTH_SHORT).show();

    }
}
