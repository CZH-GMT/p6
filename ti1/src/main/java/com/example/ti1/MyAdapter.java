package com.example.ti1;

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
    public List<RcyBean.DataBean.DatasBean> list = new ArrayList();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<RcyBean.DataBean.DatasBean> list) {
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
        ViewHolder viewHolder= (ViewHolder) holder;
        RcyBean.DataBean.DatasBean datasBean = list.get(position);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder.image);
        viewHolder.title.setText(datasBean.getTitle());
        viewHolder.time.setText(datasBean.getAuthor());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclickListener!=null){
                    onclickListener.onclickListener(v,position);
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
        public ImageView image;
        public TextView title;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
    public interface onclickListener{
        void onclickListener (View v,int position);

    }
    private onclickListener onclickListener;

    public void setOnclickListener(MyAdapter.onclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

}
