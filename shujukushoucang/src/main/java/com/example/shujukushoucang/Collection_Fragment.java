package com.example.shujukushoucang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Collection_Fragment extends Fragment {

    private RecyclerView Rcy;
    private FragmentActivity activity;
    private MyAdapter myAdapter;

    public Collection_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collection_, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            initData();
            myAdapter.notifyDataSetChanged();
        }
    }

    private void initView(View inflate) {
        Rcy = inflate.findViewById(R.id.Rcy);
        Rcy.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        Rcy.setAdapter(myAdapter);
        myAdapter.setOnclicklistener(new MyAdapter.onclicklistener() {
            @Override
            public void onclicklistener(View view, int position) {
                GrilBean getitem = myAdapter.getitem(position);
                App.daoSession.delete(getitem);

                myAdapter.delete(position);
                Toast.makeText(activity, "删除", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {

        List<GrilBean> quary1 = DBUtil.quary();
        myAdapter.additem(quary1);

    }
}
