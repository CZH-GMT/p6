package com.example.p62;

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

public class CollAdapter extends RecyclerView.Adapter {
    private Context context;
    public List<SubBean> list = new ArrayList<>();


    public CollAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<SubBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }
    public int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;


        } else {
            return 1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.rigthitem, parent, false);
            return new ViewHolder(inflate);
        } else {

            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            SubBean subBean = list.get(position);
            ViewHolder viewHolde= (ViewHolder) holder;
            Glide.with(context).load(subBean.getEnvelopePic()).into(viewHolde.iv);
            viewHolde.tv.setText(subBean.getDesc());

        }else {
            SubBean subBean = list.get(position);
            ViewHolder1 viewHolde= (ViewHolder1) holder;
            Glide.with(context).load(subBean.getEnvelopePic()).into(viewHolde.iv);
            viewHolde.tv.setText(subBean.getDesc());

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPosition(position);

                oitemClickListener.OitemClick(position);
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
        public ImageView iv;
        public TextView tv;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
    public interface OitemClickListener{
        void OitemClick(int position);

    }
    private OitemClickListener oitemClickListener;

    public void setOitemClickListener(OitemClickListener oitemClickListener) {
        this.oitemClickListener = oitemClickListener;
    }
}
