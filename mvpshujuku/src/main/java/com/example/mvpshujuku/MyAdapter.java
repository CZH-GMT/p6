package com.example.mvpshujuku;

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

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SubBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<SubBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final SubBean dataBean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.iv);
        viewHolder.tv.setText(dataBean.getTitle());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onitemclickListener!=null){
                    onitemclickListener.onitemclickListener(dataBean);
                }
                return false;
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
        public ImageView iv;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
    public interface onitemclickListener{
        void onitemclickListener(SubBean subBean);
    }
    private onitemclickListener onitemclickListener;

    public void setOnitemclickListener(MyAdapter.onitemclickListener onitemclickListener) {
        this.onitemclickListener = onitemclickListener;
    }
}
