package com.example.p62;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Collection_Fragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView mRcy;
    private CollAdapter adapter;

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
        List<SubBean> subBeans = App.daoSession.loadAll(SubBean.class);
        adapter.additem(subBeans);
        adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {

        mRcy = (RecyclerView) inflate.findViewById(R.id.rcy);
        mRcy.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new CollAdapter(activity);
        mRcy.setAdapter(adapter);
        adapter.setOitemClickListener(new CollAdapter.OitemClickListener() {
            @Override
            public void OitemClick(int position) {

                int position1 = adapter.position;
                SubBean subBean = adapter.list.get(position1);
                App.daoSession.delete(subBean);
                adapter.list.remove(position1);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&adapter!=null){
            initData();

        }
    }
}
