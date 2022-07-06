package com.example.ceyan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.App;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment2 extends Fragment {


    private RecyclerView mRcy;
    private FragmentActivity activity;
    private MyAdapter myAdapter;

    public CollectionFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collection2, container, false);
        activity =getActivity();
        initView(inflate);
        initData();

        return inflate;
    }

    private void initData() {
        List<SubBean> subBeans = App.daoSession.loadAll(SubBean.class);
        myAdapter.additem(subBeans);
    }

    private void initView(View inflate) {

        mRcy = (RecyclerView) inflate.findViewById(R.id.rcy);
        mRcy.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRcy.setAdapter(myAdapter);


    }

}
