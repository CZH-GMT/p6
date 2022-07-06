package com.example.shujukushoucang2;

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

    private FragmentActivity activvity;
    private RecyclerView Rcy;
    private MyAdapter myAdapter;
    private Button mBtn;
    private Button mBtn1;

    public Collection_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collection_, container, false);
        activvity = getActivity();
        initView(inflate);
        initData();

        return inflate;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && myAdapter != null) {
            initData();
        }
    }
    private void initData() {
        List<ResultsBean> resultsBeans = App.daoSession.loadAll(ResultsBean.class);
        myAdapter.additem(resultsBeans);

    }

    private void initView(View inflate) {
        Rcy = inflate.findViewById(R.id.Rcy);
        Rcy.setLayoutManager(new LinearLayoutManager(activvity));
        myAdapter = new MyAdapter(activvity);
        Rcy.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                ResultsBean getitem = myAdapter.getitem(position);
                App.daoSession.delete(getitem);
                myAdapter.remove(position);
            }
        });

        mBtn = (Button) inflate.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn1 = (Button) inflate.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
    }



    //默认不是编辑式
    boolean editMode = false;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/12/19
                if (editMode){
                    editMode=false;
                    mBtn.setText("编辑");
                }else {
                    mBtn.setText("取消编辑");
                    editMode=true;

                }
                myAdapter.setEditMode(editMode);
                break;
            case R.id.btn1:
                // TODO 20/12/19
                myAdapter.setremovemore();
                break;
            default:
                break;
        }
    }
}
