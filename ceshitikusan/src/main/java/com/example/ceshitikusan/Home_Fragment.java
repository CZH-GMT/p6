package com.example.ceshitikusan;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {

    private FragmentActivity activity;
    private Button btn;
    private Dong dong;

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

    private void initView(final View inflate) {
        btn=inflate.findViewById(R.id.btn);
        dong = new Dong();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("123");
        activity.registerReceiver(dong,intentFilter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key","通知时间");
                intent.setAction("123");
                activity.sendBroadcast(intent);

            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activity.unregisterReceiver(dong);
    }
}
