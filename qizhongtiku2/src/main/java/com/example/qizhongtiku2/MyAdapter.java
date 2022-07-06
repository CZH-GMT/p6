package com.example.qizhongtiku2;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean.DataBean> list = new ArrayList<>();
    private Banner banner;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void additemtwo(List<Bean.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position%2==0) {
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
        } else if (viewType==1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            return new ViewHolder2(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.banner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bean.DataBean bean = (Bean.DataBean) path;
                    Glide.with(context).load(bean.getPic()).into(imageView);
                }
            }).start();
        } else if (itemViewType==1){
            Bean.DataBean bean = list.get(position-1);
            ViewHolder2 viewHolder1 = (ViewHolder2) holder;
            Glide.with(context).load(bean.getPic()).apply(new RequestOptions().circleCrop()).into(viewHolder1.image);
            viewHolder1.title.setText(bean.getTitle());
            viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    list.remove(position);
                    notifyItemChanged(position);

                }
            });

        }else {
            Bean.DataBean bean = list.get(position-1);
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(bean.getPic()).into(viewHolder1.iv);
            viewHolder1.tv.setText(bean.getTitle());

        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
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
        public ImageView image;
        public TextView title;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.title = (TextView) rootView.findViewById(R.id.title);
        }

    }
}

