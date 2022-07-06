package com.example.qizhong;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends Fragment {

    private FragmentActivity activity;
    private RecyclerView recyclerView11;
    private MyAdapter myAdapter;

    public CollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collection, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        List<SubBean> subBeans = App.daoSession.loadAll(SubBean.class);
        myAdapter.additem(subBeans);


    }


    private void initView(View inflate) {
        recyclerView11 = inflate.findViewById(R.id.recyclerView11);
        recyclerView11.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView11.setAdapter(myAdapter);
        registerForContextMenu(recyclerView11);
//        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void OnItemClickListener(int position) {
//
//
//            }
//        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            initData();
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,0,0,"删除");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                int position = myAdapter.position;
                SubBean subBean = myAdapter.list.get(position);
                App.daoSession.delete(subBean);
                myAdapter.list.remove(position);
                myAdapter.notifyDataSetChanged();

                break;
        }
        return super.onContextItemSelected(item);
    }
}
