package com.gxuwz.android.holder;

import android.view.View;
import android.widget.TextView;

import com.gxuwz.android.chinesecivilians.R;

public class ItemJokeTextHolder {
    private TextView itemJokeTextTitle;
    private TextView itemJokeTextTime;
    private TextView itemJokeTextContent;

    public ItemJokeTextHolder(View view) {
        itemJokeTextTitle = (TextView) view.findViewById(R.id.item_joke_text_title);
        itemJokeTextTime = (TextView) view.findViewById(R.id.item_joke_text_time);
        itemJokeTextContent = (TextView) view.findViewById(R.id.item_joke_text_content);
    }

    public TextView getItemJokeTextTitle() {
        return itemJokeTextTitle;
    }

    public TextView getItemJokeTextContent() {
        return itemJokeTextContent;
    }

    public TextView getItemJokeTextTime() {
        return itemJokeTextTime;
    }
}
