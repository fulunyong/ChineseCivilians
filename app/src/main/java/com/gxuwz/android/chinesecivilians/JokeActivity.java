package com.gxuwz.android.chinesecivilians;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gxuwz.android.adapter.NewsFragmentAdapter;
import com.gxuwz.android.fragment.JokeImageFragment;
import com.gxuwz.android.fragment.JokeRouteImageFragment;
import com.gxuwz.android.fragment.JokeRouteTextFragment;
import com.gxuwz.android.fragment.JokeTextFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_joke)
public class JokeActivity extends AppCompatActivity {
    @ViewInject(R.id.vp_joke)
    private ViewPager mViewPager;

    @ViewInject(R.id.title_joke_text)
    private TextView textView0;
    @ViewInject(R.id.title_joke_image)
    private TextView textView1;
    @ViewInject(R.id.title_joke_route_text)
    private TextView textView2;
    @ViewInject(R.id.title_joke_route_image)
    private TextView textView3;

    private ArrayList<TextView> titles;
    private ArrayList<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initFragment();

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


    private void initFragment() {

        fragmentList = new ArrayList<Fragment>();
        titles = new ArrayList<TextView>();

        fragmentList.add(new JokeTextFragment());
        titles.add(textView0);
        fragmentList.add(new JokeImageFragment());
        titles.add(textView1);
        fragmentList.add(new JokeRouteTextFragment());
        titles.add(textView2);
        fragmentList.add(new JokeRouteImageFragment());
        titles.add(textView3);

        mViewPager.setAdapter(new NewsFragmentAdapter(getSupportFragmentManager(), fragmentList));

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_joke_text:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.title_joke_image:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.title_joke_route_text:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.title_joke_route_image:
                mViewPager.setCurrentItem(3);
                break;
        }

    }

}
