package com.example.qimob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimob.View.Iview;
import com.example.qimob.presenter.presenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Iview {





    private FragmentActivity activity;
    private com.example.qimob.presenter.presenter presenter;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
   // private BroadcastReceiver broadcastReceiver;


    public HomeFragment() {
        // Required empty public constructor
    }

   BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String key = intent.getStringExtra("key");
            Toast.makeText(context,key+"" , Toast.LENGTH_SHORT).show();
          //  startActivity(new Intent(activity,VpActivity.class));
        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        initView(inflate);
        presenter = new presenter(this);
        presenter.get();



        return inflate;
    }


    private void initView(final View inflate) {
        recyclerView=inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("key");


        activity.registerReceiver(broadcastReceiver,intentFilter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                Intent intent = new Intent();
                intent.putExtra("key",myAdapter.list.get(position).getDesc());
                intent.setAction("key");
                activity.sendBroadcast(intent);
                //Toast.makeText(activity, "hh", Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void updatasuccess(Bean bean) {
        myAdapter.additem(bean.getResults());

    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, error+"", Toast.LENGTH_SHORT).show();

    }
}
