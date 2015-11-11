package com.gxuwz.android.chinesecivilians;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.gxuwz.android.adapter.MenuMainAdapter;
import com.gxuwz.android.configure.Functions;
import com.gxuwz.android.entity.MenuItemEntity;
import com.gxuwz.android.listener.MenuMainItemClickListener;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static final int DERAIL_ON = 1;

    private Functions mFunctions;

    private ArrayList<MenuItemEntity> menuList;

    private MenuMainAdapter adapter;

    @ViewInject(R.id.root_main)
    private View root;
    @ViewInject(R.id.gv_main_menu)
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);


        menuList = new ArrayList<MenuItemEntity>();
        adapter = new MenuMainAdapter(menuList, this);
        mGridView.setAdapter(adapter);

        //init Base Functions
        initBaseFunctions();

        //init pocket functions
        initPocketFunctions();
       //add Item  Listener
        addOnItemClickListener();


    }

    private void addOnItemClickListener(){
        mGridView.setOnItemClickListener(new MenuMainItemClickListener(menuList,MainActivity.this));
    }

    /**
     * init pocket functions
     */
    private void initPocketFunctions() {

        mFunctions = new Functions();

        BmobQuery<Functions> bmobQuery = new BmobQuery<Functions>();

        bmobQuery.findObjects(this, new FindListener<Functions>() {
            @Override
            public void onSuccess(List<Functions> list) {
                if (list != null && list.size() > 0) {
                    mFunctions = list.get(0);
                }
                if (mFunctions != null && mFunctions.getNewsDerail() == DERAIL_ON) {
                    MenuItemEntity news = new MenuItemEntity();
                    news.neme = ClientApplication.mResources.getString(R.string.item_menu_name_news);
                    news.actionClass=NewsActivity.class;
                    news.logoId = R.mipmap.news_logo;
                    menuList.add(news);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(int i, String s){
                mFunctions.setAdvertisementType(0);
                mFunctions.setNewsDerail(1);
                mFunctions.setWeatherDerail(1);
                Log.d("MainActivity", "onError:" + s);
            }
        });

    }

    /**
     * init base functions
     */
    private void initBaseFunctions() {

        MenuItemEntity entity = new MenuItemEntity();
        entity.logoId = R.mipmap.weather_logo;
        entity.actionClass=WeatherActivity.class;
        entity.neme = ClientApplication.mResources.getString(R.string.item_menu_name_weather);
        menuList.add(entity);

        MenuItemEntity joke = new MenuItemEntity();
        joke.logoId = R.mipmap.joke_logo;
        joke.actionClass=JokeActivity.class;
        joke.neme = ClientApplication.mResources.getString(R.string.item_menu_name_joke);
        menuList.add(joke);

    }


    public void startAnimClick(View view) {
        ObjectAnimator oa = ObjectAnimator.ofFloat(root, "rotationX", 0f, 360);
        oa.setRepeatCount(5);
        oa.setDuration(2000);
        ObjectAnimator oaY = ObjectAnimator.ofFloat(root, "rotationY", 0f, 360);
        oaY.setRepeatCount(5);
        oaY.setDuration(2000);

        AnimatorSet set = new AnimatorSet();
        set.play(oa).with(oaY);

        set.start();
    }
}
