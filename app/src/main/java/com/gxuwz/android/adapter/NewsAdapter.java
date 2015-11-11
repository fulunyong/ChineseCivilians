package com.gxuwz.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.EntertainmentBean;
import com.gxuwz.android.holder.ItemNewsHolder;

import org.xutils.x;

import java.util.List;

/**
 * Created by fulunyong on 2015/11/721:36.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class NewsAdapter extends BaseAdapter{
    private List<EntertainmentBean> dataList;
    private LayoutInflater inflater;

    public NewsAdapter(List<EntertainmentBean> dataList,Context context) {
        this.dataList = dataList;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position){
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ItemNewsHolder holder=null;

        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_news,parent,false);
            holder=new ItemNewsHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ItemNewsHolder) convertView.getTag();
        }

        holder.getItemNewsTitle().setText(dataList.get(position).getTitle());
        holder.getItemNewsDescription().setText(dataList.get(position).getDescription());
        x.image().bind(holder.getItemNewsImage(),dataList.get(position).getPicUrl());
        try {
            String time=dataList.get(position).getTime();
            if (time!=null){
                holder.getItemNewsTime().setText(time);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return convertView;
        }

    }
}
