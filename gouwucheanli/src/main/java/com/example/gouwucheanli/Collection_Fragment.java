package com.example.gouwucheanli;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Collection_Fragment extends Fragment implements View.OnClickListener {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView1;
    private Button mBtn1;
    private Button mBtn2;
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
        iniData();
        return inflate;
    }

    private void initView(View inflate) {

        mRecyclerView1 = (RecyclerView) inflate.findViewById(R.id.recyclerView1);
        mBtn1 = (Button) inflate.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) inflate.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView1.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onLonfItemClickListener(int position) {
                ResultsBean getitem = myAdapter.getitem(position);
                App.daoSession.delete(getitem);
                myAdapter.notifyDataSetChanged();            }
        });
    }

    private void iniData() {
        List<ResultsBean> resultsBeans = App.daoSession.loadAll(ResultsBean.class);
        myAdapter.additem(resultsBeans);

    }

    boolean editMode = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                // TODO 20/12/19
               if (editMode){
                   editMode=false;
                   mBtn1.setText("编辑");
               }else {
                   editMode=true;
                   mBtn2.setText("取消编辑");
               }
              myAdapter.seteditmore(editMode);
                break;
            case R.id.btn2:
                // TODO 20/12/19
              myAdapter.setremove();
                break;

            default:
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            iniData();
            myAdapter.notifyDataSetChanged();
        }
    }
}
