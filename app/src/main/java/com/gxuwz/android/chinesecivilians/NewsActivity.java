package com.gxuwz.android.chinesecivilians;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxuwz.android.adapter.NewsFragmentAdapter;
import com.gxuwz.android.fragment.NewsAnecdoteFragment;
import com.gxuwz.android.fragment.NewsBelleFragment;
import com.gxuwz.android.fragment.NewsEntertainmentFragment;
import com.gxuwz.android.fragment.NewsSportsFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_news)
public class NewsActivity extends AppCompatActivity {

    @ViewInject(R.id.vp_news)
    private ViewPager mViewPager;

    private ArrayList<Fragment> fragmentList;

    private ArrayList<TextView> titles;

    @ViewInject(R.id.title_news_entertainment)
    private TextView title0;
    @ViewInject(R.id.title_news_sports)
    private TextView title1;
    @ViewInject(R.id.title_news_anecdote)
    private TextView title2;
    @ViewInject(R.id.title_news_belle)
    private TextView title3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //init Fragments
        initFragments();

        addListener();


    }

    /**
     *
     */
    private void addListener() {

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int index = 0; index < titles.size(); index++) {
                    titles.get(index).setBackgroundColor(0);
                    titles.get(index).setTextColor(Color.BLACK);
                }
                titles.get(position).setTextColor(Color.YELLOW);
                titles.get(position).setBackgroundColor(Color.BLUE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * init Fragment
     */
    private void initFragments() {
        fragmentList = new ArrayList<Fragment>();
        titles = new ArrayList<TextView>();

        fragmentList.add(new NewsEntertainmentFragment());
        titles.add(title0);
        fragmentList.add(new NewsSportsFragment());
        titles.add(title1);
        fragmentList.add(new NewsAnecdoteFragment());
        titles.add(title2);
        fragmentList.add(new NewsBelleFragment());
        titles.add(title3);

        mViewPager.setAdapter(new NewsFragmentAdapter(getSupportFragmentManager(), fragmentList));
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_news_entertainment:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.title_news_sports:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.title_news_anecdote:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.title_news_belle:
                mViewPager.setCurrentItem(3);
                break;
        }

    }

}
