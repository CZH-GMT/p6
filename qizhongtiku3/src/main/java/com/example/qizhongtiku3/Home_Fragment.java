package com.example.qizhongtiku3;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment  {

    private FragmentActivity activity;
    private Button mBtn;
    private DongBroadcast dongBroadcast;

    public Home_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home_, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mBtn = (Button) inflate.findViewById(R.id.btn);

        dongBroadcast = new DongBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("huage");
        activity.registerReceiver(dongBroadcast,intentFilter);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("huage");
                intent.putExtra("key","我的广播事件");
                activity.sendBroadcast(intent);
            }
        });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
       activity.unregisterReceiver(dongBroadcast);
    }
}
