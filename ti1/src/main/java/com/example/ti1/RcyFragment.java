package com.example.ti1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RcyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RcyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView2;
    private FragmentActivity activity;
    private MyAdapter myAdapter;
    private Sqlite sqlite;

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
        activity =getActivity();
        sqlite = new Sqlite(activity);

        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(View inflate) {
        recyclerView2=inflate.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity));
        myAdapter = new MyAdapter(activity);
        recyclerView2.setAdapter(myAdapter);

        myAdapter.setOnclickListener(new MyAdapter.onclickListener() {
            @Override
            public void onclickListener(View v, int position) {
                SQLiteDatabase writableDatabase = sqlite.getWritableDatabase();
                ContentValues Values = new ContentValues();
                RcyBean.DataBean.DatasBean datasBean = myAdapter.list.get(position);

                Values.put("image",datasBean.getEnvelopePic());
                Values.put("title",datasBean.getTitle());
                Values.put("time",datasBean.getAuthor());
                writableDatabase.insert("user",null,Values);
                writableDatabase.close();


            }
        });


    }

    private void initData() {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.dataUrl)
                .build();
        build.create(ApiService.class).getitem(mParam1).enqueue(new Callback<RcyBean>() {
            @Override
            public void onResponse(Call<RcyBean> call, Response<RcyBean> response) {
                RcyBean body = response.body();
                RcyBean.DataBean data = body.getData();
                List<RcyBean.DataBean.DatasBean> datas = data.getDatas();
                myAdapter.additem(datas);
            }

            @Override
            public void onFailure(Call<RcyBean> call, Throwable throwable) {

            }
        });

    }
}
