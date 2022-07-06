package com.example.p62;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p62.Presenter.Datapresenter;
import com.example.p62.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Iview {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
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
        myAdapter.setOnItemClickListtener(new MyAdapter.OnItemClickListtener() {
            @Override
            public void OnIClickListtener(final int position) {
                new AlertDialog.Builder(activity,0)
                        .setTitle("确定添加此条目")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SubBean subBean = myAdapter.list.get(position);
                                App.daoSession.insertOrReplace(subBean);
                                myAdapter.notifyDataSetChanged();

                            }
                        }).show();
            }

            @Override
            public void OnIClick(int position) {


                Intent intent = new Intent(activity,WebActivity.class);
                String link = myAdapter.list.get(position).getLink();
                intent.putExtra("hh", link);
                startActivity(intent);

            }
        });

    }

    @Override
    public void Updatasuccess(Bean bean) {
        myAdapter.additem(bean.getData().getDatas());



    }

    @Override
    public void Updatafailed(String error) {

    }
}
