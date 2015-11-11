package com.gxuwz.android.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gxuwz.android.chinesecivilians.R;

public class ItemMenuHolder {
    private ImageView ivItemMenu;
    private TextView itemMenuTextName;

    public ItemMenuHolder(View view) {
        ivItemMenu = (ImageView) view.findViewById(R.id.iv_item_menu);
        itemMenuTextName = (TextView) view.findViewById(R.id.item_menu_text_name);
    }

    public ImageView getIvItemMenu() {
        return ivItemMenu;
    }

    public TextView getItemMenuTextName() {
        return itemMenuTextName;
    }
}
