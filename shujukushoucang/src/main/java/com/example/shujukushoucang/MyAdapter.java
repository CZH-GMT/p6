package com.example.shujukushoucang;

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
    private List<GrilBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<GrilBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();

    }
    public GrilBean getitem(int pos){
        return list.get(pos);
    }

    public void delete(int pos){
        this.list.remove(pos);
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
        GrilBean grilBean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(grilBean.getUrl()).into(viewHolder.iamge);
        viewHolder.tv.setText(grilBean.getDesc());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onclicklistener!=null){
                    onclicklistener.onclicklistener(v,position);
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
        public ImageView iamge;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iamge = (ImageView) rootView.findViewById(R.id.iamge);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
    public interface onclicklistener{
        void onclicklistener(View view,int position);
    }
    private onclicklistener onclicklistener;

    public void setOnclicklistener(MyAdapter.onclicklistener onclicklistener) {
        this.onclicklistener = onclicklistener;
    }
}
