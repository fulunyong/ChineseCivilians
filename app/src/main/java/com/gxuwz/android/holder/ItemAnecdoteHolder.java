package com.gxuwz.android.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxuwz.android.chinesecivilians.R;

public class ItemAnecdoteHolder {
    private TextView itemAnecdoteTitle;
    private TextView itemAnecdoteDescription;
    private ImageView itemAnecdoteImage;

    public ItemAnecdoteHolder(View view) {
        itemAnecdoteTitle = (TextView) view.findViewById(R.id.item_anecdote_title);
        itemAnecdoteDescription = (TextView) view.findViewById(R.id.item_anecdote_description);
        itemAnecdoteImage = (ImageView) view.findViewById(R.id.item_anecdote_image);
    }

    public TextView getItemAnecdoteTitle() {
        return itemAnecdoteTitle;
    }

    public ImageView getItemAnecdoteImage() {
        return itemAnecdoteImage;
    }

    public TextView getItemAnecdoteDescription() {
        return itemAnecdoteDescription;
    }
}
