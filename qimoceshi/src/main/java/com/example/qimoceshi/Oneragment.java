package com.example.qimoceshi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimoceshi.Presenter.Datapresenter;
import com.example.qimoceshi.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class Oneragment extends Fragment implements Iview, View.OnClickListener {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private Button mBtn1;
    private Button mBtn2;

    public Oneragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_oneragment, container, false);
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

        mBtn1 = (Button) inflate.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) inflate.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void updatasucess(Bean bean) {
        myAdapter.additem(bean.getData().getCatalog());

    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show();

    }


    boolean editMode=false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                // TODO 21/01/04

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
                // TODO 21/01/04
                myAdapter.setremove();
                break;
            default:
                break;
        }
    }
}
