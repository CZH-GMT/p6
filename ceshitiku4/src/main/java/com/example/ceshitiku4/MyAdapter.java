package com.example.ceshitiku4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    public List<Bean> list = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void additem(List<Bean> list) {
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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Bean bean = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(bean.getName());
        viewHolder.age.setText(bean.getSex());
        viewHolder.phone.setText(bean.getPhone()+"");
        viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onIteClickListener!=null){
                    setPosition(position);
                    onIteClickListener.OnIteClickListener(position);
                }
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
        public TextView name;
        public TextView age;
        public TextView phone;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.age = (TextView) rootView.findViewById(R.id.age);
            this.phone = (TextView) rootView.findViewById(R.id.phone);
        }

    }
    public interface OnIteClickListener{
        void OnIteClickListener(int position);
    }
    private OnIteClickListener onIteClickListener;

    public void setOnIteClickListener(OnIteClickListener onIteClickListener) {
        this.onIteClickListener = onIteClickListener;
    }
}
