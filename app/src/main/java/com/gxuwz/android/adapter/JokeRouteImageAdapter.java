package com.gxuwz.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.JokeRouteImageBean;
import com.gxuwz.android.holder.ItemJokeImgHolder;

import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/921:57.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeRouteImageAdapter extends BaseAdapter {
    private ArrayList<JokeRouteImageBean> dataList;
    private LayoutInflater inflater;

    public JokeRouteImageAdapter(ArrayList<JokeRouteImageBean> dataList, Context context) {
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
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

        ItemJokeImgHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_joke_img, parent, false);
            holder = new ItemJokeImgHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ItemJokeImgHolder) convertView.getTag();
        }
        holder.getItemJokeImgTitle().setText(dataList.get(position).getTitle());
        x.image().bind(holder.getItemJokeImgContent(),dataList.get(position).getSourceurl());
        holder.getItemJokeImgTime().setVisibility(View.GONE);
        return convertView;
    }
}
