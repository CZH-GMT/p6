package com.example.shujukushoucang2;

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

class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ResultsBean> list = new ArrayList<>();
    //状态集合
    private List<Boolean> statu = new ArrayList<>();
    private boolean editMode;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<ResultsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        for (int i = 0; i < this.list.size(); i++) {
            statu.add(false);
        }


        notifyDataSetChanged();
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


        if (editMode) {
            viewHolder.check.setVisibility(View.VISIBLE);
        } else {
            viewHolder.check.setVisibility(View.GONE);
        }
        final Boolean aBoolean = this.statu.get(position);
        viewHolder.check.setChecked(aBoolean);
        viewHolder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statu.set(position, !aBoolean);
                notifyItemChanged(position);
            }
        });


        Glide.with(context).load(resultsBean.getUrl()).into(viewHolder.iamge);
        viewHolder.tv.setText(resultsBean.getDesc());
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClickListener(position);
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setEditMode(boolean editMode) {

        this.editMode = editMode;
        notifyDataSetChanged();
    }


    public void setremovemore() {
        for (int i = this.statu.size() - 1; i >= 0; i--) {
            Boolean aBoolean = this.statu.get(i);
            if (aBoolean) {
                this.list.remove(i);
                this.statu.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iamge;
        public TextView tv;
        public CheckBox check;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iamge = (ImageView) rootView.findViewById(R.id.iamge);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.check = (CheckBox) rootView.findViewById(R.id.check);
        }

    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);

    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
