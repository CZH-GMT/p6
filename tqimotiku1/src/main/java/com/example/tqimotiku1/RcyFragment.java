package com.example.tqimotiku1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tqimotiku1.Presenter.Datapresenter;
import com.example.tqimotiku1.View.Iview;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RcyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RcyFragment extends Fragment implements Iview {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentActivity activity;
    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;
    private int count;
    private SmartRefreshLayout mSrl;

    public RcyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RcyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RcyFragment newInstance(String param1, String param2) {
        RcyFragment fragment = new RcyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_rcy, container, false);
//        EventBus.getDefault().register(this);
        activity = getActivity();
        initView(inflate);
        Datapresenter datapresenter = new Datapresenter(this);

        count++;
        datapresenter.getmath(mParam1);

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
                String link = myAdapter.list.get(position).getLink();
                Util util = new Util();
                util.setLink(link);
                Intent intent = new Intent(activity, Home_Activity.class);
                EventBus.getDefault().postSticky(util);
                startActivity(intent);
            }
        });
        mSrl = (SmartRefreshLayout) inflate.findViewById(R.id.srl);
        mSrl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    @Override
    public void updatasuccess(Beans bean) {
        myAdapter.additem(bean.getData().getDatas());


    }

    @Override
    public void updatafailed(String error) {
        Toast.makeText(activity, error + "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
