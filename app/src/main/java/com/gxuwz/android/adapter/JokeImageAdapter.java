package com.gxuwz.android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.entity.JokeImageBean;
import com.gxuwz.android.holder.ItemJokeImgHolder;

import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/917:48.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeImageAdapter extends BaseAdapter {

    private ArrayList<JokeImageBean> dataList;
    private LayoutInflater inflater;

    public JokeImageAdapter(ArrayList<JokeImageBean> dataList, Context context) {
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

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_joke_img, parent, false);
            holder = new ItemJokeImgHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ItemJokeImgHolder) convertView.getTag();
        }
        JokeImageBean jokeBean = dataList.get(position);

        holder.getItemJokeImgTime().setText(jokeBean.getCt());
        holder.getItemJokeImgTitle().setText(jokeBean.getTitle());
        x.image().bind(holder.getItemJokeImgContent(),jokeBean.getImg());
        return convertView;
    }
}
