package com.gxuwz.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.JokeRouteTextBean;
import com.gxuwz.android.holder.ItemJokeTextHolder;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/921:56.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeRouteTextAdapter extends BaseAdapter{
    private ArrayList<JokeRouteTextBean> dataList;
    private LayoutInflater inflater;

    public JokeRouteTextAdapter(ArrayList<JokeRouteTextBean> dataList,Context context) {
        this.dataList = dataList;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemJokeTextHolder holder=null;

        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_joke_text,parent,false);
            holder=new ItemJokeTextHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ItemJokeTextHolder) convertView.getTag();
        }

        holder.getItemJokeTextTitle().setText(dataList.get(position).getTitle());
        holder.getItemJokeTextContent().setText(dataList.get(position).getContent());
        holder.getItemJokeTextTime().setVisibility(View.GONE);

        return convertView;
    }
}
