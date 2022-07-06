package com.example.zhouce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.App;
import com.example.Presenter.Datapresenter;
import com.example.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment implements Iview {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

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

        Datapresenter datapresenter = new Datapresenter(this);
        datapresenter.getmath();

        return inflate;

    }

    private void initView(View inflate) {

        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView.setAdapter(myAdapter);
   myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
       @Override
       public void ClickListener(int position) {
           SubBean subBean = myAdapter.list.get(position);
           App.daoSession.insertOrReplace(subBean);
           Toast.makeText(activity, "添加成功", Toast.LENGTH_SHORT).show();
       }
   });

    }

    @Override
    public void Updatasuccess(Bean bean) {
        myAdapter.additem(bean.getResults());


    }

    @Override
    public void Updatafailed(String error) {

    }
}
