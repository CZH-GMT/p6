package com.example.shujukushoucang3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ResultsBean> list = new ArrayList<>();
    private List<Boolean> status = new ArrayList<>();
    private boolean editmode;


    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<ResultsBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

        for (int i = 0; i < this.list.size(); i++) {
            status.add(false);
        }
    }

    public ResultsBean getitem(int position) {
        return list.get(position);

    }

    public void remove(int position) {

        this.list.remove(position);
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
        ResultsBean resultsBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;


        if (editmode) {
            viewHolder.check.setVisibility(View.VISIBLE);
        } else {
            viewHolder.check.setVisibility(View.GONE);
        }
        //checkBox状态根据
        final Boolean ischeck = status.get(position);
        viewHolder.check.setChecked(ischeck);
        viewHolder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //重新设置状态
                status.set(position,!ischeck);
                notifyItemChanged(position);
            }
        });



        Glide.with(context).load(resultsBean.getUrl()).into(viewHolder.image);
        viewHolder.tv.setText(resultsBean.getDesc());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onitemclicklistener != null) {
                    onitemclicklistener.onitemclicklistener(position);
                }
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //适配器记录
    public void setEditMode(boolean editmode) {


        this.editmode = editmode;
        notifyDataSetChanged();
    }

    //选中删除
    public void removeMore() {
        for (int i = this.status.size() - 1; i >= 0; i--) {
            Boolean aBoolean = this.status.get(i);
            if (aBoolean) {
                this.list.remove(i);
                this.status.remove(i);
            }
        }
        notifyDataSetChanged();

    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView tv;
        CheckBox check;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.check = rootView.findViewById(R.id.check);
        }

    }

    public interface onitemclick {
        void onitemclicklistener(int position);

    }

    private onitemclick onitemclicklistener;

    public void setOnitemclicklistener(onitemclick onitemclicklistener) {
        this.onitemclicklistener = onitemclicklistener;
    }
}
