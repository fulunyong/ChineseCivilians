package com.gxuwz.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.MenuItemEntity;
import com.gxuwz.android.holder.ItemMenuHolder;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/714:00.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class MenuMainAdapter extends BaseAdapter{

    private ArrayList<MenuItemEntity> list;
    private LayoutInflater inflater;

    public MenuMainAdapter(ArrayList<MenuItemEntity> list,Context cotext) {
        this.list = list;
        this.inflater=LayoutInflater.from(cotext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ItemMenuHolder holder=null;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_menu,parent,false);
            holder=new ItemMenuHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ItemMenuHolder) convertView.getTag();
        }
        holder.getItemMenuTextName().setText(list.get(position).neme);
        holder.getIvItemMenu().setBackgroundResource(list.get(position).logoId);
        return convertView;
    }
}
