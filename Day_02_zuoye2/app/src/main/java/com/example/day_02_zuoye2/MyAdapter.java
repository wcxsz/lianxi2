package com.example.day_02_zuoye2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private ArrayList<DataDb> list;
    private Context context;
    private MyLongCilck myLongCilck;

    public MyAdapter(ArrayList<DataDb> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        MyHolder myHolder = new MyHolder(inflate);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.title.setText(list.get(position).getTitle());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                myLongCilck.longCilck(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView title;
        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            title = (TextView) itemView.findViewById(R.id.title);

        }
    }
    public interface MyLongCilck{
        void longCilck(int position);
    }

    public void setList(ArrayList<DataDb> list) {
        this.list = list;
    }

    public void setMyLongCilck(MyLongCilck myLongCilck) {
        this.myLongCilck = myLongCilck;
    }
}
