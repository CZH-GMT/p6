package com.example.qizhongtiku4;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Home_Activity extends AppCompatActivity {

    private RecyclerView revcyclerView;
    private MyAdapter myAdapter;
    private List<Bean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        initView();
        initData();
    }

    private void initData() {

        beans = App.daoSession.loadAll(Bean.class);
        myAdapter.additem(beans);
    }

    private void initView() {
        revcyclerView = (RecyclerView) findViewById(R.id.revcyclerView);
        revcyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);
        revcyclerView.setAdapter(myAdapter);
        Dong dong = new Dong();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("hh");
        registerReceiver(dong, intentFilter);
        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {

            @Override
            public void onItemClickListener(View v, final int position) {
                Intent intent = new Intent();
                intent.putExtra("key", beans.get(position).getName());

                intent.setAction("hh");
                sendBroadcast(intent);

                View inflate = LayoutInflater.from(Home_Activity.this).inflate(R.layout.windown, null);
                PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                popupWindow.showAsDropDown(inflate, Gravity.BOTTOM,0,0);
                final Window window = getWindow();
                final WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha=0.3f;
                window.setAttributes(attributes);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                            attributes.alpha=1;
                            window.setAttributes(attributes);
                    }
                });
                Button btn = inflate.findViewById(R.id.btn);
                Button btn1 = inflate.findViewById(R.id.btn1);
                TextView viewById = inflate.findViewById(R.id.tv);
                viewById.setText(beans.get(position).getName());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        App.daoSession.delete(beans.get(position));
                        myAdapter.list.remove(position);
                        myAdapter.notifyDataSetChanged();
                    }
                });
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        });
    }
}
