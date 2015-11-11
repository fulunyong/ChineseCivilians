package com.gxuwz.android.listener;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.gxuwz.android.entity.MenuItemEntity;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/716:25.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class MenuMainItemClickListener implements AdapterView.OnItemClickListener{
    private ArrayList<MenuItemEntity> list;
    private Context context;

    public MenuMainItemClickListener(ArrayList<MenuItemEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,final int position, long id){

        ObjectAnimator rotation=ObjectAnimator.ofFloat(view,"rotation",0,360);
        rotation.setDuration(1000);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(rotation);

        animatorSet.addListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animation){
            }
            @Override
            public void onAnimationEnd(Animator animation){
                if (list.get(position).actionClass!=null){
                    context.startActivity(new Intent(context, list.get(position).actionClass));
                }
            }
            @Override
            public void onAnimationCancel(Animator animation){
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();

    }
}
