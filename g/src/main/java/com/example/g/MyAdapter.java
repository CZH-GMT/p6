package com.example.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SubBean> list = new ArrayList<>();
    private List<BannerBean.DataBean> bannerList = new ArrayList();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void dditem(List<SubBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    public void addbanneritem(List<BannerBean.DataBean> bannerList) {
        this.bannerList.addAll(bannerList);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position % 2 != 0) {
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
            return new ViewHolder0(inflate);

        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
            return new ViewHolder2(inflate);
        }

    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            viewHolder0.banner.setImages(bannerList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.DataBean dataBean = (BannerBean.DataBean) path;
                    Glide.with(context).load(dataBean.getImagePath()).into(imageView);
                }
            }).start();
        } else if (itemViewType == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            SubBean subBean = list.get(position-1);


            Glide.with(context).load(subBean.getEnvelopePic()).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv);
            viewHolder1.tv.setText(subBean.getDesc());


        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            SubBean subBean = list.get(position-1);
            RoundedCorners roundedCorners = new RoundedCorners(50);
            RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);

            Glide.with(context).load(subBean.getEnvelopePic()).apply(requestOptions).into(viewHolder2.image);
            viewHolder2.text.setText(subBean.getDesc());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.OnClickListener(position);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    public void clear() {
        this.list.clear();
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;

        public ViewHolder0(View rootView) {
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
        public TextView text;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.text = (TextView) rootView.findViewById(R.id.text);
        }

    }
    public interface OnItemClickListener{
        void OnClickListener(int position);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
