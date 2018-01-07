package com.aron.android_ui_widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZC on 2017/11/15.
 */

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<PersonBean> mData;

    public MyListViewAdapter(Context context, List<PersonBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lv,null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_age = (TextView) view.findViewById(R.id.tv_age);
            holder.tv_address = (TextView) view.findViewById(R.id.tv_address);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_name.setText(mData.get(i).getName());
        holder.tv_age.setText(mData.get(i).getAge());
        holder.tv_address.setText(mData.get(i).getAddress());

        return view;
    }

    class ViewHolder{
        TextView tv_name;
        TextView tv_age;
        TextView tv_address;
    }

}
