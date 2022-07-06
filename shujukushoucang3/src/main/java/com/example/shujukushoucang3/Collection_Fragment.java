package com.example.shujukushoucang3;

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

    private RecyclerView rcy;
    private FragmentActivity activity;
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
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        List<ResultsBean> resultsBeans = App.daoSession.loadAll(ResultsBean.class);

        myAdapter.additem(resultsBeans);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (myAdapter != null&&isVisibleToUser) {
            initData();
        }
    }

    private void initView(View inflate) {
        rcy = inflate.findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        rcy.setAdapter(myAdapter);
        myAdapter.setOnitemclicklistener(new MyAdapter.onitemclick() {
            @Override
            public void onitemclicklistener(int position) {
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
//boolean editmode=false;
    boolean editmode=false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/12/19
               if (editmode){
                   editmode=false;
                   mBtn.setText("编辑");
               }else {
                   editmode=true;
                   mBtn1.setText("取消编辑");

               }
                myAdapter.setEditMode(editmode);
                break;
            case R.id.btn1:
                // TODO 20/12/19
                myAdapter.removeMore();
                break;
            default:
                break;
        }
    }
}
