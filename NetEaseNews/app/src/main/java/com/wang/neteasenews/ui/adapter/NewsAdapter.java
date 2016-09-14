package com.wang.neteasenews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 新闻界面适配器
 */
public class NewsAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    public NewsAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return  fragments.size() == 0 ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size() == 0 ? 0 :fragments.size();
    }
}
