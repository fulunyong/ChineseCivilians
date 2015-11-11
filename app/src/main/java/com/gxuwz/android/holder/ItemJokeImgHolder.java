package com.gxuwz.android.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxuwz.android.chinesecivilians.R;

public class ItemJokeImgHolder {
    private TextView itemJokeImgTitle;
    private TextView itemJokeImgTime;
    private ImageView itemJokeImgContent;

    public ItemJokeImgHolder(View view) {
        itemJokeImgTitle = (TextView) view.findViewById(R.id.item_joke_img_title);
        itemJokeImgTime = (TextView) view.findViewById(R.id.item_joke_img_time);
        itemJokeImgContent = (ImageView) view.findViewById(R.id.item_joke_img_content);
    }

    public TextView getItemJokeImgTime() {
        return itemJokeImgTime;
    }

    public TextView getItemJokeImgTitle() {
        return itemJokeImgTitle;
    }

    public ImageView getItemJokeImgContent() {
        return itemJokeImgContent;
    }
}
