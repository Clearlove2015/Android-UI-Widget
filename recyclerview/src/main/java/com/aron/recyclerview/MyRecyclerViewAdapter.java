package com.aron.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ZC on 2017/11/15.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<PersonBean> mData;

    public MyRecyclerViewAdapter(Context context, List<PersonBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,null);//注意：使用该方式会使子布局宽度不能充满父容器
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_age.setText(mData.get(position).getAge());
        holder.tv_address.setText(mData.get(position).getAddress());
        //item点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"item " + position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_age;
        TextView tv_address;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_age = (TextView) itemView.findViewById(R.id.tv_age);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            this.itemView = itemView;
        }
    }
}
