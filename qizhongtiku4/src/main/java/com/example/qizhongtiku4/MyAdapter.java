package com.example.qizhongtiku4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    public List<Bean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public Bean getitem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Bean bean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.id.setText(bean.getName());
        viewHolder.phone.setText(bean.getPhone());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClickListener(v,position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv;
        public TextView id;
        public TextView phone;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.id = (TextView) rootView.findViewById(R.id.id);
            this.phone = (TextView) rootView.findViewById(R.id.phone);
        }

    }
    public interface  onItemClickListener{
        void  onItemClickListener(View v,int position);

    }
    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(MyAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
