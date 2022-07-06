package com.example.qizhong2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean.ResultsBean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean.ResultsBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;

        } else if (position == 1) {

            return 1;
        } else {
            return 2;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.banneritem, parent, false);
            return new ViewHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.itemmmm, parent, false);
            return  new ViewHolder2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }




    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
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
    public static
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView title;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}
