package com.example.zhourizuoye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ResultsBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<ResultsBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        ResultsBean resultsBean = list.get(position);
        ViewHolder1 viewHolder1= (ViewHolder1) holder;
            Glide.with(context).load(resultsBean.getUrl()).into(viewHolder1.iv);
            viewHolder1.tv.setText(resultsBean.getDesc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }





    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView tv;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
