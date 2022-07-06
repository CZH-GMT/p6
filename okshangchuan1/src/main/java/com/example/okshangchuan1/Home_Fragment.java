package com.example.okshangchuan1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.okshangchuan1.Presenter.presenter;
import com.example.okshangchuan1.View.Iview;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment implements Iview {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private com.example.okshangchuan1.Presenter.presenter presenter;

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
        presenter = new presenter(this);
        presenter.XaingMu();

        return inflate;
    }

    private void initView(View inflate) {
        recyclerView=inflate.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView.setAdapter(myAdapter);



    }

    @Override
    public void updatasuccess(Bean bean) {
        myAdapter.additem(bean.getData().getDatas());

    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, error+"", Toast.LENGTH_SHORT).show();

    }
}
