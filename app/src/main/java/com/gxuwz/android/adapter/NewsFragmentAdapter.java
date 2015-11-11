package com.gxuwz.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/717:08.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class NewsFragmentAdapter extends FragmentStatePagerAdapter{

    private ArrayList<Fragment> fragmentList;

    public NewsFragmentAdapter(FragmentManager fm) {
        super(fm);
        fragmentList=new ArrayList<Fragment>();
    }

    public NewsFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
