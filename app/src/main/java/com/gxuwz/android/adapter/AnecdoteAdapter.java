package com.gxuwz.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.AnecdoteBean;
import com.gxuwz.android.holder.ItemAnecdoteHolder;

import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/816:04.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class AnecdoteAdapter extends BaseAdapter{
    private ArrayList<AnecdoteBean> dataList;
    private LayoutInflater inflater;
    private Context mContext;

    public AnecdoteAdapter(ArrayList<AnecdoteBean> dataList,Context context) {
        this.dataList = dataList;
        this.inflater=LayoutInflater.from(context);
        this.mContext=context;
    }

    @Override
    public int getCount(){
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ItemAnecdoteHolder holder=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_anecdote,parent,false);
            holder=new ItemAnecdoteHolder(convertView);
            convertView.setTag(holder);
        }else{
         holder= (ItemAnecdoteHolder) convertView.getTag();
        }

        holder.getItemAnecdoteDescription().setText(dataList.get(position).getDescription());
        holder.getItemAnecdoteTitle().setText(dataList.get(position).getTitle());
        x.image().bind(holder.getItemAnecdoteImage(),dataList.get(position).getPicUrl());

        return convertView;
    }
}
