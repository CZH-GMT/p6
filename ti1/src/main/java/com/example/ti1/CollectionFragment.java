package com.example.ti1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends Fragment {

    private FragmentActivity acticity;
    private RecyclerView rcy;
    private Sqlite sqlite;
    private MyAdapter myAdapter;

    public CollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collection, container, false);
        acticity = getActivity();
        sqlite = new Sqlite(acticity);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initView(View inflate) {
        rcy=inflate.findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(acticity));
        myAdapter = new MyAdapter(acticity);
        rcy.setAdapter(myAdapter);

    }


    private void initData() {
        myAdapter.list.clear();
        SQLiteDatabase writableDatabase = sqlite.getWritableDatabase();
        Cursor user = writableDatabase.query("user", null, null, null, null, null, null);
        while (user.moveToNext()){
            int id = user.getInt(user.getColumnIndex("id"));
            String image = user.getString(user.getColumnIndex("image"));
            String title = user.getString(user.getColumnIndex("title"));
            String time = user.getString(user.getColumnIndex("time"));
            RcyBean.DataBean.DatasBean datasBean = new RcyBean.DataBean.DatasBean();
            datasBean.setEnvelopePic(image);
            datasBean.setTitle(title);
            datasBean.setAuthor(time);
            myAdapter.list.add(datasBean);
        }


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&myAdapter!=null){
            initData();
            myAdapter.notifyDataSetChanged();
        }
    }
}
