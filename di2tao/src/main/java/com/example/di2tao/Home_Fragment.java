package com.example.di2tao;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.di2tao.Presenter.Datapresenter;
import com.example.di2tao.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment implements Iview {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdaper myAdaper;

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
        myAdaper = new MyAdaper(activity);
        mRecyclerView.setAdapter(myAdaper);
        myAdaper.setOnItemClickListener(new MyAdaper.OnItemClickListener() {
            @Override
            public void OnClickListener(final int position) {
                View inflate1 = LayoutInflater.from(activity).inflate(R.layout.popuwendowitem, null);
                View btn1 = inflate1.findViewById(R.id.btn1);
                View btn2 = inflate1.findViewById(R.id.btn2);
                final PopupWindow popupWindow = new PopupWindow(inflate1,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
                popupWindow.showAsDropDown(inflate1, Gravity.CENTER,Gravity.CENTER_VERTICAL,Gravity.CENTER_VERTICAL);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myAdaper.list.remove(position);
                        myAdaper.notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });

    }

    @Override
    public void updatasuccess(Bean bean) {
        myAdaper.additem(bean.getResults());

    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show();

    }
}
