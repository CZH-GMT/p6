package com.example.ceyan;

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
import com.example.ceyan.Presenter.DataPresenter;
import com.example.ceyan.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Iview {

    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private int page=294;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        activity = getActivity();
        initView(inflate);
        DataPresenter dataPresenter = new DataPresenter(this);
        page++;
        dataPresenter.getmath(page+"");
        return inflate;

    }

    private void initView(View inflate) {

        mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                SubBean subBean = myAdapter.list.get(position);
                App.daoSession.insert(subBean);
                myAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void updatasuccess(Bean bean) {
        myAdapter.additem(bean.getData().getDatas());

    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, "操你妈", Toast.LENGTH_SHORT).show();

    }
}
