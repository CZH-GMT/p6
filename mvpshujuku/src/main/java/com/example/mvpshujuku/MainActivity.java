package com.example.mvpshujuku;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshujuku.View.Iview;
import com.example.mvpshujuku.presenter.Foodpresenter;

public class MainActivity extends AppCompatActivity implements Iview, View.OnClickListener {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Foodpresenter foodpresenter = new Foodpresenter(this);
        foodpresenter.getFood();
    }

    @Override
    public void updatasucess(Bean bean) {
        myAdapter.additem(bean.getData());


    }

    @Override
    public void updataFailed(String error) {
        Toast.makeText(this, error + "", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        myAdapter.setOnitemclickListener(new MyAdapter.onitemclickListener() {
            @Override
            public void onitemclickListener(SubBean subBean) {
                    
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                break;
        }
    }
}
