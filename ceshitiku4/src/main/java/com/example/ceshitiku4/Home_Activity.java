package com.example.ceshitiku4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class Home_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static MyAdapter myAdapter;
    private static final String TAG = "Home_Activity";
    private Dong dong;
BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.popuwindow, null);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.showAsDropDown(inflate, Gravity.CENTER_VERTICAL, 0, 0);
        Button button = inflate.findViewById(R.id.delet);
        TextView viewById = inflate.findViewById(R.id.tv);
        viewById.setText("确定删除" + intent.getStringExtra("key"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =myAdapter.position;
                Bean bean =myAdapter.list.get(position);
                App.daoSession.delete(bean);
                myAdapter.list.remove(position);
               myAdapter.notifyDataSetChanged();
            }
        });
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        initView();
        initData();



    }

    private void initData() {
        List<Bean> beans = App.daoSession.loadAll(Bean.class);
        myAdapter.additem(beans);


    }

    private void initView() {


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this);

        recyclerView.setAdapter(myAdapter);
//        dong = new Dong();
        IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("jjj");

        registerReceiver(broadcastReceiver, intentFilter);
        myAdapter.setOnIteClickListener(new MyAdapter.OnIteClickListener() {
            @Override
            public void OnIteClickListener(int position) {
                Intent intent = new Intent();
                intent.setAction("jjj");
                intent.putExtra("key",myAdapter.list.get(position).getName());
                sendBroadcast(intent);


            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
