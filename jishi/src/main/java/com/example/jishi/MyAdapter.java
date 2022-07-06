package com.example.jishi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    public List<Bean> list = new ArrayList<>();


    List<Boolean> edit=new ArrayList<>();

    private boolean editmore;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
        for (int i = 0; i <this.list.size() ; i++) {
            this.edit.add(false);

        }
    }
    public void updata(int pos,int time){
        Bean bean = list.get(pos);
        bean.setTime(bean.getTime()+time);
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
        final Bean bean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv.setText(bean.getTitle());
        viewHolder.time.setText("累计时间为"+bean.getTime()+"s");

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.OnClickListener(position,bean);
                }
                return false;
            }
        });

        if (editmore){
            viewHolder.check.setVisibility(View.VISIBLE);
        }else {
            viewHolder.check.setVisibility(View.GONE);
        }

        final Boolean aBoolean = edit.get(position);
        viewHolder.check.setChecked(aBoolean);
        viewHolder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.set(position,!aBoolean);
                notifyItemChanged(position);
            }
        });


    }
    public void remove(){
        for (int i = this.edit.size()-1; i >=0 ; i--) {
            Boolean aBoolean = edit.get(i);
            if (aBoolean){
                this.edit.remove(i);
                this.list.remove(i);
                notifyDataSetChanged();
            }


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setout(boolean editmore) {
        this.editmore = editmore;
        notifyDataSetChanged();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public CheckBox check;
        public TextView tv;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.check = (CheckBox) rootView.findViewById(R.id.check);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
    public interface OnItemClickListener{
        void OnClickListener(int position,Bean bean);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
