package com.example.qimoceshi;

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
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Bean.DataBean.CatalogBean> list = new ArrayList<>();
    private List<Boolean> edit=new ArrayList<>();
    private boolean editMode;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean.DataBean.CatalogBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
        for (int i = 0; i <this.list.size() ; i++) {
            edit.add(false);

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.banneritem, parent, false);
            return new ViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType==0){
            ViewHolder viewHolder= (ViewHolder) holder;
            viewHolder.banner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bean.DataBean.CatalogBean bean= (Bean.DataBean.CatalogBean) path;
                    Glide.with(context).load(bean.getIcon()).into(imageView);
                }
            }).start();


        }else {
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            Bean.DataBean.CatalogBean bean = list.get(position);
            Glide.with(context).load(bean.getIcon()).into(viewHolder1.iv);
            viewHolder1.tv.setText(bean.getName());

            if (editMode){
                viewHolder1.check.setVisibility(View.VISIBLE);
            }else {
                viewHolder1.check.setVisibility(View.GONE);
            }
            final Boolean aBoolean = edit.get(position);

            viewHolder1.check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edit.set(position,!aBoolean);
                    notifyItemChanged(position);
                }
            });




        }

    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public void seteditmore(boolean editMode) {

        this.editMode = editMode;
        notifyDataSetChanged();
    }


    public void setremove() {
        for (int i = this.edit.size()-1; i >=0 ; i--) {
            Boolean aBoolean = this.edit.get(i);
            if (aBoolean){
                this.edit.remove(i);
                this.list.remove(i);
                notifyDataSetChanged();
            }

        }
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
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView tv;
        public CheckBox check;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.check = (CheckBox) rootView.findViewById(R.id.check);
        }

    }
}
