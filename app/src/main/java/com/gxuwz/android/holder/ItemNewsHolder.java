package com.gxuwz.android.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxuwz.android.chinesecivilians.R;

public class ItemNewsHolder {
    private TextView itemNewsTitle;
    private TextView itemNewsDescription;
    private TextView itemNewsTime;
    private ImageView itemNewsImage;

    public ItemNewsHolder(View view) {
        itemNewsTitle = (TextView) view.findViewById(R.id.item_news_title);
        itemNewsDescription = (TextView) view.findViewById(R.id.item_news_description);
        itemNewsTime = (TextView) view.findViewById(R.id.item_news_time);
        itemNewsImage = (ImageView) view.findViewById(R.id.item_news_image);
    }

    public ImageView getItemNewsImage() {
        return itemNewsImage;
    }

    public TextView getItemNewsTime() {
        return itemNewsTime;
    }

    public TextView getItemNewsTitle() {
        return itemNewsTitle;
    }

    public TextView getItemNewsDescription() {
        return itemNewsDescription;
    }
}
