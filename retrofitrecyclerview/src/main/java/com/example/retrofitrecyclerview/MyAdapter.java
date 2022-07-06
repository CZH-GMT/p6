package com.example.retrofitrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean.DataBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

//    public void additem(List<Bean.DataBean> list) {
//        this.list.addAll(list);
//        notifyDataSetChanged();
//    }
    public void additem(List<Bean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        Bean.DataBean dataBean = list.get(position);
//        ViewHolder viewHolder= (ViewHolder) holder;
//        Glide.with(context).load(dataBean.getPic()).into(viewHolder.image);
//        viewHolder.title.setText(dataBean.getTitle());
        Bean.DataBean dataBean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.image);
        viewHolder.title.setText(dataBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView image;
        public TextView title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
