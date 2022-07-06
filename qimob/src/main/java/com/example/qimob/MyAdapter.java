package com.example.qimob;

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
    public List<Bean.ResultsBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean.ResultsBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            return new ViewHolder1(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            Bean.ResultsBean datasBean = list.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(context).load(datasBean.getUrl()).into(viewHolder.iv);
            viewHolder.tv.setText(datasBean.getDesc());


        }else {
            Bean.ResultsBean datasBean = list.get(position);
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(datasBean.getUrl()).into(viewHolder1.iamge);
            viewHolder1.title.setText(datasBean.getDesc());

        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.OnItemClickListener(position);
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
    class ViewHolder extends RecyclerView.ViewHolder {
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

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iamge;
        public TextView title;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iamge = (ImageView) rootView.findViewById(R.id.iamge);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
    public interface OnItemClickListener{
        void OnItemClickListener(int position);

    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
