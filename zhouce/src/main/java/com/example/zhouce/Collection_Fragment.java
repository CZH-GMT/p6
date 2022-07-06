package com.example.zhouce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.App;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Collection_Fragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

    public Collection_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home_, container, false);
        activity = getActivity();
        initView(inflate);
        initDtata();
        return inflate;
    }

    private void initDtata() {

        List<SubBean> subBeans = App.daoSession.loadAll(SubBean.class);
        myAdapter.additem(subBeans);
    }

    private void initView(View inflate) {
        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView.setAdapter(myAdapter);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            initDtata();

        }
    }
}
